<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>view Addresses</title>
</head>
<script type="text/javascript">

	function searchAddr() {
		document.forms[0].submit();
	}
	function addrDetails() {

		var checkedValue = null;
		var inputElements = document.getElementsByClassName('messageCheckbox');
		for ( var i = 0; inputElements[i]; ++i) {
			if (inputElements[i].checked) {
				checkedValue = inputElements[i].value;
				break;
			}
		}
		window.location.href ='${pageContext.request.contextPath}/'+checkedValue+'/editAddDetailsForm.htm';
	}
</script>

<body>
	<%@include file="headder.jsp"%>
	<div>
		<h3 style="color: blue">View Addresses</h3>
	</div>
	<div align="Right" style="height: 28px; width: 1342px;">
		<input type="button" value="Search" onclick="searchAddr()">
		 <input type="button" value="Add" onclick="window.location.href='${pageContext.request.contextPath}/viewAddAddrForm.htm'"> 
		 <input type="button" value="Details" onclick="addrDetails()">
		  <input type="button" value="Clear" onclick="window.location.href='${pageContext.request.contextPath}/viewAddress.htm'">
	</div>
	<div>

		<table border="1">
			<form:form
				action="${pageContext.request.contextPath}/viewAddresses.htm"
				method="post" modelAttribute="searchForm">
				<tr>
					<td width="10%"><form:input path="address1" /></td>
					<td width="10%"><form:input path="phoneNo" /></td>
					<td width="10%"><form:input path="pincode" /></td>
					<td width="10%"><form:input path="email" /></td>
					<td width="10%"><form:input path="city" /></td>
					<td width="15%"><form:input path="state" /></td>
					<td width="10%"><form:select path="countrySeq" style="height: 19px; width: 135px;" placeholder="Select Country">
							<form:options items="${countriesList}" itemValue="countrySeq" itemLabel="countryName" />
						</form:select></td>
					<td width="2%">Sel.</td>
				</tr>
			</form:form>
			<tr style="color: red">
				<td width="10%">Address1</td>
				<td width="10%">Phone No</td>
				<td width="10%">Pin Code</td>
				<td width="10%">Email</td>
				<td width="10%">City</td>
				<td width="15%">State</td>
				<td width="10%">Country</td>
				<td width="2%">Sel.</td>
			</tr>
			<c:forEach items="${addrList}" var="addr">
				<tr>
					<td width="10%">${addr.addr1}</td>
					<td width="10%">${addr.phone}</td>
					<td width="10%">${addr.pincode}</td>
					<td width="10%">${addr.email}</td>
					<td width="10%">${addr.city}</td>
					<td width="15%">${addr.state}</td>
					<td width="10%">${addr.countryName}</td>
					<td width="2%"><input type="checkbox" name="addrSeq"
						class="messageCheckbox" value="${addr.addrSeq}"></td>
				</tr>
			</c:forEach>
		</table>

	</div>
	<%@include file="footer.jsp"%>
</body>
</html>