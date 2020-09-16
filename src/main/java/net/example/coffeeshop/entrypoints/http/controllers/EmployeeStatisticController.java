package net.example.coffeeshop.entrypoints.http.controllers;

import net.example.coffeeshop.entrypoints.http.controllers.response.AverageBillByLastMonthResponse;
import net.example.coffeeshop.entrypoints.http.controllers.response.AvgCountCustomerByGenderResponse;
import net.example.coffeeshop.entrypoints.http.controllers.response.AvgCountCustomersByLastPeriodResponse;
import net.example.coffeeshop.repositories.models.enums.Gender;
import net.example.coffeeshop.repositories.models.enums.Period;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/api/employee/statistics")
public class EmployeeStatisticController {


    @GetMapping("/getAvgCountCustomersByGender")
    @ResponseBody
    public AvgCountCustomerByGenderResponse getAvgCountCustomersByGender(@RequestParam(name = "gender") Gender gender) {
        return AvgCountCustomerByGenderResponse.builder()
                .avgCount(78191L)
                .message("You choose " + gender)
                .build();
    }

    @GetMapping("/getAverageBillByLastMonth")
    public AverageBillByLastMonthResponse getAverageBillByLastMonth(@RequestParam(name = "shopId") Long shopId) {
        return AverageBillByLastMonthResponse.builder()
                .avgBill(78237L)
                .shopId(shopId)
                .build();
    }


    @GetMapping("/getAvgCountCustomersByLastPeriod")
    public AvgCountCustomersByLastPeriodResponse getAvgCountCustomersByLastPeriod(@RequestParam(name = "shopId") Long shopId, @RequestParam(name = "period") Period period) {
        return AvgCountCustomersByLastPeriodResponse
                .builder()
                .avgCount(666L)
                .period(period)
                .shopId(shopId)
                .build();
    }
}
