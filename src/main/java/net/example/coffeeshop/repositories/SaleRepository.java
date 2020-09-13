package net.example.coffeeshop.repositories;

import net.example.coffeeshop.repositories.models.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {

    List<Sale> findAllByCustomerIdAndCreatedAtGreaterThan(Long customerId, LocalDateTime dateInLastMonth);
}
