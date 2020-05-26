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
	


			<form action="ImageController" method="post"
				enctype="multipart/form-data">
				Описание:<input type="text" name="describtion" value="" /><br /> 
				Адрес:<input type="text" name="address" value="" /><br /> 
			    Файл:     <input type="file" name="file" id="file" /> <br />
			     <input
					type="submit" value="Загрузить" name="upload" id="upload" />
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