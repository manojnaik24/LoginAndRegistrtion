package com.registration;


import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//servlet implementation class registartion

@WebServlet("/register")
public class RegistartionServlet extends HttpServlet{
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   String uname=request .getParameter("name");
	   String umail=request .getParameter("name");
	   String upwd=request .getParameter("name");
	   String umobile=request .getParameter("name");
    PrintWriter out=((ServletResponse) request).getWriter();
    out.print(uname);
    out.print(umail);
    out.print(upwd);
    out.print(umobile);


	}

}
