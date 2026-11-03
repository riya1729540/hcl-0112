
    package com.hcl.hclassessment2.repository;

import com.hcl.hclassessment2.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

    public interface ProductRepository extends JpaRepository<Product, Long> {

        List<Product> findByCategoryIgnoreCase(String category);

        List<Product> findByProductNameContainingIgnoreCase(String name);

}
