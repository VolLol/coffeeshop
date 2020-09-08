package net.example.coffeeshop.usecases;

import net.example.coffeeshop.entities.Customer;
import net.example.coffeeshop.entrypoints.dto.RegistrationNewCustomerDTO;
import net.example.coffeeshop.entrypoints.enums.Gender;
import net.example.coffeeshop.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class RegistrationNewCustomerUsecase {

    private final CustomerRepository repository;

    public RegistrationNewCustomerUsecase(CustomerRepository repository) {
        this.repository = repository;
    }

    public RegistrationNewCustomerDTO execute(Long telegramId) {
        Customer customer = repository.findByTelegramId(telegramId);
        RegistrationNewCustomerDTO dto = new RegistrationNewCustomerDTO();
        if (customer == null) {
            dto.setMessage("Customer is not exist. Add new customer to db");
            Customer newCustomer = Customer.builder()
                    .telegramId(telegramId)
                    .createdAt(LocalDateTime.now())
                    .updatedAt(LocalDateTime.now())
                    .gender(Gender.UNKNOWN)
                    .build();
            repository.save(newCustomer);
        } else {
            dto.setMessage("Customer is exist");
        }
        return dto;
    }
}
