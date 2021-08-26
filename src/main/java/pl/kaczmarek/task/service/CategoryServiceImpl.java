package pl.kaczmarek.task.service;


import org.springframework.stereotype.Service;
import pl.kaczmarek.task.dao.CategoryRepository;
import pl.kaczmarek.task.model.Category;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    @Override
    public void addCategory(String category){
        categoryRepository.save(new Category(category));
    }

    @Override
    public void assignCategory(Long id){
        Category category = categoryRepository.getById(id);
        category.setNumberOfUsers(category.getNumberOfUsers()+1);
        categoryRepository.save(category);
    }

    @Override
    public void cancelAssignCategory(Long id) {
        Category category = categoryRepository.getById(id);
        category.setNumberOfUsers(category.getNumberOfUsers()-1);
        categoryRepository.save(category);
    }

    @Override
    public List<Category> getAllCategories(){
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategoryById(Long id) {
        return categoryRepository.getById(id);
    }
}
