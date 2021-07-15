package com.tust.liuzhe.dao;

import java.util.List;

import com.tust.liuzhe.bean.Book;

public interface BookDao {
	/**
	 * 查询所有book信息
	 * sql:select * from books
	 */
	public List<Book> getAllBooks();
	
	/**
	 * 添加book信息
	 * sql:insert into books(title,author,price,sales,stock,img_path) values(?,?,?,?,?,?)
	 */
	public void addBook(Book book);
	
	/**
	 * 通过id删除图书信息
	 * @param id
	 */
	public void delBookById(String id);
	
	/**
	 * 通过id获取图书信息
	 * @param id
	 */
	public Book getBookById(String id);
	
	/**
	 * 修改book
	 * sql:update books set title=?,author=?,price=?,sales=?,stock=? where id =?
	 */
	public void updateBook(Book book);
}
