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
	
		<form action="Controller" method="get">
				<input type="hidden" name="command" value="exit" /> <br /> <input
					type="submit" value="Выход" />
			</form>
		
<div id="inline">
			<div id="content">
  				 <div id="center">
  				 
		<strong>Перечень заявок по отделу "<c:out value="${requestScope.department}" />" :</strong><br />
<c:forEach items="${requestScope.List}" var="List">
	<div id="image">
							
						</div>
	
							<br /><strong>Описание:</strong>
							<c:out value=" ${List.describtion}" />		
							<br /> <strong>Дата и время:</strong>
							<c:out value=" ${List.time}" />
							<br /> <strong>Cтатус:</strong>
							<c:out value=" ${List.status_demand}" />
							<br />
							<form action="Controller" method="get">
								<input type="hidden" name="command" value="CHANGESTATUS" /> 
								<input type="hidden" name="id" value="${List.id}" /> 
								<input	type="submit" value="Изменить статус заявки"  />
							</form>			<br />
							<form action="Controller" method="get">
								<input type="hidden" name="command" value="CREATEACT" /> 
								<input type="hidden" name="id" value="${demand.id }" /> 
								<input	type="submit" value="Создать акт"  />
							</form>
							
						
					<br />
				</c:forEach>
			<br />
</div>
		</div>
		</div>	
			<br />
			
		</div>

		

</body>
</html>