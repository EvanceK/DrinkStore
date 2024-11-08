package com.evance.drinkstore;

import com.evance.drinkstore.entity.Product;
import com.evance.drinkstore.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
public class ProductControllerTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void testGetAllProducts() {
        List<Product> products = productRepository.findAll();  // 確保這裡返回的是一個有效的列表
        System.out.println("Retrieved products: " + products);

        // 檢查產品列表不為空
        assertFalse(products.isEmpty(), "Product list should not be empty");
    }
}
