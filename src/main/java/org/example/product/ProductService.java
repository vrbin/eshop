package org.example.product;

import org.example.exception.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class ProductService {

    @Autowired
    private ProductJpaRepository productJpaRepository;

    public void addProduct(Product prod) {
        System.out.println("Pridavam produkt s id " + prod.getId() + " s nazvem " + prod.getName());
        productJpaRepository.save(prod);
    }
    public Product getProductById(long id) {
        return productJpaRepository.findById(id).orElseThrow(
                () -> new ProductNotFoundException("Produkt nenalezen.")
        );
    }
    public List<Product> getProducts() {
        return productJpaRepository.findAll();
    }
    public long count() {
        return productJpaRepository.count();
    }
}
