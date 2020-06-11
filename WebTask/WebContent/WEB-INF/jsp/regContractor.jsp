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
			<div id="addContr">
<div id="addContr2">

		<form action="Controller" method="get">
				<input type="hidden" name="command" value="REGCONTRACTOR" /> <br />
				Имя: <br />    <input type="text" name="firstName" value="" required /><br />				
				Фамилия: <br />  <input type="text" name="lastName" value="" required /><br />	
				Телефон: <br />  <input type="text" name="phone" value="" required/><br />	
				Дата рождения: <br />  <input type="text" name="dateOfBirth" value="" required/><br />			
				Паспорт: <br /><input type="text" name="passport" value="" required/><br />	
				Логин:  <br />   <input type="text" name="login" value="" required/><br />				
				Пароль: <br />  <input type="password" name="password" value="" required/><br />	
				Отдел: <br /><select  name="department">
    <option value="Вентиляция и кондиционирование">Вентиляция и кондиционирование</option>
    <option value="Водоснабжение и канализация">Водоснабжение и канализация</option>
    <option value="Электроснабжение">Электроснабжение</option>
   </select>
			<br />	<br /><br />
				<input type="submit" value="Сохранить данные о сотруднике"  />
			</form>

			
			
			<br />
			
		</div></div></div>

		
	</div>
</body>
</html>