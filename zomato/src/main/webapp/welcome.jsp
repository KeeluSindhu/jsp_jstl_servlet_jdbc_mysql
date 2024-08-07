<%@page import="models.zomato"%>
<%@page import="DBconnections.zomatoDBconnections"%>
<%@page import="services.zomatoservice"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>welcome</h1>
<table>
<thead>
<tr>
<th>Id</th>
<th>Name</th>
<th>Email</th>
<th>Password</th>
<th>Confirm Password</th>
<th>Actions</th>
</tr>
</thead>
<tbody>
<%
zomatoservice zs = new zomatoservice(zomatoDBconnections.getconnection());
List<zomato> l = zs.getall();
for(zomato z:l){
%>
<tr>
<td><%=z.getId()%></td>
<td><%=z.getName()%></td>
<td><%=z.getEmail()%></td>
<td><%=z.getPassword()%></td>
<td><%=z.getConfirmpassword()%></td>
<td>
<button>Update</button>
<a href="delete?id=<%=z.getId()%>"><button>Delete</button></a>
</td>
</tr>
<%
}
%>
</tbody>
</table>
</body>
</html>