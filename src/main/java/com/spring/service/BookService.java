package com.spring.service;

import java.util.List;

import com.spring.model.Book;

public interface BookService {
	long saveBook(Book book);
	
	Book getBook(long id);
	
	List<Book> list();
	
	void update(long id, Book book);
	
	void delete(long id);
}
