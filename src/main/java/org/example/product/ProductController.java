package org.example.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {
    private final  ProductRepository productRepository;

    @Autowired
    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable long id) {
        return productRepository.getProductById(id);
    }
    @GetMapping("/products")
    public ProductRepository getProducts() {
        return productRepository;
    }
    @PostMapping("/products")
    public ResponseEntity<String> addProduct(@RequestBody Product product) {
        productRepository.addProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).body("Produkt pridan...");
    }
    @GetMapping("/count")
    public long countProds() {
        return productRepository.numberOfProducts();
    }

}
