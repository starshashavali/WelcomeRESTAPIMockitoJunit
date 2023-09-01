package com.gis.service;

import java.util.List;

import com.gis.entity.BookEntity;

public interface BookService {
	
	public boolean saveBook(BookEntity bookEntity);
	
	
	public BookEntity getBookId(Integer id);
	
	public String deleteBookById(Integer id);
	
	public List<BookEntity> getAllBooks();
	
	

	
	
	
	
		
	

}
