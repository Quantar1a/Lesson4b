package org.example.productServiceTests;

import org.example.Product;
import org.example.baseTest.AbstractTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class UpdateProductTest  extends AbstractTest
{
    Product product = new Product(1, "Headphones JBL Quantum", 2500);

    @Test
    public void testUpdateProduct() {
        //Adjust mock-object that returns true if the product exists
        when(productRepository.existsByID(1)).thenReturn(true);

        productService.updateProduct(product);

        //Verify that method save() was called with the right product
        verify(productRepository).save(product);
    }

    @Test
    public void testUpdateProductThrowsExceptionWhenProductNotFound() {
        //Adjust mock-object that returns false if the product exists
        when(productRepository.existsByID(1L)).thenReturn(false);

        //Check that the exception has been thrown is case of unexistance of the product
        assertThrows(IllegalArgumentException.class, () -> {
            productService.updateProduct(product);
        });
    }
}