package net.example.coffeeshop.controllers;

import net.example.coffeeshop.response.AverageBillByLastMonthResponse;
import net.example.coffeeshop.response.AvgCountCustomerByGenderResponse;
import net.example.coffeeshop.response.AvgCountCustomersByLastPeriodResponse;
import net.example.coffeeshop.enums.Gender;
import net.example.coffeeshop.enums.Period;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeStatisticController {


    @GetMapping("v1/api/employee/statistics/getAvgCountCustomersByGender")
    @ResponseBody
    public AvgCountCustomerByGenderResponse getAvgCountCustomersByGender(@RequestParam(name = "gender") Gender gender) {
        AvgCountCustomerByGenderResponse response = AvgCountCustomerByGenderResponse.builder()
                .avgCount(78191L)
                .message("You choose " + gender)
                .build();
        return response;
    }

    @GetMapping("v1/api/employee/statistics/getAverageBillByLastMonth")
    public AverageBillByLastMonthResponse getAverageBillByLastMonth(@RequestParam(name = "shopId") Long shopId) {
        AverageBillByLastMonthResponse response = AverageBillByLastMonthResponse.builder()
                .avgBill(78237L)
                .shopId(shopId)
                .build();
        return response;
    }


    @GetMapping("v1/api/employee/statistics/getAvgCountCustomersByLastPeriod")
    public AvgCountCustomersByLastPeriodResponse getAvgCountCustomersByLastPeriod(@RequestParam(name = "shopId") Long shopId, @RequestParam(name = "period") Period period) {
        AvgCountCustomersByLastPeriodResponse response = AvgCountCustomersByLastPeriodResponse
                .builder()
                .avgCount(666L)
                .period(period)
                .shopId(shopId)
                .build();
        return response;
    }
}
