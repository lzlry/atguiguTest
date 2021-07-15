package com.tust.liuzhe.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tust.liuzhe.bean.Book;
import com.tust.liuzhe.service.BookService;
import com.tust.liuzhe.service.impl.BookServiceImpl;

import jdk.nashorn.internal.ir.RuntimeNode.Request;

/**
 * Servlet implementation class BookServlet
 */
@SuppressWarnings("unused")
public class BookServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
    BookService bookService = new BookServiceImpl();
	/**
	 *查询所有的book信息 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void getAllBooks(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//取值(这里不用)
		//调用service中的相应方法
		//跳转,book_manager.jsp
		List<Book> books = bookService.getAllBooks();
		//将books存放到域中
		request.setAttribute("books", books);//目前只有这一个页面，所以用最小的域对象
		request.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(request, response);
	}
	
	/**
	 * 添加图书信息
	 * @param reuqest
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	/*protected void addBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//取值，是否需要取值看后面Service中是否需要这些值
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		String price = request.getParameter("price");
		String sales = request.getParameter("sales");
		String stock = request.getParameter("stock");
		//调用service
		bookService.addBook(new Book(null, title, author, Double.parseDouble(price), Integer.parseInt(sales), Integer.parseInt(stock), null));
		//跳转,重新查询一次，
		//getAllBooks(request, response);
		response.sendRedirect(request.getContextPath() + "/BookServlet?method=getAllBooks");
	}*/
	
	protected void delBookById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//取值，是否需要取值看后面Service中是否需要这些值
		String bookId = request.getParameter("bookId");
		//调用Service
		bookService.delBookById(bookId);
		//跳转
		response.sendRedirect(request.getContextPath() + "/BookServlet?method=getAllBooks");
	}
	
	protected void getBookById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//取值，是否需要取值看后面Service中是否需要这些值
		String id = request.getParameter("bookId");
		//调用Service
		Book book = bookService.getBookById(id);
		//将book存放在域对象中
		request.setAttribute("book", book);
		//跳转去update
		request.getRequestDispatcher("/pages/manager/book_update.jsp").forward(request, response);
	}

	protected void updateBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//取值，是否需要取值看后面Service中是否需要这些值
		//通过ID值是否为空，执行相应的方法
		String id = request.getParameter("bookId");
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		String price = request.getParameter("price");
		String sales = request.getParameter("sales");
		String stock = request.getParameter("stock");
		//判断ID是否为空
		if(id == null || "".equals(id)) {
			//调用addBook
			//调用Service
			bookService.addBook(new Book(null, title, author, Double.parseDouble(price), Integer.parseInt(sales), Integer.parseInt(stock), null));
		}else {
			//调用updateBook
			bookService.updateBook(new Book(Integer.parseInt(id), title, author, Double.parseDouble(price), Integer.parseInt(sales), Integer.parseInt(stock), null));
		}
		//跳转去servlet
		response.sendRedirect(request.getContextPath() + "/BookServlet?method=getAllBooks");
		
	}
}
