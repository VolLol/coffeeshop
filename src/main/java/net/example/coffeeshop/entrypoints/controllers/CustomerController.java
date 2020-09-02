package net.example.coffeeshop.entrypoints.controllers;

import net.example.coffeeshop.entrypoints.response.MonthlyReportByTelegramIdResponse;
import net.example.coffeeshop.entrypoints.enums.Gender;
import net.example.coffeeshop.entrypoints.request.RegistrationNewCustomerRequest;
import net.example.coffeeshop.entrypoints.response.CustomerProfileResponse;
import net.example.coffeeshop.entrypoints.response.RegistrationNewCustomerResponse;
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
        return CustomerProfileResponse.builder()
                .customerId(782374L)
                .telegramId(telegramId)
                .gender(Gender.MALE)
                .points(7623)
                .yearOfBirth(LocalDate.of(1995, 12, 10))
                .createAt(LocalDateTime.now())
                .updateAt(LocalDateTime.now().minusDays(10L))
                .build();
    }

    @GetMapping("v1/api/customer/{telegramId}/monthlyReport")
    public MonthlyReportByTelegramIdResponse showMonthlyReportByTelegramId(@PathVariable Long telegramId) {
        return new MonthlyReportByTelegramIdResponse(37L);
    }

}
