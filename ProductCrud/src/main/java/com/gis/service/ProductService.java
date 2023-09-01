package com.gis.service;

import java.util.List;

import com.gis.entity.ProductEntity;

public interface ProductService {
	
	   
	   
		public String upsert(ProductEntity product);

		public ProductEntity getById(Integer cid);

		public List<ProductEntity> getAllProducts();

		public String deleteById(Integer cid);
	}


