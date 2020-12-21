<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Location</title>
</head>
<body>

<pre>
	<form action = "saveVen" method="post">
	  Id: <input type = "text" name="id"/>
	  <br>
	Code: <input type = "text" name="code"/>
	<br>
	Name: <input type = "text" name="name"/>
	<br>
	Type: <input type = "text" name="type"/>
	
	<br>
	Email: <input type = "text" name="email"/>
	<br>
	Phone: <input type = "text" name="phone"/>
	<br>
	Address: <input type = "text" name="address"/>
	<br>
	
   	 <input type="submit" value="save"/>
	</form>
</pre>


<p>
${msg} 
</p>

<a href = "displayVendors">View All</a>


</body>
</html>