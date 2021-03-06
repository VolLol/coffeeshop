package net.example.coffeeshop.repositories.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import net.example.coffeeshop.repositories.models.enums.Reason;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@Builder
@Table(name = "sales", schema = "public")
public class Sale {

    public Sale() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;
    @Column(name = "customerid")
    private Long customerId;
    @Column(name = "shopid")
    @Getter
    private Long shopId;
    @Getter
    @Column(name = "paid")
    private BigDecimal paid;
    @Enumerated(EnumType.STRING)
    @Column(name = "reason")
    @Getter
    private Reason reason;
    @Column(name = "createdat")
    @Getter
    private LocalDateTime createdAt;
}
