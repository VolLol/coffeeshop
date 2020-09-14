package net.example.coffeeshop.usecases.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import net.example.coffeeshop.entrypoints.http.controllers.response.models.MonthlyReportModel;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MonthlyReportDTO {

    @Getter
    private List<MonthlyReportModel> report = new ArrayList<>();
    @Getter
    private BigDecimal allSpendMoney;
    @Getter
    private Integer points;
}
