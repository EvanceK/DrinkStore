package com.evance.drinkstore.service.impl;

import com.evance.drinkstore.entity.Category;
import com.evance.drinkstore.repository.CategoryRepository;
import com.evance.drinkstore.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
}
