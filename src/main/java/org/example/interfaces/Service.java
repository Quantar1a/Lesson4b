package org.example.interfaces;

import org.example.Product;

public interface Service
{
    void addProduct(Product product);

    Product getProductByID(long id);

    void updateProduct(Product product);
}
