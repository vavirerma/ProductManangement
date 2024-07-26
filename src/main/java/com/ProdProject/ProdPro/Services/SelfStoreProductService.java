package com.ProdProject.ProdPro.Services;

import com.ProdProject.ProdPro.Modals.Product;
import com.ProdProject.ProdPro.Repositaries.CategoryRepositary;
import com.ProdProject.ProdPro.Repositaries.ProductRepositary;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service(value="selfProduct")
public class SelfStoreProductService implements DbService{
     private ProductRepositary productRepositary;
     private CategoryRepositary categoryRepositary;
     public SelfStoreProductService(ProductRepositary productRepositary,CategoryRepositary categoryRepositary){
         this.productRepositary=productRepositary;
         this.categoryRepositary=categoryRepositary;
     }
    public Optional<Product> getProductById(UUID id){
        return productRepositary.findById(id);
    }
    @Override
    public Product createProduct(Product product) {
        return productRepositary.save(product);
    }

    @Override
    public Product updateProductById(UUID id,Product product) {
        return productRepositary.findById(id)
                .map(existingProduct -> {
                    existingProduct.setTiltle(product.getTiltle());
                    existingProduct.setDescription(product.getDescription());
                    existingProduct.setImage(product.getImage());
                    return productRepositary.save(existingProduct);
                })
                .orElseThrow(() -> new IllegalArgumentException("Product not found with id: " + id));
    }

    @Override
    public void deleteProductById(UUID id) {
        productRepositary.deleteById(id);
    }

    @Override
    public List<Product> getAllProducts() {
         List<Product> products=new ArrayList<>();
         products=productRepositary.findAll();
        return products;
    }

}
