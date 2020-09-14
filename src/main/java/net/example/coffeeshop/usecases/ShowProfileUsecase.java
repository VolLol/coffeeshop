package net.example.coffeeshop.usecases;

import net.example.coffeeshop.entrypoints.http.controllers.exceptions.CustomerNotExistException;
import net.example.coffeeshop.repositories.models.Customer;
import net.example.coffeeshop.usecases.dto.CustomerProfileDTO;
import net.example.coffeeshop.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class ShowProfileUsecase {

    private final CustomerRepository customerRepository;


    public ShowProfileUsecase(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public CustomerProfileDTO execute(Long telegramId) throws CustomerNotExistException {
        CustomerProfileDTO dto;
        try {
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
        } catch (NullPointerException e) {
            throw new CustomerNotExistException("Customer with id = " + telegramId + " not exist");
        }
    }
}
