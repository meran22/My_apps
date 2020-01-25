<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="tag" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Change Password</title>
</head>
<script type="text/javascript">
	function changePassowrd() {
		document.forms[0].submit();
	}
</script>

<body>
	<%@include file="headder.jsp"%>
	<div>
		<h3 style="color: blue">Change Password....</h3>
	</div>
	<form:form action="${pageContext.request.contextPath}/changePassword.htm" modelAttribute="changePassord" method="post">
		<div>
			<br>

			<table align="center">
				<tr>
					<td colspan="3" align="center"><span style="color: green;">${status}</span></td>
				</tr>
				<tr>
					<td>Old Password</td>
					<td>: <form:password path="oldPassword" /></td>
					<td><span style="color: red;"> <form:errors path="oldPassword" /></span></td>
				</tr>
				<tr>
					<td>New Password</td>
					<td>: <form:password path="newPassword" /></td>
					<td><span style="color: red;"> <form:errors path="newPassword" /></span></td>
				</tr>
				<tr>
					<td>Confirm Password</td>
					<td>: <form:password path="confirmPassword" /></td>
					<td><span style="color: red;"> <form:errors path="confirmPassword" /></span></td>
				</tr>
			</table>
		</div>
		<div align="center">
				<span style="color: red;"><form:errors name="errorcode"/></span><br>
				<input type="button" value="Submit" onclick="changePassowrd()">
				<input type="button" value="Reset" onclick="window.location.href='viewChangePassword.htm'">
			</div>
	</form:form>
	<%@include file="footer.jsp"%>
</body>
</html>