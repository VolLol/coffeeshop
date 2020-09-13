package net.example.coffeeshop.entrypoints.http.controllers;

import net.example.coffeeshop.entrypoints.http.controllers.exceptions.CustomerAlreadyExistException;
import net.example.coffeeshop.usecases.dto.CustomerProfileDTO;
import net.example.coffeeshop.usecases.dto.RegistrationNewCustomerDTO;
import net.example.coffeeshop.entrypoints.http.controllers.response.MonthlyReportByTelegramIdResponse;
import net.example.coffeeshop.entrypoints.http.controllers.request.RegistrationNewCustomerRequest;
import net.example.coffeeshop.entrypoints.http.controllers.response.CustomerProfileResponse;
import net.example.coffeeshop.entrypoints.http.controllers.response.RegistrationNewCustomerResponse;
import net.example.coffeeshop.usecases.RegistrationNewCustomerUsecase;
import net.example.coffeeshop.usecases.ShowProfileUsecase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {

    private final RegistrationNewCustomerUsecase registrationNewCustomerUsecase;
    private final ShowProfileUsecase showProfileUsecase;


    public CustomerController(RegistrationNewCustomerUsecase registrationNewCustomerUsecase, ShowProfileUsecase showProfileUsecase) {
        this.registrationNewCustomerUsecase = registrationNewCustomerUsecase;
        this.showProfileUsecase = showProfileUsecase;
    }

    @PostMapping("v1/api/customer/registration")
    public ResponseEntity<RegistrationNewCustomerResponse> registrationNewCustomer(@RequestBody RegistrationNewCustomerRequest request) {
        RegistrationNewCustomerResponse response;
        try {
            RegistrationNewCustomerDTO dto = registrationNewCustomerUsecase.execute(request.getTelegramId());
            response = RegistrationNewCustomerResponse.builder()
                    .message(dto.getMessage())
                    .httpStatus(HttpStatus.CREATED)
                    .build();
        } catch (CustomerAlreadyExistException e) {
            response = RegistrationNewCustomerResponse.builder()
                    .message(e.getMessage())
                    .httpStatus(HttpStatus.BAD_REQUEST)
                    .build();
        }
        return ResponseEntity.status(response.getHttpStatus()).body(response);
    }

    @GetMapping("v1/api/customer/{telegramId}/profile")
    public CustomerProfileResponse showProfileByTelegramId(@PathVariable Long telegramId) {
        CustomerProfileDTO dto = showProfileUsecase.execute(telegramId);
        return CustomerProfileResponse.builder()
                .customerId(dto.getCustomerId())
                .telegramId(dto.getTelegramId())
                .points(dto.getPoints())
                .gender(dto.getGender())
                .yearOfBirth(dto.getYearOfBirth())
                .updateAt(dto.getUpdateAt())
                .createAt(dto.getCreateAt())
                .build();
    }

    @GetMapping("v1/api/customer/{telegramId}/monthlyReport")
    public MonthlyReportByTelegramIdResponse showMonthlyReportByTelegramId(@PathVariable Long telegramId) {
        return new MonthlyReportByTelegramIdResponse(37L);
    }

}
