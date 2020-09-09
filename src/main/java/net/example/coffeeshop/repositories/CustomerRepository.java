package net.example.coffeeshop.repositories;

import net.example.coffeeshop.entities.Customer;
import net.example.coffeeshop.entrypoints.enums.Gender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Customer findByTelegramId(Long telegramId);

    @Transactional
    @Modifying
    @Query("UPDATE customers set yearofbirth = :yearofbirth, gender = :gender where id = :id")
    void setGenderAndDateIfBirth(@Param("yearofbirth") LocalDate yearofbirth, @Param("gender") Gender gender, @Param("id") Long customerId);
}
