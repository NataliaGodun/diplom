<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/style4simple.css" />" />
<title>Registration</title>
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

		<fmt:setBundle basename="resources.pagecontent" scope="session" />
		<div id="welcome">
			<h1>
				<br />
				<fmt:message key="label.welcome" />
				!!
			</h1>
		</div>
		<div id="content">

			<form action="Controller" method="post">
				<input type="hidden" name="command" value="registration" />
				<fmt:message key="label.nickname" />
				<br /> <input type="text" name="name" value="" /><br />
				<fmt:message key="label.login" />
				<br /> <input type="text" name="login" value="" /><br />
				<fmt:message key="label.password" />
				<br /> <input type="password" name="password" value="" /><br /> <br />
				<input type="submit" value="Registration" />
			</form>
		</div>
		<div id="footer">
			<br /> <br /> <br />
			<fmt:message key="label.allRightReserved" />
		</div>

	</div>
</body>
</html>