package net.example.coffeeshop.entrypoints.http.controllers.response;

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
public class MonthlyReportByTelegramIdResponse {

    @Getter
    private BigDecimal spentInLastMonth;
    @Getter
    private Integer points;
    @Getter
    private List<MonthlyReportModel> report = new ArrayList<>();
}
