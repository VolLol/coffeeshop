package net.example.coffeeshop.usecases;

import net.example.coffeeshop.entrypoints.http.controllers.exceptions.ShopNotExistException;
import net.example.coffeeshop.repositories.SaleRepository;
import net.example.coffeeshop.repositories.ShopRepository;
import net.example.coffeeshop.repositories.models.Sale;
import net.example.coffeeshop.usecases.dto.AvgBillByLastMonthDTO;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class AverageBillByLastMonthUsecase {

    private final SaleRepository saleRepository;
    private final ShopRepository shopRepository;

    public AverageBillByLastMonthUsecase(SaleRepository saleRepository, ShopRepository shopRepository) {
        this.saleRepository = saleRepository;
        this.shopRepository = shopRepository;
    }


    public AvgBillByLastMonthDTO execute(Long shopId) throws ShopNotExistException {
        if (shopRepository.findById(shopId).isEmpty()) {
            throw new ShopNotExistException("Shop with id = " + shopId + " not exist");
        }
        List<Sale> sales = saleRepository.findAllByShopIdAndCreatedAtGreaterThan(shopId, LocalDateTime.now().minusMonths(1L));
        if (!sales.isEmpty()) {
            BigDecimal allPaid = new BigDecimal(0);
            BigDecimal countOfBills = new BigDecimal(0);
            for (Sale s : sales) {
                countOfBills = countOfBills.add(BigDecimal.valueOf(1));
                allPaid = allPaid.add(s.getPaid());
            }
            BigDecimal avgBill = allPaid.divide(countOfBills, 2);
            return AvgBillByLastMonthDTO.builder()
                    .avgBill(avgBill)
                    .build();
        } else {
            return AvgBillByLastMonthDTO.builder()
                    .avgBill(BigDecimal.valueOf(0))
                    .build();
        }
    }
}
