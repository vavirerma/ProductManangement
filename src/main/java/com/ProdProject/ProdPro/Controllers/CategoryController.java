package com.ProdProject.ProdPro.Controllers;

import com.ProdProject.ProdPro.Modals.Category;
import com.ProdProject.ProdPro.Modals.Product;
import com.ProdProject.ProdPro.Services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/category")
public class CategoryController {
    private CategoryService categoryService;
    @Autowired
    public CategoryController(CategoryService categoryService){
        this.categoryService=categoryService;
    }
    @GetMapping
    public List<Category> getAllCategory(){
        return categoryService.getAllCategory();
    }
    @GetMapping("{id}")
    public List<Product> getProductByCategory(UUID id){
        return categoryService.getProductByCategory(id);
    }
}
