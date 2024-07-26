package com.ProdProject.ProdPro.Repositaries;

import com.ProdProject.ProdPro.Modals.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProductRepositary extends JpaRepository<Product, UUID>{

    Product findBytiltleEquals(String title);
    Product findBytiltleAndPrice_Price(String title,double price);
    Product findByid(UUID id);
}
