
    package com.hcl.hclassessment2.controller;

import com.hcl.hclassessment2.entity.Product;
import com.hcl.hclassessment2.repository.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

    @RestController
    @RequestMapping("/api/products")
    public class ProductController {

        private final ProductRepository repository;

        public ProductController(ProductRepository repository) {
            this.repository = repository;
        }

        @PostMapping
        public ResponseEntity<Product> addProduct(@RequestBody Product product) {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(repository.save(product));
        }

        @GetMapping
        public Iterable<Product> getAllProducts() {
            return repository.findAll();
        }

        @GetMapping("/{id}")
        public ResponseEntity<?> getProduct(@PathVariable Long id) {

            return repository.findById(id)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
        }

        @PutMapping("/{id}")
        public ResponseEntity<?> updateProduct(
                @PathVariable Long id,
                @RequestBody Product product) {

            return repository.findById(id)
                    .map(existing -> {

                        existing.setProductName(product.getProductName());
                        existing.setDescription(product.getDescription());
                        existing.setPrice(product.getPrice());
                        existing.setQuantity(product.getQuantity());
                        existing.setCategory(product.getCategory());

                        return ResponseEntity.ok(repository.save(existing));
                    })
                    .orElse(ResponseEntity.notFound().build());
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<?> deleteProduct(@PathVariable Long id) {

            if (!repository.existsById(id)) {
                return ResponseEntity.notFound().build();
            }

            repository.deleteById(id);

            return ResponseEntity.ok("Product deleted successfully");
        }

        @GetMapping("/category/{category}")
        public Iterable<Product> getByCategory(
                @PathVariable String category) {

            return repository.findByCategoryIgnoreCase(category);
        }

        @GetMapping("/search")
        public Iterable<Product> search(
                @RequestParam String name) {

            return repository.findByProductNameContainingIgnoreCase(name);

    }
}
