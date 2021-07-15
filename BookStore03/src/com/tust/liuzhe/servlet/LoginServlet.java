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

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       /**
        * 登录
        * 		1.取用户名和密码
        * 		2.调用DAO的登录接口
        * 		3.判断，跳转
        */

    public LoginServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		UserService userService = new UserServiceImpl();
		//1.取用户名和密码值
		String uname = request.getParameter("username");
		String psw = request.getParameter("password");
		//2.调用Service层登录接口
		User user = userService.getUser(new User(null, uname, psw, null));
		if(user == null) {
			//登录失败，根据需求选择转发
			//标记，在域中存放数据
			request.setAttribute("msg", "用户名或密码输入错误");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/pages/user/login.jsp");
			requestDispatcher.forward(request, response);
		}else {
			//登录成功，根据需求选择重定向
			response.sendRedirect(request.getContextPath() + "/pages/user/login_success.jsp");
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
