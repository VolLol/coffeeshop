package net.example.coffeeshop.usecases;

import net.example.coffeeshop.entrypoints.http.controllers.exceptions.CustomerAlreadyExistException;
import net.example.coffeeshop.repositories.models.Customer;
import net.example.coffeeshop.usecases.dto.RegistrationNewCustomerDTO;
import net.example.coffeeshop.repositories.models.enums.Gender;
import net.example.coffeeshop.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class RegistrationNewCustomerUsecase {

    private final CustomerRepository repository;

    public RegistrationNewCustomerUsecase(CustomerRepository repository) {
        this.repository = repository;
    }

    public RegistrationNewCustomerDTO execute(Long telegramId) throws CustomerAlreadyExistException {
        Customer customer = repository.findByTelegramId(telegramId);
        RegistrationNewCustomerDTO dto = new RegistrationNewCustomerDTO();
        if (customer == null) {
            dto.setMessage("Customer is not exist. Add new customer to db");
            Customer newCustomer = Customer.builder()
                    .telegramId(telegramId)
                    .createdAt(LocalDateTime.now())
                    .updatedAt(LocalDateTime.now())
                    .gender(Gender.UNKNOWN)
                    .points(0)
                    .build();
            repository.save(newCustomer);
            return dto;
        } else {
            throw new CustomerAlreadyExistException("Customer is already exist");
        }
    }
}
