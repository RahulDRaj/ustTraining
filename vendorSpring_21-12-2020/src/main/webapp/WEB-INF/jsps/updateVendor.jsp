<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Location</title>
</head>
<body>

<pre>
	<form action = "updateVen" method="post">
	  Id: <input type = "text" name="id" value="${vendor.id}" readonly="readonly"/>
	  <br>
	Code: <input type = "text" name="code" value="${vendor.code}"/>
	<br>
	Name: <input type = "text" name="name" value="${vendor.name}"/>
	<br>
	Name: <input type = "text" name="type" value="${vendor.type}"/>
	<br>
	Name: <input type = "text" name="email" value="${vendor.email}"/>
	<br>
	Name: <input type = "text" name="phone" value="${vendor.phone}"/>
	<br>
	Name: <input type = "text" name="address" value="${vendor.address}"/>
	<br>
	
   	 <input type="submit" value="save"/>
	</form>
</pre>


<p>
${msg} 
</p>

<a href = "displayLocations">View All</a>

</body>
</html>