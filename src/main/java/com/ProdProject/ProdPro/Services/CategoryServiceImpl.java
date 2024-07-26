package com.ProdProject.ProdPro.Services;

import com.ProdProject.ProdPro.Modals.Category;
import com.ProdProject.ProdPro.Modals.Product;
import com.ProdProject.ProdPro.Repositaries.CategoryRepositary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@Service
public class CategoryServiceImpl implements CategoryService{
    private CategoryRepositary categoryRepositary;
    public CategoryServiceImpl(CategoryRepositary categoryRepositary){
        this.categoryRepositary=categoryRepositary;
    }
    public List<Category> getAllCategory(){
        List<Category> categories=new ArrayList<>();
        categories=categoryRepositary.findAll();
        return categories;
    }
    public List<Product> getProductByCategory(UUID id){
        List<Product> products=new ArrayList<>();
        products=categoryRepositary.findProductsByCategoryId(id);
        return products;
    }
}
