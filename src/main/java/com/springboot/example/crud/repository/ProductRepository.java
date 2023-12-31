package com.springboot.example.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.example.crud.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	Product findByName(String name);
}
