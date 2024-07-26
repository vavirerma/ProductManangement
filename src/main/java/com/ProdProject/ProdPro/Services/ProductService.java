package com.ProdProject.ProdPro.Services;

import com.ProdProject.ProdPro.DTOs.GenericProductDTO;
import com.ProdProject.ProdPro.Exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    GenericProductDTO getProductById(Long id) throws NotFoundException;
    GenericProductDTO createProduct(GenericProductDTO product);
    GenericProductDTO updateProductById(Long id,GenericProductDTO product);
    GenericProductDTO deleteProductById(Long id);
    List<GenericProductDTO> getAllProducts();

}
