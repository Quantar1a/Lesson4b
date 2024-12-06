package org.example.baseTest;

import org.example.ProductRepository;
import org.example.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;

public abstract class AbstractTest
{
    protected ProductRepository productRepository;
    protected ProductService productService;

    @BeforeEach
    public void setUp()
    {
        productRepository = Mockito.mock(ProductRepository.class);
        productService = new ProductService(productRepository);
    }
}
