package com.ProdProject.ProdPro.DTOs;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class GenericProductDTO implements Serializable {
    private Long id;
    private String title;
    private double price;
    private String category;
    private String description;
    private String image;

}
