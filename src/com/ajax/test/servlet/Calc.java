package com.ajax.test.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;


@WebServlet("/Calc")
public class Calc extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
  


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op = request.getParameter("op");
		int num1 = Integer.getInteger(request.getParameter("num1"));
		int num2 = Integer.getInteger(request.getParameter("num2"));
		PrintWriter pw = response.getWriter();
		int result = 0;
		if("+".equals(op)) {
			result = num1+num2;
		}else if("-".equals(op)) {
			result = num1-num2;
		}else if("/".equals(op)) {
			result = num1/num2;
		}else if("*".equals(op)) {
			result = num1*num2;
		}
		pw.print(result);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
