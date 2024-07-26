package com.ProdProject.ProdPro.Services;

import com.ProdProject.ProdPro.Modals.Product;
import com.ProdProject.ProdPro.Repositaries.ProductRepositary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public interface DbService {
    Optional<Product> getProductById(UUID id);
    Product createProduct(Product product);
    Product updateProductById(UUID id,Product product);
    void deleteProductById(UUID id);
    List<Product> getAllProducts();
}
