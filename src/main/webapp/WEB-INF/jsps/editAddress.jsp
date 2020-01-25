<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>edit Employee</title>
</head>
<script type="text/javascript">
	function updateAddr() {
		document.forms[0].submit();
	}
	function resetData() {

		var addrSeq = document.getElementById('addrSeq').value;
		window.location.href ='${pageContext.request.contextPath}/'+addrSeq+'/editAddDetailsForm.htm';
	}
</script>
<body>
	<%@include file="headder.jsp"%>
	<div>
		<h3 style="color: blue">Edit Address....</h3>
	</div>

	<form:form action="${pageContext.request.contextPath}/addrDetailsSubmit.htm" modelAttribute="addEditForm" method="post">
		<div>
			<div align="center">
				 <input type="button" value="Submit" onclick="updateAddr()">
			     <input type="button" value="Reset" onclick="resetData()">
			     <input type="button" value="Return" onclick="window.location.href='${pageContext.request.contextPath}/viewAddress.htm'">
			</div>
			<form:hidden path="addrSeq"/>
			<br>
			<table align="center">
				<tr>
					<td colspan="3" align="center"><span style="color: green;">${status}</span></td>
				</tr>
				<tr>
					<td>Department</td>
					<td>: <form:input path="dept" /></td>
					<td><span style="color: red;"> <form:errors path="dept" /></span></td>
				</tr>
				<tr>
					<td>Address1</td>
					<td>: <form:input path="address1" /></td>
					<td><span style="color: red;"> <form:errors path="address1" /></span></td>
				</tr>
				<tr>
					<td>Address2</td>
					<td>: <form:input path="address2" /></td>
				</tr>
				<tr>
					<td>Address3</td>
					<td>: <form:input path="address3" /></td>
				</tr>
				<tr>
					<td>Address4</td>
					<td>: <form:input path="address4" /></td>
				</tr>
				<tr>
					<td>Phone No</td>
					<td>: <form:input path="phoneNo" /></td>
					<td><span style="color: red;"> <form:errors path="phoneNo" /></span></td>
				</tr>
				<tr>
					<td>Pin Code</td>
					<td>: <form:input path="pincode" type="number" min="0"/></td>
					<td><span style="color: red;"> <form:errors path="pincode" /></span></td>
				</tr>
				<tr>
					<td>Fax</td>
					<td>: <form:input path="fax" /></td>
					<td><span style="color: red;"> <form:errors path="fax" /></span></td>
				</tr>
				<tr>
					<td>Email</td>
					<td>: <form:input path="email" /></td>
					<td><span style="color: red;"> <form:errors path="email" /></span></td>
				</tr>
				<tr>
					<td>City</td>
					<td>: <form:input path="city" /></td>
					<td><span style="color: red;"> <form:errors path="city" /></span></td>
				</tr>
				<tr>
					<td>State</td>
					<td>: <form:input path="state" /></td>
					<td><span style="color: red;"> <form:errors path="state" /></span></td>
				</tr>
				<tr>
					<td>Country</td>
					<td>:<form:select path="countrySeq">
							<form:options items="${countriesList}" itemValue="countrySeq" itemLabel="countryName" />
						</form:select></td>
					<td><span style="color: red;"> <form:errors path="countrySeq" /></span></td>
				</tr>
			</table>
		</div>
	</form:form>
	<%@include file="footer.jsp"%></ body>
</html>