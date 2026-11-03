
    package com.hcl.hclassessment2.repository;

import com.hcl.hclassessment2.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

    public interface CustomerRepository extends JpaRepository<Customer, Long> {

        boolean existsByEmail(String email);

}
