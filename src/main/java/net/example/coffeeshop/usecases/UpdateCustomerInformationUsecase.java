package net.example.coffeeshop.usecases;

import net.example.coffeeshop.entrypoints.http.controllers.exceptions.CustomerNotExistException;
import net.example.coffeeshop.repositories.models.Customer;
import net.example.coffeeshop.usecases.dto.UpdateCustomerInformationDTO;
import net.example.coffeeshop.repositories.models.enums.Gender;
import net.example.coffeeshop.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class UpdateCustomerInformationUsecase {
    private final CustomerRepository customerRepository;

    public UpdateCustomerInformationUsecase(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public UpdateCustomerInformationDTO execute(Long customerId, Gender newGender, LocalDate newYearOfBirth) throws CustomerNotExistException {
        UpdateCustomerInformationDTO dto = new UpdateCustomerInformationDTO();
        Optional<Customer> customer = customerRepository.findById(customerId);
        if (customer.isEmpty()) {
            throw new CustomerNotExistException("Customer eith id = " + customerId + " not exist");
        }
        customerRepository.setGenderAndDateIfBirth(newYearOfBirth, newGender, customerId);
        dto.setMessage("Customer ID = " + customerId + " set new gender = " + newGender + " and new year of birth = " + newYearOfBirth);
        return dto;
    }
}
