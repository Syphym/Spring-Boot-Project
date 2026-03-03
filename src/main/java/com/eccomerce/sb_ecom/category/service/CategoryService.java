package com.eccomerce.sb_ecom.category.service;

import com.eccomerce.sb_ecom.category.dto.Category;

import java.util.List;

public interface CategoryService {

    List<Category> getAllCategories();
    void createCategory (Category category);
    String deleteCategory (Long categoryId);
}
