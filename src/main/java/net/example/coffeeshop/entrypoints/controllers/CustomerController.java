package net.example.coffeeshop.entrypoints.controllers;

import net.example.coffeeshop.entrypoints.response.MonthlyReportByTelegramIdResponse;
import net.example.coffeeshop.entrypoints.request.RegistrationNewCustomerRequest;
import net.example.coffeeshop.entrypoints.response.CustomerProfileResponse;
import net.example.coffeeshop.entrypoints.response.RegistrationNewCustomerResponse;
import net.example.coffeeshop.entrypoints.usecases.RegistrationNewCustomerUsecase;
import net.example.coffeeshop.entrypoints.usecases.ShowProfileUsecase;
import net.example.coffeeshop.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {

    private final CustomerRepository customerRepository;

    private final RegistrationNewCustomerUsecase registrationNewCustomerUsecase;


    private final ShowProfileUsecase showProfileUsecase;


    public CustomerController(CustomerRepository customerRepository, RegistrationNewCustomerUsecase registrationNewCustomerUsecase, ShowProfileUsecase showProfileUsecase) {
        this.customerRepository = customerRepository;
        this.registrationNewCustomerUsecase = registrationNewCustomerUsecase;
        this.showProfileUsecase = showProfileUsecase;
    }

    @PostMapping("v1/api/customer/registration")
    public RegistrationNewCustomerResponse registrationNewCustomer(@RequestBody RegistrationNewCustomerRequest request) {
        RegistrationNewCustomerResponse response = registrationNewCustomerUsecase.execute(request.getTelegramId());
        return response;
    }

    @GetMapping("v1/api/customer/{telegramId}/profile")
    public CustomerProfileResponse showProfileByTelegramId(@PathVariable Long telegramId) {
        CustomerProfileResponse response = showProfileUsecase.execute(telegramId);
        return response;
    }

    @GetMapping("v1/api/customer/{telegramId}/monthlyReport")
    public MonthlyReportByTelegramIdResponse showMonthlyReportByTelegramId(@PathVariable Long telegramId) {
        return new MonthlyReportByTelegramIdResponse(37L);
    }

}
