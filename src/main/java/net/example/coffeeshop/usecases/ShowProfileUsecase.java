package net.example.coffeeshop.usecases;

import net.example.coffeeshop.entities.Customer;
import net.example.coffeeshop.entrypoints.dto.CustomerProfileDTO;
import net.example.coffeeshop.entrypoints.response.CustomerProfileResponse;
import net.example.coffeeshop.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class ShowProfileUsecase {

    private final CustomerRepository customerRepository;


    public ShowProfileUsecase(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public CustomerProfileDTO execute(Long telegramId) {
        CustomerProfileDTO dto;
        Customer customer = customerRepository.findByTelegramId(telegramId);
        dto = CustomerProfileDTO.builder()
                .customerId(customer.getId())
                .telegramId(customer.getTelegramId())
                .yearOfBirth(customer.getYearOfBirth())
                .gender(customer.getGender())
                .points(customer.getPoints())
                .createAt(customer.getCreatedAt())
                .updateAt(customer.getUpdatedAt())
                .build();
        return dto;
    }
}
