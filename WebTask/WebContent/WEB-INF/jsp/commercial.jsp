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
	<img
					src="${pageContext.request. contextPath}/resources/images/image4.png"
					width="100%" />
	<div id="fon">
		<br />
		<div id="center"><div id="center4">
		Рассчитайте стоимость опрессовки систем отопления для своего объекта в онлайн-режиме.
		Заполните обязательные поля и через минуту получите коммерческое предложение на e-mail.<br /></div>
		<div id="center2">
		<div id="center3">
	<form action="Controller" method="get">
				<input type="hidden" name="command" value="TAKEKP" /> 
				Имя:     <input type="text" name="name_user" value="" /><br />				
				Email:   <input type="text" name="email" value="" /><br />	
				Адрес:   <input type="text" name="address" value="" /><br />			
				Телефон: <input type="text" name="phone" value="" /><br />				
				Выберите город:<br>
<input id="rb1" type="radio" name="city" value="Минск" onChange="hide()" checked >Минск
<input id="rb2" type="radio" name="city" value="Другой населенный пункт" onChange="show()">Другой населенный пункт
<br>
    <div id="infoKm" style="display:none">
       Введите расстояние от Минска в (км.): <input type="text" name="km" value="" /><br />	</div>
<br>
		
	<strong>Выберите, какие данные Вам удобно предоставить?<br /><br></strong>
<input id="myRadioButton1" type="radio" name="data" value="s" onChange="show1()" >Площадь помещений<br />	
<input id="myRadioButton2" type="radio" name="data" value="dl" onChange="show2()">Длина и сечение труб<br />	
<input id="myRadioButton3" type="radio" name="data" value="rr" onChange="show3()">Количество ребер радиаторов<br />	

<br>
    <div id="info1" style="display:none">
     	Введите площадь помещений : <input type="text" name="area" value="" /><br />	</div>
     	 <div id="info2" style="display:none">
     	 Укажите длину труб в м.п.<br>
     	Диаметр труб от 10 до 25 мм : <input type="text" name="trub10" value="" /><br />	
     	Диаметр труб от 25 до 100 мм : <input type="text" name="trub25" value="" /><br />	</div>
     	 <div id="info3" style="display:none">
     	Введите количество ребер радиаторов : <input type="text" name="reber_radiatorov" value="" /><br />	</div>
					
				<br>
				<input type="submit" value="Получить коммерческое предложение!" />
			</form></div>
				</div>
			</div><br />
		</div>	
	

<script>
    function show1() {
    document.getElementById('info1').style.display='block';
    document.getElementById('info2').style.display='none';
    document.getElementById('info3').style.display='none';
    }
    function  show2() {
        document.getElementById('info2').style.display='block';
        document.getElementById('info1').style.display='none';
        document.getElementById('info3').style.display='none';
    }
    function  show3() {
        document.getElementById('info3').style.display='block';
        document.getElementById('info1').style.display='none';
        document.getElementById('info2').style.display='none';
    }

    function show() {
    document.getElementById('infoKm').style.display='block';
    }
    function hide() {
        document.getElementById('infoKm').style.display='none';
    }
</script>

	
</body>
</html>