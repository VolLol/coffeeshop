package net.example.coffeeshop.usecases;

import net.example.coffeeshop.entrypoints.http.controllers.exceptions.CustomerHasNotEnoughPointsException;
import net.example.coffeeshop.entrypoints.http.controllers.exceptions.CustomerNotExistException;
import net.example.coffeeshop.entrypoints.http.controllers.exceptions.ShopNotExistException;
import net.example.coffeeshop.repositories.models.Customer;
import net.example.coffeeshop.repositories.models.Sale;
import net.example.coffeeshop.repositories.models.Shop;
import net.example.coffeeshop.repositories.models.enums.Reason;
import net.example.coffeeshop.usecases.dto.GiveOutFreeCupDTO;
import net.example.coffeeshop.repositories.CustomerRepository;
import net.example.coffeeshop.repositories.SaleRepository;
import net.example.coffeeshop.repositories.ShopRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class GiveOutFreeCupUsecase {

    private final CustomerRepository customerRepository;
    private final ShopRepository shopRepository;
    private final SaleRepository saleRepository;

    public GiveOutFreeCupUsecase(CustomerRepository customerRepository, ShopRepository shopRepository, SaleRepository saleRepository) {
        this.customerRepository = customerRepository;
        this.shopRepository = shopRepository;
        this.saleRepository = saleRepository;
    }


    public GiveOutFreeCupDTO execute(Long customerId, Long shopId) throws CustomerNotExistException, ShopNotExistException, CustomerHasNotEnoughPointsException {
        GiveOutFreeCupDTO dto = new GiveOutFreeCupDTO();
        Optional<Customer> customer = customerRepository.findById(customerId);
        if (customer.isEmpty()) {
            throw new CustomerNotExistException("Customer with id = " + customerId + " not exist");
        }

        Optional<Shop> shop = shopRepository.findById(shopId);
        if (shop.isEmpty()) {
            throw new ShopNotExistException("Shop with id = " + shopId + " not exist");
        }
        if (customer.get().getPoints() < 12) {
            throw new CustomerHasNotEnoughPointsException("Customer with id = " + customerId + " have not enough points for free cup");
        }
        dto.setMessage("Give out free cup for user " + customerId + " in the shop with id: " + shopId);
        Integer newPoints = customer.get().getPoints() - 12;
        customerRepository.setPoints(newPoints, customerId, LocalDateTime.now());
        Sale sale = Sale.builder()
                .customerId(customerId)
                .paid(BigDecimal.valueOf(0))
                .reason(Reason.FREE)
                .shopId(shopId)
                .createdAt(LocalDateTime.now())
                .build();
        saleRepository.save(sale);
        return dto;
    }
}
