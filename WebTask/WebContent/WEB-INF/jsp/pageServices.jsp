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
	href="<c:url value="/resources/css/s2.css" />" />
</head>
<body>

	<div id="main">

		<img
					src="${pageContext.request. contextPath}/resources/images/image4.png"
					width="100%" />
		<br /> <br />
			
		
<c:if test="${not empty  requestScope.sendKP }">
			<br />
			<c:out value="${  requestScope.sendKP }" />
			<br />
		</c:if>
		
							
						
		
							<form action="Controller" method="get">
								<input type="hidden" name="command" value="SHOWLOGINFORMCLIENT" /> 
								
								<input	type="submit" value="Войти как клиент"  />
							</form>
							
						<form action="Controller" method="get">
								<input type="hidden" name="command" value="SHOWLOGINFORMCONTRACTOR" /> 
								
								<input	type="submit" value="Войти как сотрудник"  />
							</form>
							
							<form action="Controller" method="get">
								<input type="hidden" name="command" value="SHOWCOMMERCIALPAGE" /> 							
								<input	type="submit" value="Получить коммерческое предложение"  />
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