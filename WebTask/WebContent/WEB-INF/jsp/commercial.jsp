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
		
	
	</div>
	<form action="Controller" method="post">
<br />
				<input type="hidden" name="command" value="registration" />
				Никнайм
				<br /> <input type="text" name="name" value="" /><br />
	

 
<div id="link" onClick="hide_show();">
Показать<br />

</div>
 
<div id="div">
				<br />
				<br />
				Логин
				<br /> <input type="text" name="login" value="" /><br />
				
</div>
<br />
Пароль
				<br /> <input type="password" name="password" value="" /><br /> <br />
				<input type="submit" value="Registration" />
			</form>


<script>
function hide_show()
{
    //Получаем стиль блока с айди div (для изменения)
    var div=document.getElementById("div").style.display;
    //Получаем стиль ссылки (для изменения)
    var link=document.getElementById("link").innerHTML;
 
    //Изначально стиль display у блока равен ""
    //так как он изначально отображается
    //задаем ему стиль block
    if(div=="")div="none";
 
    //Если блок не отображается
    if(div=="none")
    {
        div="block";
        link="Скрыть";
    }
    else
    {
        div="none";
        link="Показать";
    }
    //Теперь меняем стили у ссылки
    //и блока который хотим скрыть или показать
    document.getElementById("div").style.display=div;
    document.getElementById("link").innerHTML=link;
}
</script>
<style>
#div{
    width:200px;
    height:200px;
    background:orange;
    display:none;
}
#link{
    cursor:pointer;
    background:silver;
    padding:5px;
    float:left;
}
#link:hover
{
    background:yellow;
}
</style>
</body>
</html>