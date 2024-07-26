package com.ProdProject.ProdPro.Exceptions;

import lombok.Getter;

@Getter
public class NotFoundException extends Exception{
    public NotFoundException(String message){
        super(message);
    }

}
