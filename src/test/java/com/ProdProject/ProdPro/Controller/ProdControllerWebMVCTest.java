package com.ProdProject.ProdPro.Controller;

import com.ProdProject.ProdPro.Controllers.ProdController;
import com.ProdProject.ProdPro.DTOs.GenericProductDTO;
import com.ProdProject.ProdPro.Services.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;


@WebMvcTest(ProdController.class)
public class ProdControllerWebMVCTest {
 /*   @Autowired
    private MockMvc mockMvc;
    @MockBean
    @Qualifier("fakeProduct")
    ProductService productService;
    @Autowired
    private ObjectMapper objectMapper;
    @Test
    void getAllProductsReturnsEmptyListWhenNoProducts() throws Exception{
        when(productService.getAllProducts())
                .thenReturn(new ArrayList<>());

        mockMvc.perform(get("/products"))
                .andExpect(status().is(200));

    }
    @Test
    void returnsListOfProductsWhenProductsExist() throws Exception {
        ArrayList<GenericProductDTO> products = new ArrayList<>();
        products.add(new GenericProductDTO());
        products.add(new GenericProductDTO());
        products.add(new GenericProductDTO());

        when(
                productService.getAllProducts()
        ).thenReturn(
                products
        );

        mockMvc.perform(
                get("/products")
        ).andExpect(
                status().is(200)
        ).andExpect(
                content().string(objectMapper.writeValueAsString(products))
        );
    }
    @Test
    void createProductwhenCalled() throws Exception{
        GenericProductDTO productToCreate = new GenericProductDTO();
        productToCreate.setTitle("iPhone 15 Pro Max");
        productToCreate.setImage("some image");
        productToCreate.setCategory("mobile phones");
        productToCreate.setDescription("Best iPhone Ever");

        GenericProductDTO expectedProduct = new GenericProductDTO();
        expectedProduct.setId(1001L);
        expectedProduct.setTitle("iPhone 15 Pro Max");
        expectedProduct.setImage("some image");
        expectedProduct.setCategory("mobile phones");
        expectedProduct.setDescription("Best iPhone Ever");
        when(productService.createProduct(any()))
                .thenReturn(expectedProduct);
        mockMvc.perform(post("/products")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(productToCreate)))
                .andExpect(status().is(200))
                .andExpect(content().string(objectMapper.writeValueAsString(expectedProduct)));
    }
*/
}
