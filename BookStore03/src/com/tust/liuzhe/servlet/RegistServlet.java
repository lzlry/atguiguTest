package com.tust.liuzhe.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tust.liuzhe.bean.User;
import com.tust.liuzhe.service.UserService;
import com.tust.liuzhe.service.impl.UserServiceImpl;


public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public RegistServlet() {
        super();
       
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**
		 * 注册
		 * 		1.取值
		 * 		2.校验用户名是否存在
		 * 			不存在：调用saveUser();
		 * 			存在：跳转回注册页
		 */
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		UserService userService = new UserServiceImpl();

		//取用户名值
		String username = request.getParameter("username");
		String psw = request.getParameter("password");
		String email = request.getParameter("email");
		//调用service中的方法
		boolean yOn = userService.checkUserName(username);
		if(yOn) {
			//用户名存在，转发
			
			//给request设置一个"msg"属性，在这个条件(yOn为true)下，msg携带一条String，不是null,在jsp
			//中会进行判断，如果msg不为空，那说明这个用户名存在了，就需要显示这条String
			request.setAttribute("msg", "用户名已经存在，请重新输入");
			
			//表达回显，如果用户名存在，需要在输入框中继续显示用户名帮助用户修改，并继续显示邮箱，以免用户重新输入一遍
			//request.setAttribute("uname", username);
			//request.setAttribute("email", email);
			//但是request在转发中此对象一直存在，即转发会携带request，所以不用这么麻烦，直接用get方法即可
			
			
			
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("pages/user/regist.jsp");
			requestDispatcher.forward(request, response);
		}else {
			//用户名不存在,saveUser();
			userService.saveUser(new User(null, username, psw, email));
			//重定向到注册成功
			response.sendRedirect(request.getContextPath() + "/pages/user/regist_success.jsp");
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
