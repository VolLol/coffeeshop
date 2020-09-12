package net.example.coffeeshop.usecases;

import net.example.coffeeshop.entities.Customer;
import net.example.coffeeshop.entrypoints.dto.UpdateCustomerInformationDTO;
import net.example.coffeeshop.entrypoints.enums.Gender;
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

    public UpdateCustomerInformationDTO execute(Long customerId, Gender newGender, LocalDate newYearOfBirth) {
        UpdateCustomerInformationDTO dto = new UpdateCustomerInformationDTO();
        Optional<Customer> customer = customerRepository.findById(customerId);
        if (customer.isEmpty()) {
            dto.setMessage("Customer ID = " + customerId + " not found ");
        } else {
            customerRepository.setGenderAndDateIfBirth(newYearOfBirth, newGender, customerId);
            dto.setMessage("Customer ID = " + customerId + " set new gender = " + newGender + " and new year of birth = " + newYearOfBirth);
        }
        return dto;
    }
}
