package net.example.coffeeshop.usecases;

import net.example.coffeeshop.entrypoints.http.controllers.exceptions.CustomerNotExistException;
import net.example.coffeeshop.entrypoints.http.controllers.exceptions.ShopNotExistException;
import net.example.coffeeshop.repositories.models.Customer;
import net.example.coffeeshop.repositories.models.Sale;
import net.example.coffeeshop.repositories.models.Shop;
import net.example.coffeeshop.usecases.dto.AddSaleDTO;
import net.example.coffeeshop.repositories.models.enums.Reason;
import net.example.coffeeshop.repositories.CustomerRepository;
import net.example.coffeeshop.repositories.SaleRepository;
import net.example.coffeeshop.repositories.ShopRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class AddSaleUsecase {

    private final CustomerRepository customerRepository;
    private final ShopRepository shopRepository;
    private final SaleRepository saleRepository;

    public AddSaleUsecase(CustomerRepository customerRepository, ShopRepository shopRepository, SaleRepository saleRepository) {
        this.customerRepository = customerRepository;
        this.shopRepository = shopRepository;
        this.saleRepository = saleRepository;
    }

    public AddSaleDTO execute(Long customerId, Long shopId, BigDecimal paid) throws CustomerNotExistException, ShopNotExistException {
        AddSaleDTO dto = new AddSaleDTO();
        Optional<Customer> customer = customerRepository.findById(customerId);
        if (customer.isEmpty()) {
            throw new CustomerNotExistException("Customer with id = " + customerId + " not exist");
        }
        Optional<Shop> shop = shopRepository.findById(shopId);
        if (shop.isEmpty()) {
            throw new ShopNotExistException("Shop with id = " + shopId + " not exist");
        }
        Integer newCountOfPoints = customer.get().getPoints() + 1;
        customerRepository.setPoints(newCountOfPoints, customerId, LocalDateTime.now());
        Sale sale = Sale.builder()
                .customerId(customerId)
                .shopId(shopId)
                .paid(paid)
                .reason(Reason.SALE)
                .createdAt(LocalDateTime.now())
                .build();
        saleRepository.save(sale);
        dto.setMessage("Successful add sale for customer with id= " + customerId + " . Customer paid = " + paid);
        return dto;
    }
}
