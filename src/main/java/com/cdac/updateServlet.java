package com.cdac;

import java.io.IOException;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class updateServlet extends HttpServlet{
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		// 1. form se data lega
		
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String course = req.getParameter("course");
		
		// 2. Student ka object banaya 
		Student s = new Student();
		
		// 3. student object me update values set kiya 
		s.setId(id);
		s.setName(name);
		s.setEmail(email);
		s.setCourse(course);

		// 4. StudentDAO ka obejct banaya 
		StudentDAO sd = new StudentDAO();
		
		// 5 DAO ke undar ki method call kari 
		sd.updateStudent(s);
		
		res.sendRedirect("view");	
	}
}
