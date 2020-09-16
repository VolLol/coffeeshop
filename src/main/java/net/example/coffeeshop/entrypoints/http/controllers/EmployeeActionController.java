package net.example.coffeeshop.entrypoints.http.controllers;

import net.example.coffeeshop.entrypoints.http.controllers.exceptions.CustomerHasNotEnoughPointsException;
import net.example.coffeeshop.entrypoints.http.controllers.exceptions.CustomerNotExistException;
import net.example.coffeeshop.entrypoints.http.controllers.exceptions.ShopNotExistException;
import net.example.coffeeshop.usecases.dto.AddSaleDTO;
import net.example.coffeeshop.usecases.dto.GiveOutFreeCupDTO;
import net.example.coffeeshop.usecases.dto.UpdateCustomerInformationDTO;
import net.example.coffeeshop.entrypoints.http.controllers.request.AddNewSaleRequest;
import net.example.coffeeshop.entrypoints.http.controllers.request.CustomerPropertiesRequest;
import net.example.coffeeshop.entrypoints.http.controllers.request.GiveOutFreeCupRequest;
import net.example.coffeeshop.entrypoints.http.controllers.response.AddNewSaleResponse;
import net.example.coffeeshop.entrypoints.http.controllers.response.CustomerPropertiesResponse;
import net.example.coffeeshop.entrypoints.http.controllers.response.GiveOutFreeCupResponse;
import net.example.coffeeshop.usecases.AddSaleUsecase;
import net.example.coffeeshop.usecases.GiveOutFreeCupUsecase;
import net.example.coffeeshop.usecases.UpdateCustomerInformationUsecase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class EmployeeActionController {

    private final UpdateCustomerInformationUsecase updateCustomerInformationUsecase;
    private final AddSaleUsecase addSaleUsecase;
    private final GiveOutFreeCupUsecase giveOutFreeCupUsecase;

    public EmployeeActionController(UpdateCustomerInformationUsecase updateCustomerInformationUsecase, AddSaleUsecase addSaleUsecase, GiveOutFreeCupUsecase giveOutFreeCupUsecase) {
        this.updateCustomerInformationUsecase = updateCustomerInformationUsecase;
        this.addSaleUsecase = addSaleUsecase;
        this.giveOutFreeCupUsecase = giveOutFreeCupUsecase;
    }

    @PostMapping("v1/api/employee/customers/setProperties")
    public CustomerPropertiesResponse setCustomerProperties(@RequestBody CustomerPropertiesRequest request) {
        try {
            UpdateCustomerInformationDTO dto = updateCustomerInformationUsecase.execute(
                    request.getCustomerId(), request.getGender(), request.getDateOfBirth());
            return CustomerPropertiesResponse.builder().message(dto.getMessage()).build();
        } catch (CustomerNotExistException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
        }
    }


    @PostMapping("v1/api/employee/customers/addSale")
    public AddNewSaleResponse addSale(@RequestBody AddNewSaleRequest request) {
        try {
            AddSaleDTO dto = addSaleUsecase.execute(request.getCustomerId(), request.getShopId(), request.getPaid());
            return new AddNewSaleResponse(dto.getMessage());
        } catch (CustomerNotExistException | ShopNotExistException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
        }

    }


    @PutMapping("v1/api/employee/giveOutFreeCup")
    public ResponseEntity<GiveOutFreeCupResponse> giveOutFreeCup(@RequestBody GiveOutFreeCupRequest request) {
        try {
            GiveOutFreeCupDTO dto = giveOutFreeCupUsecase.execute(request.getCustomerId(), request.getShopId());
            GiveOutFreeCupResponse response = GiveOutFreeCupResponse.builder().message(dto.getMessage()).build();
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (CustomerNotExistException | ShopNotExistException | CustomerHasNotEnoughPointsException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
        }
    }
}
