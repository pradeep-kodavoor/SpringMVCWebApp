package com.spring.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;*/
import org.springframework.stereotype.Repository;

import com.spring.model.Book;

@Repository
public class BookDaoImpl implements BookDao {  
	
	static Map<Long, Book> booksMap = new HashMap<>();
	static {
		Book java = new Book();
		java.setId(1L);
		java.setTitle("Java Development Guide");
		java.setAuthor("Robert C Martin");
		booksMap.put(1L,java);
	}
	
	static long id =2;
	
	/*@Autowired
	private SessionFactory sessionFactory;*/

	@Override
	public long saveBook(Book book) {
		//sessionFactory.getCurrentSession().save(book);
		System.out.println("Save Book: "+book);
		book.setId(id++);
		booksMap.put(book.getId(),book);
		return book.getId();
	}

	@Override
	public Book getBook(long id) {
		
		//sessionFactory.getCurrentSession().get(Book.class, id);
		
		return booksMap.get(id);
	}

	@Override
	public List<Book> list() {
		
		//return sessionFactory.getCurrentSession().createQuery("from Book").list();
		
		//Mock DB
		System.out.println("List of Books: "+booksMap.values());
		
		List<Book> booksList =  new ArrayList<Book>(booksMap.values());
		return booksList;
	}

	@Override
	public void update(long id, Book book) {
		
		/*Session session = sessionFactory.getCurrentSession();
		Book oldBook = session.byId(Book.class).load(id);
		oldBook.setAuthor(book.getAuthor());
		oldBook.setTitle(book.getTitle());
		session.flush();*/
		
		
		Book updatedBook = booksMap.get(id);
		updatedBook.setAuthor(book.getAuthor());
		updatedBook.setTitle(book.getTitle());
		booksMap.put(id, updatedBook);
	}

	@Override
	public void delete(long id) {
		
		/*Session session = sessionFactory.getCurrentSession();
		Book book = session.byId(Book.class).load(id);
		session.delete(book);*/
		
		booksMap.remove(id);
	}
}
