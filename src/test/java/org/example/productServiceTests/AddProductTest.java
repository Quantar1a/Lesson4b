package org.example.productServiceTests;

import org.example.Product;
import org.example.baseTest.AbstractTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;

public class AddProductTest extends AbstractTest
{
    Product product = new Product(1, "Headphones JBL Quantum", 2500);

    @Test
    public void addProductTest()
    {
        //Add product to database
        productService.addProduct(product);

        //Check that save() method was called with the right product
        ArgumentCaptor<Product> productArgumentCaptor = ArgumentCaptor.forClass(Product.class);
        verify(productRepository).save(productArgumentCaptor.capture());

        //Compare the product with expected
        Assertions.assertEquals(product.getId(), productArgumentCaptor.getValue().getId());
        Assertions.assertEquals(product.getName(), productArgumentCaptor.getValue().getName());
        Assertions.assertEquals(product.getPrice(), productArgumentCaptor.getValue().getPrice());
    }

    @Test
    public void addProductThrownExceptionWhenSaveFails()
    {
        //Imitate an exception that data has not been added to the database
        doThrow(new RuntimeException("Database error")).when(productRepository).save(product);

        //Check that the exception has been called after calling addProduct method
        RuntimeException exception = assertThrows(RuntimeException.class, () ->{
            productService.addProduct(product);
        });

        //Check the error message
        Assertions.assertEquals("Database error", exception.getMessage());
    }
}
