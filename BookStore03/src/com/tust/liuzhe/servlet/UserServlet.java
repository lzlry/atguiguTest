package com.tust.liuzhe.servlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tust.liuzhe.bean.User;
import com.tust.liuzhe.service.UserService;
import com.tust.liuzhe.service.impl.UserServiceImpl;

public class UserServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
    UserService userService = new UserServiceImpl();
    
    /**
     * 登录、注册功能
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    
	protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//登录
		HttpSession session = request.getSession();
		//1.取用户名和密码
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		//2.调用DAO层登录接口
		User user = userService.getUser(new User(null, username, password, null));
		if(user == null) {
			//登陆失败，根据需求进行转发
			//标记，在域中存放数据
			request.setAttribute("msg", "用户名或密码输入有误，请重新输入");
			request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);
		}else {
			//登录成功，根据需求进行重定向
			session.setAttribute("user", user);
			response.sendRedirect(request.getContextPath() + "/pages/user/login_success.jsp");
		}
	}
	
	protected void regist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//注册
		//取用户名值
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		
		//调用Service层的方法
		boolean yOn = userService.checkUserName(username);
		if(yOn) {
			//说明已经注册过了
			request.setAttribute("msg", "用户名已存在，请重新输入");
			request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);
		}else {
			//没有注册，调用Service的saveUser方法
			userService.saveUser(new User(null, username, password, email));
			response.sendRedirect(request.getContextPath() + "/pages/user/regist_success.jsp");
		}
	}
	
}
