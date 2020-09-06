package net.example.coffeeshop.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.example.coffeeshop.entrypoints.enums.Gender;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "customers")
public class Customer {

    public Customer() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Getter
    private Long id;
    @Setter
    @Getter
    private Long telegramId;
    @Getter
    private LocalDate yearOfBirth;
    @Getter
    private Gender gender;
    @Getter
    private Integer points;
    @Getter
    private LocalDateTime updatedAt;
    @Getter
    private LocalDateTime createdAt;
}
