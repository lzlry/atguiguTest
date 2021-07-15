package com.tust.liuzhe.servlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tust.liuzhe.service.UserService;
import com.tust.liuzhe.service.impl.UserServiceImpl;


public class BaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置字符集，应用service层接口
				request.setCharacterEncoding("UTF-8");
				response.setContentType("text/html;charset=UTF-8");
				//登录|注册
				String method = request.getParameter("method");
				/*if ("login".equals(method)) {
					login(request,response);			
				} else if("regist".equals(method)){
					regist(request,response);
				}*/
				//使用反射通过方法名动态获取方法对象，从而执行该方法
				try {
					Method declMethod = this.getClass().getDeclaredMethod(method, HttpServletRequest.class,HttpServletResponse.class);
					declMethod.invoke(this, request,response);
				} catch (Exception e) {
					e.printStackTrace();
				} 
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
