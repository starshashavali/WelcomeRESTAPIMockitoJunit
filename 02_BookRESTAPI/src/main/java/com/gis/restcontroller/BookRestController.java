package com.gis.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gis.entity.BookEntity;
import com.gis.service.BookService;

@RestController
public class BookRestController {
	@Autowired
	private BookService bookService;

	@PostMapping("/saveBook")
	public ResponseEntity<String> savedBookRecord(@RequestBody BookEntity bookEntity) {
		boolean saveBook = bookService.saveBook(bookEntity);
		if (saveBook) {
			return new ResponseEntity<String>("Successfully saves", HttpStatus.CREATED);
		}
		return new ResponseEntity<String>("Book not inserted ", HttpStatus.BAD_REQUEST);

	}

	@GetMapping("/getBook/{id}")
	public ResponseEntity<BookEntity> getBookById(@PathVariable Integer id) {
		BookEntity bookId = bookService.getBookId(id);
		
		return new ResponseEntity<BookEntity>(bookId, HttpStatus.OK);

	}

	@DeleteMapping("/deleteById/{id}")
	public ResponseEntity<String> deleteById(@PathVariable Integer id) {
		 bookService.deleteBookById(id);
		return new ResponseEntity<String>("success", HttpStatus.OK);
	}

	@GetMapping("/getAllBooks")
	public ResponseEntity<String> getAllBookDtls() {
		bookService.getAllBooks();
		return new ResponseEntity<String>(HttpStatus.OK);
	}
																											// JSON
			
}