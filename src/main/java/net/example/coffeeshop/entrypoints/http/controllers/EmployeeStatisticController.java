package net.example.coffeeshop.entrypoints.http.controllers;

import net.example.coffeeshop.entrypoints.http.controllers.exceptions.ShopNotExistException;
import net.example.coffeeshop.entrypoints.http.controllers.response.AverageBillByLastMonthResponse;
import net.example.coffeeshop.entrypoints.http.controllers.response.AvgCountCustomerByGenderResponse;
import net.example.coffeeshop.entrypoints.http.controllers.response.AvgCountCustomersByLastPeriodResponse;
import net.example.coffeeshop.repositories.models.enums.Period;
import net.example.coffeeshop.usecases.AverageBillByLastMonthUsecase;
import net.example.coffeeshop.usecases.AvgCountCustomerByGenderUsecase;
import net.example.coffeeshop.usecases.dto.AvgBillByLastMonthDTO;
import net.example.coffeeshop.usecases.dto.AvgCountCustomerByGenderDTO;
import net.example.coffeeshop.usecases.exceptions.IncorrectGenderException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("v1/api/employee/statistics")
public class EmployeeStatisticController {

    private final AvgCountCustomerByGenderUsecase avgCountCustomerByGenderUsecase;
    private final AverageBillByLastMonthUsecase averageBillByLastMonthUsecase;

    public EmployeeStatisticController(AvgCountCustomerByGenderUsecase avgCountCustomerByGenderUsecase, AverageBillByLastMonthUsecase averageBillByLastMonthUsecase) {
        this.avgCountCustomerByGenderUsecase = avgCountCustomerByGenderUsecase;
        this.averageBillByLastMonthUsecase = averageBillByLastMonthUsecase;
    }

    @GetMapping("/getAvgCountCustomersByGender")
    @ResponseBody
    public AvgCountCustomerByGenderResponse getAvgCountCustomersByGender(@RequestParam(name = "gender") String gender) {
        try {
            AvgCountCustomerByGenderDTO dto = avgCountCustomerByGenderUsecase.execute(gender.toUpperCase());
            return AvgCountCustomerByGenderResponse.builder()
                    .avgCount(dto.getCount())
                    .message("You choose " + gender)
                    .build();
        } catch (IncorrectGenderException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
        }
    }

    @GetMapping("/getAverageBillByLastMonth")
    public AverageBillByLastMonthResponse getAverageBillByLastMonth(@RequestParam(name = "shopId") Long shopId) {
        try {
            AvgBillByLastMonthDTO dto = averageBillByLastMonthUsecase.execute(shopId);
            return AverageBillByLastMonthResponse.builder()
                    .avgBill(dto.getAvgBill())
                    .shopId(shopId)
                    .build();
        } catch (ShopNotExistException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
        }
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
