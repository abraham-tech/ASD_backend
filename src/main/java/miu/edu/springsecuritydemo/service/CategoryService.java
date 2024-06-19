package miu.edu.springsecuritydemo.service;

import miu.edu.springsecuritydemo.entity.Category;

import java.util.List;

public interface CategoryService {

    public Category addCategory(Category category);

    public List<Category> getCategories();
}
