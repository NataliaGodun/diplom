<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/s2.css" />" />
<title></title>
</head>
<body>

	<img
					src="${pageContext.request. contextPath}/resources/images/image4.png"
					width="100%" />
	<div id="fon">
		<br />
	<div id="centerAvtorization1">
	<div id="centerAvtorization2">
	
		<strong>Авторизация клиента</strong>	<br /><br />
			
			<form action="Controller" method="post">
				<input type="hidden" name="command" value="AUTHORIZATIONCLIENT" />			
				Логин:
				<br /> <input type="text" name="login" value="" /><br />
				Пароль:
				<br /> <input type="password" name="password" value="" /><br /> <br />
				<input type="submit" value="Войти" />
			</form>
			</div>	
		</div>
	<br />	<br />	<br />
</div>

</body>
</html>