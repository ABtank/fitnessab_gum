package ru.fitnessab.persist.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.fitnessab.persist.entity.Product;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository <Product, Integer> {

    List<Product> findByName(String name);
}
