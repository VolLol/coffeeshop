package net.example.coffeeshop.repositories;

import net.example.coffeeshop.repositories.models.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopRepository extends JpaRepository<Shop, Long> {

}
