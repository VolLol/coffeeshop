package net.example.coffeeshop.entrypoints.http.controllers;

import net.example.coffeeshop.entrypoints.http.controllers.exceptions.CustomerAlreadyExistException;
import net.example.coffeeshop.entrypoints.http.controllers.exceptions.CustomerHasNotSalesException;
import net.example.coffeeshop.entrypoints.http.controllers.exceptions.CustomerNotExistException;
import net.example.coffeeshop.usecases.MonthlyReportByTelegramIdUsecase;
import net.example.coffeeshop.usecases.dto.CustomerProfileDTO;
import net.example.coffeeshop.usecases.dto.MonthlyReportDTO;
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
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("v1/api/customer/")
public class CustomerController {

    private final RegistrationNewCustomerUsecase registrationNewCustomerUsecase;
    private final ShowProfileUsecase showProfileUsecase;
    private final MonthlyReportByTelegramIdUsecase monthlyReportByTelegramIdUsecase;

    public CustomerController(RegistrationNewCustomerUsecase registrationNewCustomerUsecase, ShowProfileUsecase showProfileUsecase, MonthlyReportByTelegramIdUsecase monthlyReportByTelegramIdUsecase) {
        this.registrationNewCustomerUsecase = registrationNewCustomerUsecase;
        this.showProfileUsecase = showProfileUsecase;
        this.monthlyReportByTelegramIdUsecase = monthlyReportByTelegramIdUsecase;
    }

    @PostMapping("/registration")
    public ResponseEntity<RegistrationNewCustomerResponse> registrationNewCustomer(@RequestBody RegistrationNewCustomerRequest request) {
        RegistrationNewCustomerResponse response;
        try {
            RegistrationNewCustomerDTO dto = registrationNewCustomerUsecase.execute(request.getTelegramId());
            response = RegistrationNewCustomerResponse.builder()
                    .message(dto.getMessage())
                    .build();
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (CustomerAlreadyExistException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
        }
    }

    @GetMapping("/{telegramId}/profile")
    public ResponseEntity<CustomerProfileResponse> showProfileByTelegramId(@PathVariable Long telegramId) {
        CustomerProfileDTO dto;
        try {
            dto = showProfileUsecase.execute(telegramId);
            CustomerProfileResponse response = CustomerProfileResponse.builder()
                    .customerId(dto.getCustomerId())
                    .telegramId(dto.getTelegramId())
                    .points(dto.getPoints())
                    .gender(dto.getGender())
                    .yearOfBirth(dto.getYearOfBirth())
                    .updateAt(dto.getUpdateAt())
                    .createAt(dto.getCreateAt())
                    .build();
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (CustomerNotExistException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
        }
    }

    @GetMapping("/{telegramId}/monthlyReport")
    public ResponseEntity<MonthlyReportByTelegramIdResponse> showMonthlyReportByTelegramId(@PathVariable Long telegramId) {
        try {
            MonthlyReportDTO dto = monthlyReportByTelegramIdUsecase.execute(telegramId);
            MonthlyReportByTelegramIdResponse response = MonthlyReportByTelegramIdResponse.builder()
                    .spentInLastMonth(dto.getAllSpendMoney())
                    .report(dto.getReport())
                    .points(dto.getPoints())
                    .build();
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (CustomerNotExistException | CustomerHasNotSalesException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
        }
    }

}
