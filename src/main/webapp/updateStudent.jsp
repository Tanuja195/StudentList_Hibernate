<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.cdac.Student" %> 
<%@ page import="com.cdac.StudentDAO" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<link rel="stylesheet" href="style.css">

<title>Registration</title>
</head>
<body>

<%
		String sid = request.getParameter("id");		
			// yaha id string me ees liye ayegi kyuki Servlet/JSP me saari request values hamesha String me aati hain

		if(sid == null || sid.trim().isEmpty()                                                                                                                                                                                                                                                              ) {
		    out.println("Invalid ID!");
		    return;
		}
		
		int id = Integer.parseInt(sid);
		
		StudentDAO sd = new StudentDAO();
		Student st = sd.getStudentById(id);
%>


<h2>Student Update Form</h2>

<div class="container">

<form action="update" method="post" class="form-container">

<!-- Hidden input for id: -->

<input type ="hidden" name="id" value="<%= st.getId() %>">

Name   : <input type="text" name = "name" value="<%= st.getName() %>" required> <br> <br>
Email  : <input type="text" name="email" value="<%= st.getEmail() %>" required> <br> <br>
Course : <input type="text" name="course" value="<%= st.getCourse() %>" required> <br> <br><br>

<div style="text-align:center;">
    <a href="update" target="_blank">
        <button type="submit" >Update</button>
    </a>
</div>

</form>
</div>

</body>
</html>