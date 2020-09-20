package net.example.coffeeshop.usecases;

import net.example.coffeeshop.entrypoints.http.controllers.exceptions.ShopNotExistException;
import net.example.coffeeshop.repositories.SaleRepository;
import net.example.coffeeshop.repositories.ShopRepository;
import net.example.coffeeshop.repositories.models.Sale;
import net.example.coffeeshop.usecases.dto.AvgCountCustomersByLastPeriodDTO;
import net.example.coffeeshop.usecases.exceptions.IncorrectPeriodException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AvgCountCustomersByLastPeriodUsecase {

    private final ShopRepository shopRepository;
    private final SaleRepository saleRepository;

    public AvgCountCustomersByLastPeriodUsecase(ShopRepository shopRepository, SaleRepository saleRepository) {
        this.shopRepository = shopRepository;
        this.saleRepository = saleRepository;
    }

    public AvgCountCustomersByLastPeriodDTO execute(Long shopId, String period) throws ShopNotExistException, IncorrectPeriodException {
        if (shopRepository.findById(shopId).isEmpty()) {
            throw new ShopNotExistException("Shop with id = " + shopId + " not exist");
        }

        List<Sale> sales = saleRepository.findAllByShopIdAndCreatedAtGreaterThan(shopId, determineThePeriod(period));

        return AvgCountCustomersByLastPeriodDTO.builder().countOfCustomers(sales.size()).build();
    }


    private LocalDateTime determineThePeriod(String period) throws IncorrectPeriodException {
        if (period.equals("DAY")) {
            return LocalDateTime.now().minusHours(24);
        }
        if (period.equals("WEEK")) {
            return LocalDateTime.now().minusDays(7L);
        }
        if (period.equals("MONTH")) {
            return LocalDateTime.now().minusMonths(1L);
        }
        throw new IncorrectPeriodException("Incorrect period used");
    }

}
