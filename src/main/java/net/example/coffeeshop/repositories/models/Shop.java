package net.example.coffeeshop.repositories.models;

import lombok.AllArgsConstructor;
import lombok.Builder;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@Builder
@Table(name = "shops", schema = "public")
public class Shop {

    public Shop() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;
    @Column(name = "address")
    private String address;
}
