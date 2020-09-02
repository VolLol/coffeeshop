package net.example.coffeeshop.entrypoints.controllers;

import net.example.coffeeshop.entrypoints.response.AverageBillByLastMonthResponse;
import net.example.coffeeshop.entrypoints.response.AvgCountCustomerByGenderResponse;
import net.example.coffeeshop.entrypoints.response.AvgCountCustomersByLastPeriodResponse;
import net.example.coffeeshop.entrypoints.enums.Gender;
import net.example.coffeeshop.entrypoints.enums.Period;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeStatisticController {


    @GetMapping("v1/api/employee/statistics/getAvgCountCustomersByGender")
    @ResponseBody
    public AvgCountCustomerByGenderResponse getAvgCountCustomersByGender(@RequestParam(name = "gender") Gender gender) {
        return AvgCountCustomerByGenderResponse.builder()
                .avgCount(78191L)
                .message("You choose " + gender)
                .build();
    }

    @GetMapping("v1/api/employee/statistics/getAverageBillByLastMonth")
    public AverageBillByLastMonthResponse getAverageBillByLastMonth(@RequestParam(name = "shopId") Long shopId) {
        return AverageBillByLastMonthResponse.builder()
                .avgBill(78237L)
                .shopId(shopId)
                .build();
    }


    @GetMapping("v1/api/employee/statistics/getAvgCountCustomersByLastPeriod")
    public AvgCountCustomersByLastPeriodResponse getAvgCountCustomersByLastPeriod(@RequestParam(name = "shopId") Long shopId, @RequestParam(name = "period") Period period) {
        return AvgCountCustomersByLastPeriodResponse
                .builder()
                .avgCount(666L)
                .period(period)
                .shopId(shopId)
                .build();
    }
}
