package org.example.product;

public class ProductService {
    ProductJpaRepository repo;

    public void addProduct(Product prod) {
        Product newProd = new Product(prod.getId(), prod.getName(), prod.getPrice(), prod.getDescription());
        newProd = repo.save(newProd);
    }

}
