package net.example.coffeeshop.usecases;

import net.example.coffeeshop.entrypoints.http.controllers.exceptions.CustomerHasNotSalesException;
import net.example.coffeeshop.entrypoints.http.controllers.exceptions.CustomerNotExistException;
import net.example.coffeeshop.repositories.CustomerRepository;
import net.example.coffeeshop.repositories.SaleRepository;
import net.example.coffeeshop.repositories.ShopRepository;
import net.example.coffeeshop.repositories.models.Customer;
import net.example.coffeeshop.entrypoints.http.controllers.response.models.MonthlyReportModel;
import net.example.coffeeshop.repositories.models.Sale;
import net.example.coffeeshop.repositories.models.Shop;
import net.example.coffeeshop.usecases.dto.MonthlyReportDTO;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

@Service
public class MonthlyReportByTelegramIdUsecase {

    private final CustomerRepository customerRepository;
    private final SaleRepository saleRepository;
    private final ShopRepository shopRepository;

    public MonthlyReportByTelegramIdUsecase(CustomerRepository customerRepository, SaleRepository saleRepository, ShopRepository shopRepository) {
        this.customerRepository = customerRepository;
        this.saleRepository = saleRepository;
        this.shopRepository = shopRepository;
    }


    public MonthlyReportDTO execute(Long telegramId) throws CustomerNotExistException, CustomerHasNotSalesException {
        MonthlyReportDTO dto;
        Customer customer = customerRepository.findByTelegramId(telegramId);
        if (customer == null) {
            throw new CustomerNotExistException("Customer with telegram id = " + telegramId + " not exist");
        }
        Long customerId = customer.getId();
        List<Sale> lastMonthSales = saleRepository.findAllByCustomerIdAndCreatedAtGreaterThan(customerId, LocalDateTime.now().minusMonths(1L));
        if (lastMonthSales.isEmpty()) {
            throw new CustomerHasNotSalesException("Customer with id = " + customerId + " has not sales");
        } else {

            dto = MonthlyReportDTO.builder().report(prepareReport(lastMonthSales))
                    .allSpendMoney(calculateAllMoneySpent(lastMonthSales))
                    .points(customer.getPoints())
                    .build();
        }

        return dto;
    }

    private BigDecimal calculateAllMoneySpent(List<Sale> lastMonthSales) {
        BigDecimal allSpendMoney = new BigDecimal(0.00);
        for (Sale sale : lastMonthSales) {
            allSpendMoney = allSpendMoney.add(sale.getPaid());
        }
        return allSpendMoney;
    }

    private List<MonthlyReportModel> prepareReport(List<Sale> lastMonthSales) {
        List<MonthlyReportModel> report = new ArrayList<>();
        HashMap<Long, BigDecimal> allSales = new HashMap<>();
        for (Sale sale : lastMonthSales) {
            BigDecimal paid = sale.getPaid();
            Long shopId = sale.getShopId();
            if (allSales.containsKey(shopId)) {
                BigDecimal contains = allSales.get(shopId);
                BigDecimal result = contains.add(paid);
                allSales.remove(shopId);
                allSales.put(shopId, result);
            } else {
                allSales.put(shopId, paid);
            }
        }
        for (Map.Entry entry : allSales.entrySet()) {
            Optional<Shop> shop = shopRepository.findById((Long) entry.getKey());
            MonthlyReportModel model = MonthlyReportModel.builder()
                    .shopId((Long) entry.getKey())
                    .shopAddress(shop.get().getAddress())
                    .spentMoney((BigDecimal) entry.getValue())
                    .build();
            report.add(model);
        }
        return report;
    }

}
