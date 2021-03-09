<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>
<style>

fieldset {
width: auto;
}
</style>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
</head>
<body>

<h2>Register User</h2>

<form action="Registered" method="post">
	<fieldset>
	<label for="firstName">First Name:</label> <br/>
	<input name="firstName" type="text" id="firstName" placeholder="First Name" required /> <br/><br/>
	<label for="lastName">Last Name:</label> <br/>
	<input name="lastName" id="lastName" type="text" placeholder="Last Name" required /> <br/><br/>
	<label for="email">Email:</label> <br/>
	<input name="email" id="email" type="text" placeholder="email@example.com" required /> <br/><br/>
	<label for="pswd">Password:</label> <br/>
	<input name="pswd" id="pswd" type="password" placeholder="Password" required /> <br/><br/>
	<input name="Submit" type="submit"/>
	</fieldset>
</form>

</body>
</html>