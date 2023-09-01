package com.gis.serviceimp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gis.entity.ProductEntity;
import com.gis.repo.ProductRepo;
import com.gis.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductRepo productRepo;

	@Override
	public boolean saveProduct(ProductEntity productEntity) {

			productRepo.save(productEntity);
	
		return true;

	}

}
