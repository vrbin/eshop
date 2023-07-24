package org.example.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Optional;
import java.util.List;
@Service
public class ProductService {

    @Autowired
    private ProductJpaRepository productJpaRepository;

    public void addProduct(Product prod) {
        System.out.println("Pridavam produkt s id " + prod.getId() + " s nazvem " + prod.getName());
        productJpaRepository.save(prod);
    }
    public Optional<Product> getProductById(long id) {
        return productJpaRepository.findById(id);
    }
    public List<Product> getProducts() {
        return productJpaRepository.findAll();
    }
    public long count() {
        return productJpaRepository.count();
    }
}
