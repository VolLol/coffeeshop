package net.example.coffeeshop.controllers;

import net.example.coffeeshop.response.MonthlyReportByTelegramIdResponse;
import net.example.coffeeshop.enums.Gender;
import net.example.coffeeshop.request.RegistrationNewCustomerRequest;
import net.example.coffeeshop.response.CustomerProfileResponse;
import net.example.coffeeshop.response.RegistrationNewCustomerResponse;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@RestController
public class CustomerController {


    @PostMapping("v1/api/customer/registration")
    public RegistrationNewCustomerResponse registrationNewCustomer(@RequestBody RegistrationNewCustomerRequest request) {
        return new RegistrationNewCustomerResponse("Customer " + request.getTelegramId() + " successful create");
    }

    @GetMapping("v1/api/customer/{telegramId}/profile")
    public CustomerProfileResponse showProfileByTelegramId(@PathVariable Long telegramId) {
        CustomerProfileResponse profile = CustomerProfileResponse.builder()
                .customerId(782374L)
                .telegramId(telegramId)
                .gender(Gender.MALE)
                .points(7623)
                .yearOfBirth(LocalDate.of(1995, 12, 10))
                .createAt(LocalDateTime.now())
                .updateAt(LocalDateTime.now().minusDays(10L))
                .build();
        return profile;
    }

    @GetMapping("v1/api/customer/{telegramId}/monthlyReport")
    public MonthlyReportByTelegramIdResponse showMonthlyReportByTelegramId(@PathVariable Long telegramId) {
        return new MonthlyReportByTelegramIdResponse(37L);
    }

}
