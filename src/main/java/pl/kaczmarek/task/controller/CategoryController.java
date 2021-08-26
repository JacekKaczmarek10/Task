package pl.kaczmarek.task.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.kaczmarek.task.model.Category;
import pl.kaczmarek.task.service.CategoryServiceImpl;

@Controller
public class CategoryController {


    // wstrzykiwanie zaleznosci przez konstruktor
    private final CategoryServiceImpl categoryServiceImpl;

    public CategoryController(CategoryServiceImpl categoryServiceImpl) {
        this.categoryServiceImpl = categoryServiceImpl;
    }

    @GetMapping("/")
    public String hello(){
        return "home";
    }

    @PostMapping("/add-category")
    public String addCategory(@ModelAttribute("category") Category category){
        categoryServiceImpl.addCategory(category.getCategoryName());
        return "redirect:/";
    }


    @PostMapping("/cancel-apply-category/{id}")
    public String cancelAssignCategory(@PathVariable("id") Long id){
        categoryServiceImpl.cancelAssignCategory(id);
        return "redirect:/apply";
    }


    @PostMapping("/assign-category/{id}")
    public String assignCategory(@PathVariable("id") Long id){
        categoryServiceImpl.assignCategory(id);
        return "redirect:/apply";
    }

    @GetMapping("/showAddCategoryForm")
    public String showAddCategoryForm(Model model){
        Category category = new Category();
        model.addAttribute("category",category);
        return "new_category";
    }

    @GetMapping("/apply")
    public String applyToCategory(Model model){
        model.addAttribute("categories",categoryServiceImpl.getAllCategories());
        return "apply_to_category";
    }

    @GetMapping("/display")
    public String getAllCategories(Model model){
        model.addAttribute("categories",categoryServiceImpl.getAllCategories());
        return "category_list";
    }
}
