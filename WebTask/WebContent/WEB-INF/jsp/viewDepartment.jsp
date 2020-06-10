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
<body>
<c:if test="${not empty  department.services}">
								<img
									src="${pageContext.request. contextPath}/ImageController?command=GetImage&index=${department.services}"
									width="100%" />
							</c:if>		
		<div id="fon">
		
		
	<div id="department"> 
						
					
							<br />	
							 <strong>Отдел: </strong>   <c:out value="${department.department}" /><br />
<div id="department2"> 
							    <c:out value="${department.department_descr}" /><br />
							
		<br />
			</div>
			</div>
		</div>
		

</body>
</html>