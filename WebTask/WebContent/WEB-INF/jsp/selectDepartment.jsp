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
		<div id="profil"> 
			<div id="profil1"> 
		 <strong>	Клиент, <c:out value="${sessionScope.firstName}" /></strong>
			<form action="Controller" method="get">
				<input type="hidden" name="command" value="exit" /> <br /> <input
					type="submit" value="Выход" />
					
			</form></div></div>
			
			<div id="centerLKklient">
			 <strong> Согласно заключенного договора вы можете подать заявку на следующие отделы:</strong>

			<form action="Controller" method="get">
			<input type="hidden" name="department" value="Вентиляция и кондиционирование" /> <br />
				<input type="hidden" name="command" value="VENTILACIADEMAND" /> <br />
				<input type="submit" value="Вентиляция и кондиционирование" />
			</form>
			<form action="Controller" method="get">
			<input type="hidden" name="department" value="Водоснабжение и канализация" /> <br />
				<input type="hidden" name="command" value="VENTILACIADEMAND" /> <br />
				<input type="submit" value="   Водоснабжение и канализация   " />
			</form>
			<form action="Controller" method="get">
			<input type="hidden" name="department" value="Электроснабжение" /> <br />
				<input type="hidden" name="command" value="VENTILACIADEMAND" /> <br />
				<input type="submit" value="            Электроснабжение             " />
			</form>

			
			<br />
			
			<br />
			
		</div></div>

		

</body>
</html>