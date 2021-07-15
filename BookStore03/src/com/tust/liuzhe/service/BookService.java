package com.tust.liuzhe.service;

import java.util.List;

import com.tust.liuzhe.bean.Book;

public interface BookService {
	public List<Book> getAllBooks();
	
	public void addBook(Book book);
	
	public void delBookById(String id);
	
	public Book getBookById(String id);
	
	public void updateBook(Book book);
}
