package com.tust.liuzhe.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.tust.liuzhe.bean.Book;
import com.tust.liuzhe.dao.BookDao;
import com.tust.liuzhe.dao.impl.BookDaoImpl;

class BookDaoImplTest {
	BookDao bookDao = new BookDaoImpl();
	@Test
	void testGetAllBooks() {
		List<Book> allBooks = bookDao.getAllBooks();
		for (Book book : allBooks) {
			System.out.println(book);
		}
	}
	
	@Test
	void testAddBook() {
		bookDao.addBook(new Book(null, "testti", "testau", 25, 100, 200, "statci/img/default,jpg"));
	}
	

}
