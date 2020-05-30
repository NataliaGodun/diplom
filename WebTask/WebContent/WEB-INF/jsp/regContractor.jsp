<%@ page language="java" contentType="text/html; charset=utf-8"
 pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Welcome</title>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/s3.css" />" />
</head>
<body>

	<img
					src="${pageContext.request. contextPath}/resources/images/image4.png"
					width="100%" />
		
		<div id="fon">
			<div id="profil"> 	 <strong>Личный кабинет администратора</strong>
			<form action="Controller" method="get">
				<input type="hidden" name="command" value="exit" /> <br /> <input
					type="submit" value="Выход" />
			</form></div>
			<div id="centerLKklient">
			

		<form action="Controller" method="get">
				<input type="hidden" name="command" value="REGCONTRACTOR" /> <br />
				Имя: <br />    <input type="text" name="firstName" value="" /><br />				
				Фамилия: <br />  <input type="text" name="lastName" value="" /><br />	
				Телефон: <br />  <input type="text" name="phone" value="" /><br />	
				Дата рождения: <br />  <input type="text" name="dateOfBirth" value="" /><br />			
				Паспорт: <br /><input type="text" name="passport" value="" /><br />	
				Логин:  <br />   <input type="text" name="login" value="" /><br />				
				Пароль: <br />  <input type="password" name="password" value="" /><br />		
				Отдел: <br /><input type="text" name="department" value="" /><br />	<br />	
				<input type="submit" value="Зарегистрировать сотрудника"  />
			</form>

			
			
			<br />
			
		</div>

		
	</div>
</body>
</html>