package com.gis.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gis.entity.ProductEntity;
import com.gis.repo.ProductRepo;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductRepo productRepo;

	@Override
	public String upsert(ProductEntity product) {

		productRepo.save(product); 

		return "success";
	}

	@Override
	public ProductEntity getById(Integer cid) {
		Optional<ProductEntity> findById = productRepo.findById(cid);

		if (findById.isPresent()) {
			return findById.get();
		}
		return null;
	}

	@Override
	public List<ProductEntity> getAllProducts() {
		// TODO Auto-generated method stub
		return productRepo.findAll();
	}

	@Override
	public String deleteById(Integer cid) {

		if (productRepo.existsById(cid)) {
			productRepo.deleteById(cid);
			return "Delete Success";
		} else {
			return "No Record Found";
		}
	

	}

}
