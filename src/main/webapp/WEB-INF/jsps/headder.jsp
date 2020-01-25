<!DOCTYPE html>
<html>
<head>
<style>
ul {
	list-style-type: none;
	margin: 0;
	padding: 0;
	overflow: hidden;
	background-color: #333;
}

.leftTabs {
	float: left;
}

.rightTabs {
	float: right;
}

li a {
	display: block;
	color: white;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
}

li a:hover {
	background-color: #85C1E9;
}

.homeTitle {
	height: 19px;
	width: 1362px;
}
</style>
</head>
<body>
	<div id="HomeTitle">
		<h2 align="center" class="homeTitle">Address Book Management System</h2>
	</div>
	<div id="menuBar">
		<ul>
			<li class="leftTabs"><a class="active" href="${pageContext.request.contextPath}/viewUserInfo.htm">User Info</a></li>
			<li class="leftTabs"><a href="${pageContext.request.contextPath}/viewAddress.htm">View Addresses</a></li>
			<li class="leftTabs"><a href="${pageContext.request.contextPath}/viewChangePassword.htm">Change Password</a></li>
			<li class="rightTabs"><a href="${pageContext.request.contextPath}/logOut.htm">Logout</a></li>
		</ul>
	</div>
</body>
</html>
