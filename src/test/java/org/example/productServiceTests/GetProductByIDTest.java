package org.example.productServiceTests;

import org.example.Product;
import org.example.baseTest.AbstractTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.when;

public class GetProductByIDTest  extends AbstractTest
{
    Product product = new Product(1, "Headphones JBL Quantum", 2500);

    @Test
    public void getProductByIDTest()
    {
        //Set up mock object for returning the product by ID
        when(productRepository.findByID(1)).thenReturn(product);

        //Call method getProductByID
        Product fetchedProduct = productService.getProductByID(1);

        //Check that returned object matches to the expected
        Assertions.assertEquals(product.getId(), fetchedProduct.getId());
        Assertions.assertEquals(product.getName(), fetchedProduct.getName());
        Assertions.assertEquals(product.getPrice(), fetchedProduct.getPrice());
    }
}
