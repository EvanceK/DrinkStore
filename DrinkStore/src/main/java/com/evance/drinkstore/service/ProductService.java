package com.evance.drinkstore.service;

import com.evance.drinkstore.entity.Category;
import com.evance.drinkstore.entity.Product;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public interface ProductService {
    List<Product> getAllProducts();

    // 根據 ID 獲取產品
    Product getProductById(Long id);

    // 獲取所有分類
    public List<Category> getAllCategories();

    // 創建或更新產品
    public void saveOrUpdateProduct(Product product);

    // 刪除產品
    public void deleteProduct(Long id);
}
