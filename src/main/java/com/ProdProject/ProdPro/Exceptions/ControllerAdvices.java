package com.ProdProject.ProdPro.Exceptions;

import com.ProdProject.ProdPro.DTOs.ExceptionDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerAdvices {
    @ExceptionHandler(value = NotFoundException.class)
    public ResponseEntity<ExceptionDTO> notfoundExceptionHandler(NotFoundException notFoundException){
        return new ResponseEntity(new ExceptionDTO(HttpStatus.NOT_FOUND,notFoundException.getMessage()),HttpStatus.NOT_FOUND);
    }

}
