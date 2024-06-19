package miu.edu.springsecuritydemo.service.impl;

import miu.edu.springsecuritydemo.entity.Category;
import miu.edu.springsecuritydemo.repository.CategoryRepository;
import miu.edu.springsecuritydemo.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class CategoryServiceImpl implements CategoryService {


    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;

    }

    @Override
    public Category addCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }
}
