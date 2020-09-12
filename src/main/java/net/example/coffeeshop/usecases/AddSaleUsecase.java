package net.example.coffeeshop.usecases;

import net.example.coffeeshop.entities.Customer;
import net.example.coffeeshop.entities.Sale;
import net.example.coffeeshop.entities.Shop;
import net.example.coffeeshop.entrypoints.dto.AddSaleDTO;
import net.example.coffeeshop.entrypoints.enums.Reason;
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

    public AddSaleDTO execute(Long customerId, Long shopId, BigDecimal paid, Reason reason) {
        AddSaleDTO dto = new AddSaleDTO();
        Optional<Customer> customer = customerRepository.findById(customerId);
        if (customer.isEmpty()) {
            dto.setMessage("Customer with id = " + customerId + " not exist");
        } else {
            Optional<Shop> shop = shopRepository.findById(shopId);
            if (shop.isEmpty()) {
                dto.setMessage("Shop with id = " + shopId + " not exist");
            } else {
                BigDecimal newPoints = paid.add(customer.get().getPoints());
                customerRepository.setPaid(newPoints, customerId, LocalDateTime.now());
                Sale sale = Sale.builder()
                        .customerId(customerId)
                        .shopId(shopId)
                        .paid(paid)
                        .reason(Reason.SALE)
                        .createdAt(LocalDateTime.now())
                        .build();
                saleRepository.save(sale);
                // поменять порядок для Optional
                dto.setMessage("Successful add sale for customer with id= " + customerId + " . Customer paid = " + newPoints);
            }
        }

        return dto;
    }
}
