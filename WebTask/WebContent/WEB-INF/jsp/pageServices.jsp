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
			<c:if test="${not empty  requestScope.messageWrongDelate }">
			<br />
			<c:out value="${  requestScope.messageWrongDelate }" />
			<br />
		</c:if>
		
		
<c:forEach items="${requestScope.List}" var="List">
	<div id="image">
							<c:if test="${not empty  List.photo}">
								<img
									src="${pageContext.request. contextPath}/ImageController?command=GetImage&index=${List.photo}"
									width="50%" />
							</c:if>
						</div>

							<br /> <strong>Отдел</strong>
							<c:out value=" ${List.department}" />		
							<br /><strong>Описание</strong>
							<c:out value=" ${List.describtion}" />		
							<br /> <strong>Дата</strong>
							<c:out value=" ${List.time}" />
							<br /> <strong>Статус</strong>
							<c:out value=" ${List.status_demand}" />
							
							<br />
							
						
		
							<form action="Controller" method="get">
								<input type="hidden" name="command" value="DELETEDEMAND" /> 
								<input type="hidden" name="id" value="${List.id}" /> 
								<input type="hidden" name="status" value="${List.status_demand}" />
								<input	type="submit" value="Удалить заявку"  />
							</form>
							<form action="Controller" method="get">
								<input type="hidden" name="command" value="EDITDEMANDFORM" />
								<input type="hidden" name="id" value="${List.id}" /> 
								<input type="hidden" name="describtion" value="${List.describtion}" />
								<input type="hidden" name="department" value="${List.department}" /> 
								 <input type="submit" value="Редактировать" />
							</form>
	
					<br />
				</c:forEach>
			<br />
			
			<br />
			<form action="Controller" method="get">
				<input type="hidden" name="command" value="exit" /> <br /> <input
					type="submit" value="Выход" />
			</form>
		</div>

		

</body>
</html>