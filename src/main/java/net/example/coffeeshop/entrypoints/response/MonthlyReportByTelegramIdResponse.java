package net.example.coffeeshop.entrypoints.response;

import lombok.Getter;

public class MonthlyReportByTelegramIdResponse {

    public MonthlyReportByTelegramIdResponse(Long spentInLastMonth) {
        this.spentInLastMonth = spentInLastMonth;
    }

    @Getter
    private Long spentInLastMonth;
}
