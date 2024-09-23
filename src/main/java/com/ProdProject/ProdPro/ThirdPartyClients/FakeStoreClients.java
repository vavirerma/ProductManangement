package com.ProdProject.ProdPro.ThirdPartyClients;

import com.ProdProject.ProdPro.DTOs.FakeStoreProductDTO;
import com.ProdProject.ProdPro.DTOs.GenericProductDTO;
import com.ProdProject.ProdPro.Exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreClients {
    private RestTemplateBuilder restTemplateBuilder;
    private String fakeStoreURL;
    private String fakeStoreProductsPathURL;
    private RedisTemplate<String,Object> redisTemplate;

    public FakeStoreClients(RedisTemplate<String,Object> redisTemplate,RestTemplateBuilder restTemplateBuilder, @Value("${fakeStore.api.url}")String fakeStoreApiURL, @Value("${fakeStore.api.paths.products}")String fakeStoreProductsURL){
        this.restTemplateBuilder=restTemplateBuilder;
        this.fakeStoreURL=fakeStoreApiURL+fakeStoreProductsURL;
        this.fakeStoreProductsPathURL=fakeStoreApiURL+fakeStoreProductsURL+"/{id}";
        this.redisTemplate=redisTemplate;
    }
    public List<GenericProductDTO> getAllProducts() {
        RestTemplate restTemplate=restTemplateBuilder.build();
        ResponseEntity<GenericProductDTO[]> response = restTemplate.getForEntity(fakeStoreURL,GenericProductDTO[].class);
        List<GenericProductDTO> gtos=new ArrayList<>();
        for(GenericProductDTO i:response.getBody()){
            gtos.add(i);
        }
        return gtos;
    }
    public GenericProductDTO getProductById(Long id) throws NotFoundException {
        GenericProductDTO genericProductDTO=(GenericProductDTO) redisTemplate.opsForHash().get("PRODUCTS",id);
        if(genericProductDTO!=null){
            System.out.println("Mai hu na");
            return genericProductDTO;
        }
        else{
            RestTemplate restTemplate=restTemplateBuilder.build();
            ResponseEntity<FakeStoreProductDTO> response= restTemplate.getForEntity(fakeStoreProductsPathURL, FakeStoreProductDTO.class,id);
            if(response.getBody()==null){
                throw new NotFoundException("This id "+id+" is not found");
            }
            GenericProductDTO product=new GenericProductDTO();
            product.setImage(response.getBody().getImage());
            product.setDescription(response.getBody().getDescription());
            product.setTitle(response.getBody().getTitle());
            product.setPrice(response.getBody().getPrice());
            product.setId(response.getBody().getId());
            if(product.getId()!=null) redisTemplate.opsForHash().put("PRODUCTS",product.getId(),product);
            return product;
        }
    }
    public GenericProductDTO createProduct(GenericProductDTO product){
        RestTemplate restTemplate=restTemplateBuilder.build();
        ResponseEntity<GenericProductDTO> response=restTemplate.postForEntity(fakeStoreProductsPathURL,product,GenericProductDTO.class);
        return response.getBody();
    }
    public GenericProductDTO updateProductById(Long id,GenericProductDTO product){
        RestTemplate restTemplate=restTemplateBuilder.build();
        HttpEntity<GenericProductDTO> request=new HttpEntity(product);
        ResponseEntity<GenericProductDTO> response=restTemplate.exchange(fakeStoreProductsPathURL,HttpMethod.PUT,request,GenericProductDTO.class);
        return response.getBody();
    }

    public GenericProductDTO deleteProductById(Long id) {
        RestTemplate restTemplate=restTemplateBuilder.build();
        RequestCallback requestCallback = restTemplate.acceptHeaderRequestCallback(GenericProductDTO.class);
        ResponseExtractor<ResponseEntity<GenericProductDTO>> responseExtractor = restTemplate.responseEntityExtractor(GenericProductDTO.class);
        ResponseEntity<GenericProductDTO> response=restTemplate.execute(fakeStoreProductsPathURL, HttpMethod.DELETE,requestCallback,responseExtractor,id);
        return response.getBody();
    }

}
