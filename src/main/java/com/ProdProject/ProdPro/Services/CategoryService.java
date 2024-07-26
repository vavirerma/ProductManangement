package com.ProdProject.ProdPro.Services;

import com.ProdProject.ProdPro.Modals.Category;
import com.ProdProject.ProdPro.Modals.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface CategoryService {
    List<Category> getAllCategory();
    List<Product> getProductByCategory(UUID id);
}
