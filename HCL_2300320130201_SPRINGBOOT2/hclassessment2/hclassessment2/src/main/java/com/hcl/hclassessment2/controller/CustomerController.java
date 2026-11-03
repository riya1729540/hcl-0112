


    package com.hcl.hclassessment2.controller;

import com.hcl.hclassessment2.entity.Customer;
import com.hcl.hclassessment2.repository.CustomerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

    @RestController
    @RequestMapping("/api/customers")
    public class CustomerController {

        private final CustomerRepository repository;

        public CustomerController(CustomerRepository repository) {
            this.repository = repository;
        }

        @PostMapping("/register")
        public ResponseEntity<?> register(@RequestBody Customer customer) {

            if (repository.existsByEmail(customer.getEmail())) {
                return ResponseEntity
                        .status(HttpStatus.BAD_REQUEST)
                        .body("Email already exists");
            }

            Customer saved = repository.save(customer);

            return ResponseEntity.status(HttpStatus.CREATED).body(saved);
        }

        @GetMapping
        public Iterable<Customer> getAllCustomers() {
            return repository.findAll();
        }

        @GetMapping("/{id}")
        public ResponseEntity<?> getCustomer(@PathVariable Long id) {

            return repository.findById(id)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
        }

        @PutMapping("/{id}")
        public ResponseEntity<?> updateCustomer(
                @PathVariable Long id,
                @RequestBody Customer customer) {

            return repository.findById(id)
                    .map(existing -> {

                        existing.setCustomerName(customer.getCustomerName());
                        existing.setEmail(customer.getEmail());
                        existing.setPassword(customer.getPassword());
                        existing.setMobile(customer.getMobile());
                        existing.setCity(customer.getCity());

                        return ResponseEntity.ok(repository.save(existing));
                    })
                    .orElse(ResponseEntity.notFound().build());
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<?> deleteCustomer(@PathVariable Long id) {

            if (!repository.existsById(id)) {
                return ResponseEntity.notFound().build();
            }

            repository.deleteById(id);

            return ResponseEntity.ok("Customer deleted successfully");

    }
}
