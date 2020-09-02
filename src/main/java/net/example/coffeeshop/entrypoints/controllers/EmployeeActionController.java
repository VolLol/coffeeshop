package net.example.coffeeshop.entrypoints.controllers;

import net.example.coffeeshop.entrypoints.request.AddNewVisitRequest;
import net.example.coffeeshop.entrypoints.request.CustomerPropertiesRequest;
import net.example.coffeeshop.entrypoints.request.GiveOutFreeCupRequest;
import net.example.coffeeshop.entrypoints.response.AddNewVisitResponse;
import net.example.coffeeshop.entrypoints.response.CustomerPropertiesResponse;
import net.example.coffeeshop.entrypoints.response.GiveOutFreeCupResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeActionController {


    @PostMapping("v1/api/employee/customers/setProperties")
    public CustomerPropertiesResponse setCustomerProperties(@RequestBody CustomerPropertiesRequest request) {
        return new CustomerPropertiesResponse("For user " + request.getCustomerId() +
                " set gender : " + request.getGender() +
                " and date of birth " + request.getDateOfBirth());
    }


    @PostMapping("v1/api/employee/customers/addVisit")
    public AddNewVisitResponse addNewVisit(@RequestBody AddNewVisitRequest request) {
        return new AddNewVisitResponse("Add new visit for customer with id " + request.getCustomerId());
    }


    @PutMapping("v1/api/employee/giveOutFreeCup")
    public GiveOutFreeCupResponse giveOutFreeCup(@RequestBody GiveOutFreeCupRequest request) {
        return new GiveOutFreeCupResponse("Give out free cup for user " + request.getCustomerId() + " in the shop with id: " + request.getShopId());
    }
}
