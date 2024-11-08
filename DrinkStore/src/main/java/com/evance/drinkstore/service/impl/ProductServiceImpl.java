package com.evance.drinkstore.service.impl;

import com.evance.drinkstore.entity.Product;
import com.evance.drinkstore.entity.Category;
import com.evance.drinkstore.repository.ProductRepository;
import com.evance.drinkstore.repository.CategoryRepository;
import com.evance.drinkstore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    // 獲取所有產品
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // 根據 ID 獲取產品
    public Product getProductById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        return product.orElse(null);  // 返回產品或 null
    }

    // 獲取所有分類
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    // 創建或更新產品
    public void saveOrUpdateProduct(Product product) {
        productRepository.save(product);  // 如果 product 具有 ID，就會執行更新，否則會創建
    }

    // 刪除產品
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);  // 根據 ID 刪除產品
    }
}


