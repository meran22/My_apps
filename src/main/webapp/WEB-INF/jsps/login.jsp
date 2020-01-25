<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<style type="text/css">
.errorsStyleClass {
	color: red;
}
</style>
</head>
<body>
	<div style="height: 192px;"></div>
	<div align="center">
		<h2>Address Book Login...</h2>
		<form:form action="${pageContext.request.contextPath}/loginSubmit.htm"
			modelAttribute="login">
			<table>
				<tr>
					<td align="center" colspan="2"><samp class="errorsStyleClass">${userMessage}</samp></td>
				</tr>
				<tr>
					<td>Login Id</td>
					<td>: <form:input path="loginId" name="loginId" />
					<form:errors path="loginId" class="errorsStyleClass" /></td>
				</tr>
				<tr>
					<td>Password</td>
					<td>: <form:password path="password" name="password" />
					<form:errors path="password" class="errorsStyleClass" /></td>
				</tr>
				<tr>
					<td colspan="2" align="center" style="height: 40px;width: 337px;">
					   <input type="submit" value="Login"> &nbsp 
					   <input type="reset" value="Clear" onclick="window.location.href='${pageContext.request.contextPath}/ViewLogin.htm'">
					</td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
<%@include file="footer.jsp"%></ body>
</html>