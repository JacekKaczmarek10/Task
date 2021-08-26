package pl.kaczmarek.task.service;


import pl.kaczmarek.task.model.Category;

import java.util.List;

public interface CategoryService {

    void addCategory(String  category);
    void assignCategory(Long id);
    void cancelAssignCategory(Long id);
    List<Category> getAllCategories();
    Category getCategoryById(Long id);
}
