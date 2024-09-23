package com.ProdProject.ProdPro.Controllers;

import com.ProdProject.ProdPro.DTOs.GenericProductDTO;
import com.ProdProject.ProdPro.Exceptions.NotFoundException;

import com.ProdProject.ProdPro.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProdController {
    public ProductService productService;

    @Autowired
    public ProdController(@Qualifier(value = "fakeProduct") ProductService productService) {
        this.productService = productService;
    }
    @GetMapping
    public List<GenericProductDTO> getAllProducts(){
        return productService.getAllProducts();
    }


    @GetMapping("{id}")
    public GenericProductDTO getProductByID(@PathVariable("id") Long id) throws NotFoundException {
//        apiCallToAuth
        return productService.getProductById(id);
    }

    @PostMapping
    public  GenericProductDTO createProduct(@RequestBody GenericProductDTO product) {
        return productService.createProduct(product);
    }

    @PutMapping("{id}")
    public GenericProductDTO updateProductById(@PathVariable("id") Long id,@RequestBody GenericProductDTO product) {
        return productService.updateProductById(id,product);
    }
    @DeleteMapping("{id}")
    public GenericProductDTO deleteProductById(@PathVariable("id") Long id) {
        return productService.deleteProductById(id);
    }

}
