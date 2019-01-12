package com.itheima.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ServletDemo1 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String fToken = request.getParameter("token");//隐藏域中的令牌
		HttpSession session = request.getSession();
		String sToken = (String) session.getAttribute("token");
		
		//检查令牌
		if(fToken.equals(sToken)){
			String name = request.getParameter("name");
//			try {
//				Thread.sleep(3000);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
			System.out.println(name);
			//把令牌从HttpSession中删除掉
			session.removeAttribute("token");
		}else{
			response.getWriter().write("Please do not resubmit");
		}
		
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
