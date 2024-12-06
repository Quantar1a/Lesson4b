package org.example.interfaces;

import org.example.Product;

public interface Repository
{
    void save(Product product);

    Product findByID(long id);

    boolean existsByID(long id);
}
