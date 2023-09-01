package com.gis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gis.entity.ProductEntity;
import com.gis.service.ProductService;

@RestController
public class ProductController {
	@Autowired
	private ProductService productService;

	@PostMapping("/save")
	public ResponseEntity<String> createCourse(@RequestBody ProductEntity product) {
		String status = productService.upsert(product);
		return new ResponseEntity<>(status, HttpStatus.CREATED);
	}

	@GetMapping("/product/{pid}")
	public ResponseEntity<ProductEntity> getCourse(@PathVariable Integer cid) {
		ProductEntity product = productService.getById(cid);
		return new ResponseEntity<>(product, HttpStatus.OK);
	}

	@GetMapping("/product")
	public ResponseEntity<List<ProductEntity>> getAllCourses() {
		List<ProductEntity> allProducts = productService.getAllProducts();
		return new ResponseEntity<>(allProducts, HttpStatus.OK);
	}

	@PutMapping("/product")
	public ResponseEntity<String> updateCourse(@RequestBody ProductEntity product) {
		String status = productService.upsert(product);
		return new ResponseEntity<>(status, HttpStatus.OK);
	}

	@DeleteMapping("/product/{pid}")
	public ResponseEntity<String> deleteCourse(@PathVariable Integer pid) {
		String status = productService.deleteById(pid);
		return new ResponseEntity<>(status, HttpStatus.OK);
	}

}