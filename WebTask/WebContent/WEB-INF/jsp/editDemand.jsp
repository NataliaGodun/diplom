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
	href="<c:url value="/resources/css/styleNew.css" />" />
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
	
		<img
					src="${pageContext.request. contextPath}/resources/images/image2.png"
					width="100%" />
		<br /> <br />
		
			<form action="Controller" method="get">
				<input type="hidden" name="command" value="EDITDEMAND" /> 
				<input type="hidden" name="id" value="${demand.id }" /> 
				<input type="hidden" name="id_client" value="${demand.id_client }" /> 
				<input type="hidden" name="photo" value="${demand.photo }" /> 	
				<input type="hidden" name="department" value="${demand.department}" /> 						
				 <strong>Идентификационный номер заявки: </strong>
				<c:out value="${demand.id }" /><br />
				<strong>Отдел: </strong>
				<c:out value="${demand.department }" /><br />
				<strong>Заявка: </strong>
				<c:out value="${demand.describtion }" /><br />
				<strong>Адрес: </strong>
				<c:out value="${demand.address }" /><br />
				<strong>Внесите изменения: </strong>
				<input type="text" name="describtion" value="" />
				<input type="text" name="address" value="" />
				<input type="submit" value="Готово!" />
			</form>
	
				

			
			<br />
			
			<br />
			<form action="Controller" method="get">
				<input type="hidden" name="command" value="exit" /> <br /> <input
					type="submit" value="Выход" />
			</form>
		</div>

		

</body>
</html>