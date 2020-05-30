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
		
		<c:if test="${not empty  requestScope.messageInfo }">
			<br />
			Ваша заявка успешно удалена!
			<br />
		</c:if>
			<br /><strong>Перечень заявок:</strong><br /><br />
<c:forEach items="${requestScope.List}" var="List">
	<div id="image">
							
						</div>
 							<strong>Идентификационный номер заявки: </strong>
							<c:out value="${List.id }" />
							<br /> <strong>Отдел:</strong>
							<c:out value=" ${List.department}" />		
							<br /><strong>Описание:</strong>
							<c:out value=" ${List.describtion}" />		
							<br /> <strong>Дата и время:</strong>
							<c:out value=" ${List.time}" />
							<br />
							<form action="Controller" method="get">
								<input type="hidden" name="command" value="VIEWDEMAND" /> 
								<input type="hidden" name="id" value="${List.id}" /> 
								<input	type="submit" value="Просмотреть заявку"  />
							</form>
						
					<br />
				</c:forEach>
			<br />
</div>
			
			<br />
		
		</div>

		

</body>
</html>