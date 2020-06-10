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
		 <strong>	Сотрудник, <c:out value="${sessionScope.firstName}" /></strong>
			<form action="Controller" method="get">
				<input type="hidden" name="command" value="exit" /> <br /> <input
					type="submit" value="Выход" />
					
			</form></div></div>
			<div id="centerLKklient">
  				 
		<strong>Перечень заявок по отделу <br />"<c:out value="${requestScope.department}" />" :</strong><br />
<c:forEach items="${requestScope.List}" var="List">
	<div id="image">
							
						</div>
							<br /> <strong>Идентификационный номер заявки: </strong>
							<c:out value=" ${List.id}" />		
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
								<input type="hidden" name="id" value="${List.id }" /> 
								<input	type="submit" value="         Создать акт           "  />
							</form>
							
						
					<br />
				</c:forEach>
			<br />
</div>
		
	</div>	

</body>
</html>