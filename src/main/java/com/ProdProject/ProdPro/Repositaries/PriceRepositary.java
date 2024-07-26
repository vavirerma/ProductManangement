package com.ProdProject.ProdPro.Repositaries;

import com.ProdProject.ProdPro.Modals.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PriceRepositary extends JpaRepository<Price, UUID> {
}
