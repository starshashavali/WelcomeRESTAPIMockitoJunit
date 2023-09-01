package com.gis.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gis.entity.ProductEntity;

public interface ProductRepo extends JpaRepository<ProductEntity, Integer> {

}
