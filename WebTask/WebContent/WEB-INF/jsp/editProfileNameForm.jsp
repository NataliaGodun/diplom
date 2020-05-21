<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Edit name for user</title>
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
			<form action="Controller" method="post">
				<input type="hidden" name="command" value="EditProfileName" />
				<br /> <br /> <br />
				Enter new name:<br /> <br /> <br />  <input type="text" name="name"
					value="" /> <input type="submit" value="Keep changes" /> <br />
				<br /> <br /> <br /> <br /> <br /> <br />
			</form>
		</div>
		<div id="footer">
			<br />
			<fmt:message key="label.allRightReserved" />
		</div>

	</div>
</body>
</html>