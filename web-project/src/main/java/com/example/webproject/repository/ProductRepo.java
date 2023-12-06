package com.example.webproject.repository;

import com.example.webproject.entity.ProductDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<ProductDTO, Long> {
}
