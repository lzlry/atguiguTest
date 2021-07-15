package com.tust.liuzhe.service.impl;

import java.util.List;

import com.tust.liuzhe.bean.Book;
import com.tust.liuzhe.dao.BookDao;
import com.tust.liuzhe.dao.impl.BookDaoImpl;
import com.tust.liuzhe.service.BookService;

public class BookServiceImpl implements BookService {
	private BookDao bookDao = new BookDaoImpl();
	@Override
	public List<Book> getAllBooks() {
		
		return bookDao.getAllBooks();
	}
	@Override
	public void addBook(Book book) {
		 bookDao.addBook(book);
		
	}
	@Override
	public Book getBookById(String id) {
		return bookDao.getBookById(id);
		
	}
	@Override
	public void updateBook(Book book) {
		bookDao.updateBook(book);
		
	}
	@Override
	public void delBookById(String id) {
		bookDao.delBookById(id);
		
	}
	
	
}
