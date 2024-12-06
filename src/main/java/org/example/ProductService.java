package org.example;

import org.example.interfaces.Service;

public class ProductService implements Service
{
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void addProduct(Product product) {
        productRepository.save(product);
    }

    public Product getProductByID(long id) {
        return productRepository.findByID(id);
    }

    public void updateProduct(Product product) {
        if (!productRepository.existsByID(product.getId())) {
            throw new IllegalArgumentException("Product not found with id: " + product.getId());
        }
        productRepository.save(product);
    }
}
