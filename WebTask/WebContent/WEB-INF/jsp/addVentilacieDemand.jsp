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
<div id="addDemand">
<div id="addDemand2">
			<form action="ImageController" method="post"
				enctype="multipart/form-data">
					<input type="hidden" name="department" value="${requestScope.department }" /> 
					<p>Описание:<br /> 
  					 <textarea name="describtion" cols="40" rows="5"></textarea></p>			
					 Адрес:<br /> 
					  <textarea name="address" cols="40" rows="2"></textarea><br /> <br /> 
					 Прикрепить фотографию:<br />  
					 <input type="file" name="file" id="file" /> <br /><br />
			     <input
					type="submit" value="      Зарегистрировать заявку       " name="upload" id="upload" />
			</form>
			
			<br />
			
		</div>
		
		</div>	</div>

		

</body>
</html>