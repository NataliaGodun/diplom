<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Edit Profile</title>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/style4simple.css" />" />
</head>
<body>
	<div id="main">

		<div id="wrapper">
			<div id="header">
				<img
					src="${pageContext.request. contextPath}/resources/images/books.jpg"
					width="100%" />
				<h1>
					<fmt:message key="label.electronicLibrary" />
				</h1>
			</div>
		</div>
		<div id="content">
			<br /> <br /> Select : <br /> <br /> <br />
			<form action="Controller" method="get">
				<input type="hidden" name="command" value="editProfileNameForm" />
				<input type="submit" value="Changes name" />
			</form>
			<br /> <br />
			<form action="Controller" method="get">
				<input type="hidden" name="command" value="editProfilePasswordForm" />
				<input type="submit" value="Changes password" />
			</form>
			<br /> <br />
		</div>
		<br /> <br />
		<div id="footer">
			<br />
			<fmt:message key="label.allRightReserved" />
		</div>
	</div>
</body>
</html>