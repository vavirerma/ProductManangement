package com.ProdProject.ProdPro.Controllers;

import com.ProdProject.ProdPro.Modals.Product;
import com.ProdProject.ProdPro.Services.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/produced")
public class DBController {
    private DbService dbService;
    @Autowired
    public DBController(DbService dbService){
        this.dbService=dbService;
    }
    @GetMapping
    public List<Product> getAllProducts(){
        return dbService.getAllProducts();
    }
    @GetMapping("{id}")
    public Optional<Product> getProductByID(@PathVariable("id") UUID id){
        //UUID uuid = UUID.fromString(id);
        return dbService.getProductById(id);
    }
    @PostMapping
    public Product createProduct(@RequestBody Product product){
        return dbService.createProduct(product);
    }
    @PutMapping("{id}")
    public Product updateProductByID(@PathVariable("id") UUID id,@RequestBody Product product){
        return dbService.updateProductById(id,product);
    }
    @DeleteMapping("{id}")
    public void deleteProductById(@PathVariable("id") UUID id){
        dbService.deleteProductById(id);
    }
}
