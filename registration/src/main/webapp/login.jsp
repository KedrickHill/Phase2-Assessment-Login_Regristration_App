<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<h2>Login to Credentials</h2>
<body>
<form action="login" method="post">
	Email: <input name="email" type="text" id="email" placeholder="Username" required/><br/>  
	Password: <input name="pswd" type="password" id="pswd" placeholder="Password" required/><br/>  
	<input name="Submit" type="submit"/>
</form>
</body>
</html>