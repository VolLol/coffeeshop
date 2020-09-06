package net.example.coffeeshop.entrypoints.usecases;

import net.example.coffeeshop.entities.Customer;
import net.example.coffeeshop.entrypoints.response.CustomerProfileResponse;
import net.example.coffeeshop.repositories.CustomerRepository;
import org.springframework.stereotype.Component;

@Component
public class ShowProfileUsecase {

    private final CustomerRepository customerRepository;


    public ShowProfileUsecase(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public CustomerProfileResponse execute(Long telegramId) {
        CustomerProfileResponse response;
        Customer customer = customerRepository.findByTelegramId(telegramId);
        response = CustomerProfileResponse.builder()
                .customerId(customer.getId())
                .telegramId(customer.getTelegramId())
                .yearOfBirth(customer.getYearOfBirth())
                .gender(customer.getGender())
                .points(customer.getPoints())
                .createAt(customer.getCreatedAt())
                .updateAt(customer.getUpdatedAt())
                .build();
        return response;
    }
}
