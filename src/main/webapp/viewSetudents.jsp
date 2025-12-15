<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.cdac.Student" %>
<%@ page import="java.util.*" %>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>View Book</title>
</head>

<body>
<h2>All Registered Students</h2>

<table border="1" cellpadding="10">

    <tr>
        <th>ID</th><th>Name</th><th>Email</th><th>Course</th>
    </tr>

<%
    List<Student> list = (List<Student>) request.getAttribute("studentList");
    for (Student s : list) {
%>
    <tr>
    	<td><%= s.getId() %></td>
        <td><%= s.getName() %></td>
        <td><%= s.getEmail() %></td>
        <td><%= s.getCourse() %></td>
        
        <td>
        	<a href="updateStudent.jsp?id=<%= s.getId()%>"><button>Update</button></a>
        	<a href="delete?id=<%= s.getId()%>" onclick ="return confirm('Are you sure?')"><button>Delete</button></a>
        		<!-- yaha pe ye delete web app vala ayega taki delete servlet run hoga vaha se  -->
        </td>
        
    </tr>
<%
    }
%>
</table>

<br>
<a href="register.html"><button>Register Another Student</button></a>

</body>
</html>