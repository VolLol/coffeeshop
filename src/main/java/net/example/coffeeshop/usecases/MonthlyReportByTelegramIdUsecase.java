package net.example.coffeeshop.usecases;

import net.example.coffeeshop.entrypoints.http.controllers.exceptions.CustomerHasNotSalesException;
import net.example.coffeeshop.entrypoints.http.controllers.exceptions.CustomerNotExistException;
import net.example.coffeeshop.repositories.CustomerRepository;
import net.example.coffeeshop.repositories.SaleRepository;
import net.example.coffeeshop.repositories.models.Customer;
import net.example.coffeeshop.repositories.models.Sale;
import net.example.coffeeshop.usecases.dto.MonthlyReportDTO;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class MonthlyReportByTelegramIdUsecase {

    private final CustomerRepository customerRepository;
    private final SaleRepository saleRepository;

    public MonthlyReportByTelegramIdUsecase(CustomerRepository customerRepository, SaleRepository saleRepository) {
        this.customerRepository = customerRepository;
        this.saleRepository = saleRepository;
    }


    public MonthlyReportDTO execute(Long telegramId) throws CustomerNotExistException, CustomerHasNotSalesException {
        MonthlyReportDTO dto;
        Customer customer = customerRepository.findByTelegramId(telegramId);
        if (customer == null) {
            throw new CustomerNotExistException("Customer with telegram id = " + telegramId + " not exist");
        } else {
            Long customerId = customer.getId();
            List<Sale> lastMonthSales = saleRepository.findAllByCustomerIdAndCreatedAtGreaterThan(customerId, LocalDateTime.now().minusMonths(1L));
            if (lastMonthSales.isEmpty()) {
                throw new CustomerHasNotSalesException("Customer with id = " + customerId + " has not sales");
            } else {
                BigDecimal allSpendMoney = new BigDecimal(0.00);
                for (Sale sale : lastMonthSales) {
                    allSpendMoney = allSpendMoney.add(sale.getPaid());
                }
                dto = MonthlyReportDTO.builder().sales(lastMonthSales)
                        .allSpendMoney(allSpendMoney)
                        .build();
            }
        }
        return dto;
    }
}
