package com.gis.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.gis.entity.BookEntity;
import com.gis.repo.BookRepo;

public class BookServiceImpl implements BookService {
	@Autowired
	private BookRepo bookRepo;

	@Override
	public boolean saveBook(BookEntity bookEntity) {
	 bookRepo.save(bookEntity);
		return true;
	}
	@Override
	public BookEntity  getBookId(Integer id) {
		
		Optional<BookEntity> bookObj=bookRepo.findById(id);
		
		return bookObj.get();
	}

	@Override
	public String deleteBookById(Integer id) {
		bookRepo.deleteById(id);
		if(bookRepo.existsById(id)) {
			bookRepo.findById(id).get();
			return  "Success";
		}else {
			return "Id not found";
		}
	}
	@Override
	public List<BookEntity> getAllBooks() {
		
		return bookRepo.findAll();
	}


}
