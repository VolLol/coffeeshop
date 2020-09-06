package net.example.coffeeshop.entrypoints.usecases;

import net.example.coffeeshop.entities.Customer;
import net.example.coffeeshop.entrypoints.response.RegistrationNewCustomerResponse;
import net.example.coffeeshop.repositories.CustomerRepository;
import org.springframework.stereotype.Component;

@Component
public class RegistrationNewCustomerUsecase {

    private final CustomerRepository repository;

    public RegistrationNewCustomerUsecase(CustomerRepository repository) {
        this.repository = repository;
    }

    public RegistrationNewCustomerResponse execute(Long telegramId) {
        Customer customer = repository.findByTelegramId(telegramId);
        RegistrationNewCustomerResponse response = new RegistrationNewCustomerResponse();
        if (customer == null) {
            response.setMessage("Customer is not exist. Add new customer to db");
            Customer newCustomer = new Customer();
            newCustomer.setTelegramId(telegramId);
            repository.save(newCustomer);
        } else {
            response.setMessage("Customer is exist");
        }
        return response;
    }
}
