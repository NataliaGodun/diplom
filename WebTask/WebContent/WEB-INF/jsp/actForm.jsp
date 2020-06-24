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
				<div id="centerViewDemand"> 

	Акт выполненных работ к заявке № <c:out value="${requestScope.demand_id}" /><br />
		<form action="Controller" method="get">
				<input type="hidden" name="demand_id" value="${requestScope.demand_id}" /> <br />
				<input type="hidden" name="command" value="CREATEACT" /> <br />			
				Наименование выполненных работ: <br />
				 <textarea name="describtion" cols="40" rows="5" required></textarea></p>		
				Примечание:  <br />   
				 <textarea name="comment" cols="40" rows="4" required></textarea></p>					
					
				
			<br />	
				<input type="submit" value="Сохранить акт"  />
			</form>
		
		
			</div>
		
			<br />
	</div>
		

		

</body>
</html>