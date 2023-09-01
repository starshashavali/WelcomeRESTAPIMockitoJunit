package com.gis.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gis.entity.BookEntity;

public interface BookRepo extends JpaRepository<BookEntity, Integer>{
	
}