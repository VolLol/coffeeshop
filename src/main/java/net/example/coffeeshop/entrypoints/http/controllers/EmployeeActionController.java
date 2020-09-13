package net.example.coffeeshop.entrypoints.http.controllers;

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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
        UpdateCustomerInformationDTO dto = updateCustomerInformationUsecase.execute(
                request.getCustomerId(), request.getGender(), request.getDateOfBirth());
        return new CustomerPropertiesResponse(dto.getMessage());
    }


    @PostMapping("v1/api/employee/customers/addSale")
    public AddNewSaleResponse addSale(@RequestBody AddNewSaleRequest request) {
        AddSaleDTO dto = addSaleUsecase.execute(request.getCustomerId(), request.getShopId(), request.getPaid(), request.getReason());
        return new AddNewSaleResponse(dto.getMessage());
    }


    @PutMapping("v1/api/employee/giveOutFreeCup")
    public GiveOutFreeCupResponse giveOutFreeCup(@RequestBody GiveOutFreeCupRequest request) {
        GiveOutFreeCupDTO dto = giveOutFreeCupUsecase.execute(request.getCustomerId(), request.getShopId());
        return new GiveOutFreeCupResponse("Give out free cup for user " + request.getCustomerId() + " in the shop with id: " + request.getShopId());
    }
}
