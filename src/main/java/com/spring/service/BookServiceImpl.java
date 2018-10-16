package com.spring.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.dao.BookDao;
import com.spring.model.Book;

@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	private BookDao bookDaoImpl;

	@Override
	@Transactional
	public long saveBook(Book book) {
		return bookDaoImpl.saveBook(book);
	}

	@Override
	@Transactional
	public Book getBook(long id) {
		return bookDaoImpl.getBook(id);
	}

	@Override
	@Transactional
	public List<Book> list() {
		return bookDaoImpl.list();
	}

	@Override
	@Transactional
	public void update(long id, Book book) {
		bookDaoImpl.update(id, book);
	}

	@Override
	@Transactional
	public void delete(long id) {
		bookDaoImpl.delete(id);
	}

}
