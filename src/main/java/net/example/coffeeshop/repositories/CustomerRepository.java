package net.example.coffeeshop.repositories;

import net.example.coffeeshop.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Customer findByTelegramId(Long telegramId);
}
