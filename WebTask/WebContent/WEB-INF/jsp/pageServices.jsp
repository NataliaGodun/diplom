<%@ page language="java" contentType="text/html; charset=utf-8"
	 pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>ELibrary</title>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/styleNew.css"/>" />
</head>
<body>
	<fmt:setBundle basename="resources.pagecontent" scope="session" />

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
		<br /> <br />
		<div id="exit">
			<form action="Controller" method="get">
				<input type="hidden" name="command" value="exit" /> <br /> <input
					type="submit" value="Выход" />
			</form>
		</div>






		<div id="inline">
			<div id="content">
				

				

			</div>

			<div id="enterReg">
				<form action="Controller" method="post">
					<input type="hidden" name="command" value="authorization" />
					<fmt:message key="label.login" />
					<br /> <input type="text" name="login" value="" /><br />
					<fmt:message key="label.password" />
					<br /> <input type="password" name="password" value="" /><br />
					<input type="submit" value=<fmt:message key="label.signIn" /> /> <br />

					<c:if test="${not empty  requestScope.message }">
						<c:out value="${  requestScope.message}" />
					</c:if>
				</form>

				<br />

				<form action="Controller" method="get">
					<input type="hidden" name="command" value="SHOWREGISTRATIONFORM" />
					<input type="submit" value="Зарегистрироваться" />
				</form>
				<form action="Controller" method="get">
					<input type="hidden" name="command" value="SHOWLOGINFORMCLIENT" />
					<input type="submit" value="Войти как заказчик" />
				</form>
				<form action="Controller" method="get">
					<input type="hidden" name="command" value="SHOWLOGINFORMCONTRACTOR" />
					<input type="submit" value="Войти как исполнитель" />
				</form>
				<form action="Controller" method="get">
					<input type="hidden" name="command" value="SHOWCOMMERCIALPAGE" />
					<input type="submit" value="Компред" />
				</form>
			</div>
			<br /> <br />

		
		</div>

		

	</div>
</body>
</html>