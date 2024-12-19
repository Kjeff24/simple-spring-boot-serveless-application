package org.example.service;

import org.example.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    boolean deleteProduct(int id);

    List<Product> getAllProducts();

    void addProduct(Product product);

    Optional<Product> getProductById(int id);

    boolean updateProduct(int id, Product newProduct);
}
