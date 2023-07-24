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
        System.out.println("chces produkt s id " + id);
        Product p = productRepository.getProductById(id);
        System.out.println("jeho jmeno je " + p.getName());
        return productRepository.getProductById(id);
    }
    @PostMapping("/products")
    public ResponseEntity<String> addProduct(@RequestBody Product product) {
        System.out.println("Prijali jsme produkt s id " + product.getId());
        productRepository.addProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).body("Produkt pridan...");
    }
    @GetMapping("/count")
    public long countProds() {
        System.out.println("Vracim pocet produktu: " + productRepository.numberOfProducts());
        return productRepository.numberOfProducts();
    }

}
