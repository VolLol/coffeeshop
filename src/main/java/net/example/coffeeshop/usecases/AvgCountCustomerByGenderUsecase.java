package net.example.coffeeshop.usecases;

import net.example.coffeeshop.repositories.CustomerRepository;
import net.example.coffeeshop.repositories.models.enums.Gender;
import net.example.coffeeshop.usecases.dto.AvgCountCustomerByGenderDTO;
import net.example.coffeeshop.usecases.exceptions.IncorrectGenderException;
import org.springframework.stereotype.Service;

@Service
public class AvgCountCustomerByGenderUsecase {

    private final CustomerRepository customerRepository;

    public AvgCountCustomerByGenderUsecase(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public AvgCountCustomerByGenderDTO execute(String genderString) throws IncorrectGenderException {
        Gender gender = valueOfGender(genderString);
        long countOfCustomersByGender = customerRepository.countByGender(gender);
        return AvgCountCustomerByGenderDTO.builder()
                .count(countOfCustomersByGender).build();
    }

    public Gender valueOfGender(String genderString) throws IncorrectGenderException {
        for (Gender e : Gender.values()) {
            if (e.name().equals(genderString)) {
                return e;
            }
        }
        throw new IncorrectGenderException("Gender " + genderString + " does not exist");
    }
}
