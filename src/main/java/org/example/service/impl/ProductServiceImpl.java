package org.example.service.impl;

import org.example.model.Product;
import org.example.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    private final List<Product> products = new ArrayList<>();

    // Create a new product
    public void addProduct(Product product) {
        products.add(product);
    }

    // Retrieve all products
    public List<Product> getAllProducts() {
        return products;
    }

    // Retrieve a product by id
    public Optional<Product> getProductById(int id) {
        return products.stream()
                .filter(product -> product.getId() == id)
                .findFirst();
    }

    // Update a product
    public boolean updateProduct(int id, Product newProduct) {
        return getProductById(id).map(existingProduct -> {
            products.remove(existingProduct);
            products.add(newProduct);
            return true;
        }).orElse(false);
    }

    // Delete a product by id
    public boolean deleteProduct(int id) {
        return products
                .removeIf(product -> product.getId() == id);
    }
}
