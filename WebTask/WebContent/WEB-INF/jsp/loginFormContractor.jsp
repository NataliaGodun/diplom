<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/styleNew.css" />" />
<title>Registration</title>
</head>
<body>

	<div id="main">

		<div id="wrapper">
			<div id="header">
				<img
					src="${pageContext.request. contextPath}/resources/images/logo-min.png"
					width="40%" />
				
				<h1>
				+375 29 336-25-26<br />
				+375 29 336-25-26
				</h1>
	        </div>
				
			</div>

		
		
       <div id="loginForm">
			<form action="Controller" method="post">
				<input type="hidden" name="command" value="AUTHORIZATIONCONTRACTOR" />			
				Логин:
				<br /> <input type="text" name="login" value="" /><br />
				Пароль:
				<br /> <input type="password" name="password" value="" /><br /> <br />
				<input type="submit" value="Войти" />
			</form>
		</div>
		
		

	</div>
</body>
</html>