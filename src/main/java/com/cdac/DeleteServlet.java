package com.cdac;

import java.io.IOException;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DeleteServlet extends HttpServlet{
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		// 1. form se data lega
		
		String sid = req.getParameter("id");
	
		if(sid == null || sid.trim().equals("")) {
			res.getWriter().println("Invalid Id!");
			return;
		}

		int id = Integer.parseInt(sid);
		// 4. StudentDAO ka obejct banaya 
		StudentDAO sd = new StudentDAO();
		
		// 5 DAO ke undar ki method call kari 
		sd.deleteStudent(id);
		
		res.sendRedirect("view");	
	}
}

