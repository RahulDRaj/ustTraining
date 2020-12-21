<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2>Vendors</h2>

<table border= "1" >
<tr>
<th>ID</th>
<th>Code</th>
<th>Name</th>
<th>Type</th>
<th>Email</th>
<th>phone</th>
<th>Address</th>
<th>Delete</th>
<th>Edit</th>
</tr>

<c:forEach items = "${vendors}" var = "vendor">
<tr>
<td>${vendor.id}</td>
<td>${vendor.code}</td>
<td>${vendor.name}</td>
<td>${vendor.type}</td>
<td>${vendor.email}</td>
<td>${vendor.phone}</td>
<td>${vendor.address}</td>
<td><a href="deleteVendor?id=${vendor.id}">Delete</a></td>
<td><a href="showUpdate?id=${vendor.id}">Edit</a></td>
</tr>
</c:forEach>
</table>

</body>
</html>