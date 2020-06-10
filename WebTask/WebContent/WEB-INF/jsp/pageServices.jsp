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
		
			<c:if test="${not empty  requestScope.sendKP }">
			<br />
			<c:out value="${  requestScope.sendKP }" />
			<br />
		</c:if>
			
		<div id="unit">
		<div id="unit1">

							<form action="Controller" method="get">
								<input type="hidden" name="command" value="SHOWLOGINFORMCLIENT" /> 		
								<input	type="submit" value="Войти как клиент"  />
							</form></div>
							<div id="unit2">
						<form action="Controller" method="get">
								<input type="hidden" name="command" value="SHOWLOGINFORMCONTRACTOR" /> 
								
								<input	type="submit" value="Войти как сотрудник"  />
							</form>
				
</div>
							<div id="unit3">
							<form action="Controller" method="get">
								<input type="hidden" name="command" value="SHOWCOMMERCIALPAGE" /> 							
								<input	type="submit" value="Рассчитать стоимость опрессовки"  />
							</form>
				
				</div>
			<br /><br />
			<div id="unit5">
			Мы занимаемся техническим обслуживанием зданий и обеспечиваем бесперебойную работу всех инженерных систем
			: сантехнических (отопление, водоснабжение, канализация), систем электроснабжения, вентиляции и кондиционирования.
			Выберите, что вас интересует:</div>
			
		
		<div id="unit">
		<div id="unit1">

							<form action="Controller" method="get">
							<input type="hidden" name="department" value="Вентиляция и кондиционирование" /> 
								<input type="hidden" name="command" value="SHOWELECTRO" /> 		
								<input	type="submit" value="Услуги по вентиляции"  />
							</form></div>
							<div id="unit2">
						<form action="Controller" method="get">
								<input type="hidden" name="department" value="Электроснабжение" /> 
								<input type="hidden" name="command" value="SHOWELECTRO" /> 
								
								<input	type="submit" value="Услуги по электрике"  />
							</form>
				
</div>
				
							<div id="unit3">
							<form action="Controller" method="get">
							<input type="hidden" name="department" value="Водоснабжение и канализация" />
								<input type="hidden" name="command" value="SHOWELECTRO" /> 							
								<input	type="submit" value="Услуги по сантехнике"  />
							</form>
				
</div></div>
		
</div></div>
		
</body>
</html>