package com.ProdProject.ProdPro.Controllers;

import com.ProdProject.ProdPro.DTOs.GenericProductDTO;
import com.ProdProject.ProdPro.DTOs.Status;
import com.ProdProject.ProdPro.DTOs.loginRequestDTO;
import com.ProdProject.ProdPro.DTOs.validateDTO;
import com.ProdProject.ProdPro.Exceptions.NotFoundException;
import com.ProdProject.ProdPro.Security.TokenAthenticator;
import com.ProdProject.ProdPro.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Stack;

@RestController
@RequestMapping("/products")
public class ProdController {
    public ProductService productService;
    public TokenAthenticator tokenAthenticator;
    @Autowired
    public ProdController(@Qualifier(value = "fakeProduct") ProductService productService,TokenAthenticator tokenAthenticator) {
        this.productService = productService;
        this.tokenAthenticator=tokenAthenticator;
    }
    @GetMapping
    public List<GenericProductDTO> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("{id}")
    public GenericProductDTO getProductByID(@PathVariable("id") Long id) throws NotFoundException {
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
    @PostMapping("/login")
    public ResponseEntity<loginRequestDTO> login(@RequestBody loginRequestDTO log){
        return tokenAthenticator.tokenrequest(log);
    }
    @PostMapping("/validate")
    public Status validate(@RequestBody validateDTO validate){
        return tokenAthenticator.validate(validate).getBody().getSt();
    }

}
