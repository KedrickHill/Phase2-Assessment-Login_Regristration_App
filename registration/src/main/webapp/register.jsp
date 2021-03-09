<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
</head>
<body>

<h2>Register User</h2>

<form action="Registered" method="post">
	<fieldset>
	<label for="firstName">First Name:</label> 
	<input name="firstName" type="text" id="firstName" placeholder="First Name" required /> 
	<label for="lastName">Last Name:</label> 
	<input name="lastName" id="lastName" type="text" placeholder="Last Name" required /> 
	<label for="email">Email:</label> 
	<input name="email" id="email" type="text" placeholder="email@example.com" required /> 
	<label for="pswd">Password:</label> 
	<input name="pswd" id="pswd" type="password" placeholder="Password" required /> 
	<label for="pswd2">Retype Password:</label> 
	<input name="pswd2" id="pswd2" type="password" placeholder="Retype Password" required />
	<input name="Submit" type="submit"/>
	</fieldset>
</form>

</body>
</html>