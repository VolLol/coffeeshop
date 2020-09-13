package net.example.coffeeshop.entrypoints.http.controllers.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import net.example.coffeeshop.repositories.models.Sale;

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
    private List<Sale> sales = new ArrayList<>();
}
