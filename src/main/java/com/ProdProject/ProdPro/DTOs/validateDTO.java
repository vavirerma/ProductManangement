package com.ProdProject.ProdPro.DTOs;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class validateDTO {
    private UUID id;
    private String token;
}
