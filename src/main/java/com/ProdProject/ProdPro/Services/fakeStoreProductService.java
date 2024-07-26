package com.ProdProject.ProdPro.Services;

import com.ProdProject.ProdPro.DTOs.GenericProductDTO;
import com.ProdProject.ProdPro.Exceptions.NotFoundException;
import com.ProdProject.ProdPro.ThirdPartyClients.FakeStoreClients;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("fakeProduct")
public class fakeStoreProductService implements ProductService{
    private FakeStoreClients fakeStoreClients;
    public fakeStoreProductService(FakeStoreClients fakeStoreClients){
        this.fakeStoreClients=fakeStoreClients;
    }
    public GenericProductDTO getProductById(Long id) throws NotFoundException {
        return fakeStoreClients.getProductById(id);
    }
    public GenericProductDTO createProduct(GenericProductDTO product){
        return fakeStoreClients.createProduct(product);
    }
    public GenericProductDTO updateProductById(Long id,GenericProductDTO product){
        return fakeStoreClients.updateProductById(id,product);
    }

    @Override
    public GenericProductDTO deleteProductById(Long id) {
        return fakeStoreClients.deleteProductById(id);
    }

    @Override
    public List<GenericProductDTO> getAllProducts() {
        return fakeStoreClients.getAllProducts();
    }

}
