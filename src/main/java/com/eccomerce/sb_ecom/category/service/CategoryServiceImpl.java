package com.eccomerce.sb_ecom.category.service;

import com.eccomerce.sb_ecom.category.dto.Category;
import com.eccomerce.sb_ecom.category.integration.database.CategoryRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public void createCategory(Category category) {
        categoryRepository.save(category);
    }

    @Override
    @Transactional
    public String deleteCategory(Long categoryId) {

        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Category Not found"));
        categoryRepository.delete(category);
        return "Category with category ID: " + categoryId + " deleted successfully";
    }

    @Override
    public Optional<Category> updateCategory(Category category, Long categoryId) {
        Category existingCategory = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Category Not found"));
        existingCategory.setCategoryName(category.getCategoryName());
        return Optional.of(categoryRepository.save(existingCategory));
    }
}

