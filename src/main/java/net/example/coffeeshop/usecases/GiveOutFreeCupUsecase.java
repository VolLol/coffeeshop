package net.example.coffeeshop.usecases;

import net.example.coffeeshop.repositories.models.Customer;
import net.example.coffeeshop.repositories.models.Shop;
import net.example.coffeeshop.usecases.dto.GiveOutFreeCupDTO;
import net.example.coffeeshop.repositories.CustomerRepository;
import net.example.coffeeshop.repositories.SaleRepository;
import net.example.coffeeshop.repositories.ShopRepository;
import org.springframework.stereotype.Service;

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


    public GiveOutFreeCupDTO execute(Long customerId, Long shopId) {
        GiveOutFreeCupDTO dto = new GiveOutFreeCupDTO();
        Optional<Customer> customer = customerRepository.findById(customerId);
        if (!customer.isEmpty()) {
            Optional<Shop> shop = shopRepository.findById(shopId);
            if (!shop.isEmpty()) {
                //проверить колличество очков у пользователя
                //создать новую продажу
                //сделать списание очков

            } else {
                dto.setMessage("Shop with id = " + shopId + " not exist");
            }
        } else {
            dto.setMessage("Customer with id = " + customerId + " not exist");
        }


        return dto;
    }
}
