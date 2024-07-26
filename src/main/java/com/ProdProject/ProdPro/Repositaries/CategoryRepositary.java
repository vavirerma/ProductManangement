package com.ProdProject.ProdPro.Repositaries;

import com.ProdProject.ProdPro.Modals.Category;
import com.ProdProject.ProdPro.Modals.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CategoryRepositary extends JpaRepository<Category, UUID> {
    @Query("SELECT p FROM Product p WHERE p.category.id = :categoryId")
    List<Product> findProductsByCategoryId(@Param("categoryId") UUID categoryId);
}
