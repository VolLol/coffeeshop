package net.example.coffeeshop.response;

import lombok.Getter;

public class MonthlyReportByTelegramIdResponse {

    public MonthlyReportByTelegramIdResponse(Long spentInLastMonth) {
        this.spentInLastMonth = spentInLastMonth;
    }

    @Getter
    private Long spentInLastMonth;
}
