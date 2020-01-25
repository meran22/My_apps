<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
</head>
<body>
	<%@include file="headder.jsp"%>
	<div>
		<h3 style="color: blue">Logged in user Information....</h3>
	</div>

	<div>
		<table align="center">
			<tr>
				<td>User Id</td>
				<td>: ${user.loginId}</td>
			<tr>
			<tr>
				<td>Name</td>
				<td>: ${user.name}</td>
			</tr>
			<tr>
				<td>Email</td>
				<td>: ${user.email}</td>
			</tr>
			<tr>
				<td>Last Name</td>
				<td>: ${user.phoneNo}</td>
			</tr>
			<tr>
				<td>Department</td>
				<td>: ${user.dept}</td>
			</tr>
		</table>
	</div>
	<%@include file="footer.jsp"%>
</body>
</html>