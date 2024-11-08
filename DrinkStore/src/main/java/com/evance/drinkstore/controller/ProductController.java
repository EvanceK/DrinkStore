package com.evance.drinkstore.controller;

import com.evance.drinkstore.entity.Category;
import com.evance.drinkstore.entity.Product;
import com.evance.drinkstore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    // 顯示產品列表頁面
    @GetMapping
    public String showProductList(Model model) {
        List<Product> products = productService.getAllProducts();  // 獲取所有產品
        model.addAttribute("products", products);  // 將產品列表添加到模型
        return "products/list";  // 返回 Thymeleaf 頁面
    }

    // 顯示產品創建頁面
    @GetMapping("/new")
    public String showCreateForm(Model model) {
        List<Category> categories = productService.getAllCategories();  // 獲取所有分類
        model.addAttribute("categories", categories);  // 將分類添加到模型
        model.addAttribute("product", new Product());  // 創建一個空的 Product 對象
        return "products/create";  // 返回創建頁面
    }

    // 顯示產品編輯頁面
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        Product product = productService.getProductById(id);  // 根據 ID 查詢產品
        if (product == null) {
            return "redirect:/products";  // 如果找不到產品，重定向到列表頁面
        }
        List<Category> categories = productService.getAllCategories();  // 獲取所有分類
        model.addAttribute("categories", categories);  // 將分類添加到模型
        model.addAttribute("product", product);  // 將產品添加到模型
        return "products/create";  // 返回編輯頁面
    }

    // 處理表單提交，創建或更新產品
    @PostMapping
    public String saveProduct(@ModelAttribute("product") Product product) {
        productService.saveOrUpdateProduct(product);  // 保存或更新產品
        return "redirect:/products";  // 保存後重定向到產品列表頁面
    }

    // 刪除產品
    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") Long id) {
        productService.deleteProduct(id);  // 根據 ID 刪除產品
        return "redirect:/products";  // 刪除後重定向到產品列表頁面
    }
}
