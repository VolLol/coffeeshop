package net.example.coffeeshop.usecases.dto;

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
public class MonthlyReportDTO {

    @Getter
    private List<Sale> sales = new ArrayList<>();
    @Getter
    private BigDecimal allSpendMoney;
}
