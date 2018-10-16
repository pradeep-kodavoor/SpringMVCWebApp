package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.model.Book;
import com.spring.service.BookService;

@CrossOrigin("*")
@RestController
public class BookController {

	@Autowired
	BookService bookServiceImpl;
	
	@GetMapping("/api/book")
	public ResponseEntity<List<Book>> list(){
		List<Book> booksList =  bookServiceImpl.list();
		return ResponseEntity.ok().body(booksList);
	}
	
	@PostMapping("api/book")
	public ResponseEntity<?> save(@RequestBody Book book){
		long id = bookServiceImpl.saveBook(book);
		return ResponseEntity.ok().body("Book created with id: "+id);
	}
	
	@GetMapping("api/book/{id}")
	public ResponseEntity<Book> get(@PathVariable("id") long id){
		Book book = bookServiceImpl.getBook(id);
		return ResponseEntity.ok().body(book); 
	}
	
	@PutMapping("api/book/{id}")
	public ResponseEntity<?> update(@PathVariable long id,@RequestBody Book book) {
		bookServiceImpl.update(id, book);
		return ResponseEntity.ok().body("Book has been updated");
		
	}
	
	@DeleteMapping("api/book/{id}")
	public ResponseEntity<?> delete(@PathVariable long id){
		bookServiceImpl.delete(id);
		return ResponseEntity.ok().body("Book has been deleted");
		
	}
}
