package com.ProdProject.ProdPro.Security;

import com.ProdProject.ProdPro.DTOs.Status;
import com.ProdProject.ProdPro.DTOs.loginRequestDTO;
import com.ProdProject.ProdPro.DTOs.validateDTO;
import com.ProdProject.ProdPro.DTOs.validateResponseDTO;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TokenAthenticator {
    RestTemplateBuilder restTemplateBuilder;
    public TokenAthenticator(RestTemplateBuilder restTemplateBuilder){
        this.restTemplateBuilder=restTemplateBuilder;
    }
    public ResponseEntity<loginRequestDTO> tokenrequest(loginRequestDTO log){
        RestTemplate restTemplate=restTemplateBuilder.build();
        ResponseEntity<loginRequestDTO> response=restTemplate.postForEntity("http://localhost:9000/auth/login",log,loginRequestDTO.class);
        return response;
    }
    public ResponseEntity<validateResponseDTO> validate(validateDTO validate){
        RestTemplate restTemplate=restTemplateBuilder.build();
        validateResponseDTO val=new validateResponseDTO();
        ResponseEntity<validateResponseDTO> response=restTemplate.postForEntity("http://localhost:9000/auth/validate",val, validateResponseDTO.class);
        return response;
    }
}
