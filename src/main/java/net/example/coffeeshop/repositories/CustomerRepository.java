package net.example.coffeeshop.repositories;

import net.example.coffeeshop.repositories.models.Customer;
import net.example.coffeeshop.repositories.models.enums.Gender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Customer findByTelegramId(Long telegramId);

    @Transactional
    @Modifying
    @Query("UPDATE customers set yearofbirth = :yearofbirth, gender = :gender where id = :id")
    void setGenderAndDateIfBirth(@Param("yearofbirth") LocalDate yearofbirth, @Param("gender") Gender gender, @Param("id") Long customerId);

    @Transactional
    @Modifying
    @Query("UPDATE customers set points = :points,updatedAt=:updatedAt where id = :customerId")
    void setPoints(@Param("points") Integer points, @Param("customerId") Long customerId, @Param("updatedAt") LocalDateTime updatedAt);
}
