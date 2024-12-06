package org.example;

import org.example.interfaces.Repository;

import java.util.HashMap;
import java.util.Map;

public class ProductRepository implements Repository
{
    private final Map<Long, Product> productDatabase = new HashMap<>();

    @Override
    public void save(Product product) {
        productDatabase.put(product.getId(), product);
    }

    @Override
    public Product findByID(long id) {
        return productDatabase.get(id);
    }

    @Override
    public boolean existsByID(long id) {
        return productDatabase.containsKey(id);
    }
}
