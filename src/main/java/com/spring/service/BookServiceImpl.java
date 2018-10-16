package com.spring.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.spring.dao.BookDao;
import com.spring.dao.BookDaoImpl;
import com.spring.model.Book;

@Service
public class BookServiceImpl implements BookService {
	
	//@Autowired
	private BookDao bookDao = new BookDaoImpl();

	@Override
	@Transactional
	public long saveBook(Book book) {
		return bookDao.saveBook(book);
	}

	@Override
	@Transactional
	public Book getBook(long id) {
		return bookDao.getBook(id);
	}

	@Override
	@Transactional
	public List<Book> list() {
		return bookDao.list();
	}

	@Override
	@Transactional
	public void update(long id, Book book) {
		bookDao.update(id, book);
	}

	@Override
	@Transactional
	public void delete(long id) {
		bookDao.delete(id);
	}

}
