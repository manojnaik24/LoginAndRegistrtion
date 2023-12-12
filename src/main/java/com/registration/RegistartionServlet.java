package com.registration;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//servlet implementation class registartion

@WebServlet("/register")
public class RegistartionServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   String uname=request .getParameter("name");
	   String uemail=request .getParameter("email");
	   String upwd=request .getParameter("pass");
	   String umobile=request .getParameter("contact");
	   RequestDispatcher dispacther=null;
	   Connection con=null;
    try {
    	class.forName("com.mysql.cj.jdbc.Driver");
    	DriverManager.getConnection("jdbc:mysql://localhost:3360/youtube","root","root");
    	PreparedStatement pst = con.
    	prepareStatement("insert into users (uname, upwd, uemail, umobile) values (?,?,?,?) ");
    	pst.setString(1, uname);
    	pst.setString(2, upwd);
    	pst.setString(3, uemail);
    	pst.setString(4, umobile);
    	
    	int rowCount = pst.executeUpdate();
    	dispacther=request.getRequestDispatcher("registeration.jsp");
    	if (rowCount >0)
    	{
    		request.setAttribute("status", "sucess");
    	}else {
    		request.setAttribute("status", "failed");
    	}
    	dispacther.forward(request, response);
    	
    }catch(Exception  e){
    	e.printStackTrace();
    }finally {
    	try {
    		con.close();
    	}catch (Exception e) {
    		e.printStackTrace();
		}
    }

    
    
	
    }
}