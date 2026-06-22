package com.example.ecommerce.services;

import com.example.ecommerce.entities.Category;
import com.example.ecommerce.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAllCategories(){
        return categoryRepository.findAll();
    }

    public Category getCategoryById(Long id){
        return categoryRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Fetch Error: Category not found"));
    }

    public Category createCategory(Category category){
        return categoryRepository.save(category);
    }

    public Category updateCategory(Long id, Category category){
        Category existingCategory = categoryRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Update Error: Category not found"));

        existingCategory.setName(existingCategory.getName());
        existingCategory.setDescription(existingCategory.getDescription());

        return categoryRepository.save(existingCategory);
    }

    public void deleteCategory(Long id){
        Category existingCategory = categoryRepository.findById(id)
                        .orElseThrow(()-> new RuntimeException("Delete Error: Category not found"));
        categoryRepository.deleteById(id);
    }



}

//getAllCategories()
//getCategoryById()
//deleteCategory()
//createCategory()
//updateCategory()
