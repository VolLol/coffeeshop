package net.example.coffeeshop.repositories.models;

import lombok.*;
import net.example.coffeeshop.repositories.models.enums.Gender;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity(name = "customers")
@AllArgsConstructor
@Builder
@Table(name = "customers", schema = "public")
public class Customer {

    public Customer() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Getter
    @Column(name = "id")
    private Long id;
    @Setter
    @Getter
    @Column(name = "telegramid")
    private Long telegramId;
    @Getter
    @Column(name = "yearofbirth")
    private LocalDate yearOfBirth;
    @Getter
    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Getter
    @Column(name = "points")
    private Integer points;
    @Setter
    @Getter
    @Column(name = "updatedat")
    private LocalDateTime updatedAt;
    @Setter
    @Getter
    @Column(name = "createdat")
    private LocalDateTime createdAt;
}
