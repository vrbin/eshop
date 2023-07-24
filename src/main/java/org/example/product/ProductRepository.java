package org.example.product;

import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
@Component
public class ProductRepository {
    List<Product> productList = new ArrayList<>();
    public void addProduct (Product product) {
        productList.add(product);
        System.out.println("Pridali jsme product s id " + product.getId() + " jmenuje se " + product.getName());
        System.out.println("Mame celkem " + productList.size() + " produktu");
    }

    public Product getProductById(long id) {
        System.out.println("mame tu " + productList.size() + " produktu, jdu hledat ten s id " + id);
        for (int i=0; i < productList.size(); i++) {
            System.out.println("Tenhle ma id " + productList.get(i).getId() + " a jmenuje se " + productList.get(i).getName());
            if (productList.get(i).getId() == id) {
                System.out.println("nasel jsem ho, jmenuje se " + productList.get(i).getName());
                return productList.get(i);
            }
        }
        System.out.println("Nic jsem nenasel.");
        return null;
    }

    public void deleteProductById(long id) {
        for (int i=0; i < productList.size(); i++) {
            if (productList.get(i).getId() == id) {
                productList.remove(i);
                return;
            }
        }
    }

    public void updateProduct(Product product) {
        for (int i=0; i < productList.size(); i++) {
            if (productList.get(i).getId() == product.getId()) {
                productList.set(i, product);
                return;
            }
        }
    }

    public List<Product> getProducts () {
        return productList;
    }

    public long numberOfProducts () {
        return productList.size();
    }

}