<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/view-taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Benvenuto ${user.nome}</title>
</head>
<body>
	<center> <h1>Benvenuto nella tua pagina ${user.nome}</h1>
		<br><br>
		<br><br>
		
		<div class="btn-group-vertical">
 

		<!-- RISERVATO UTENTE -->

		<security:authorize access="hasRole('ROLE_USER')">
			  <a href="dipendenti" class="btn btn-warning btn-lg"> <span class="glyphicon glyphicon-list-alt"></span> LISTA DEI DIPENDENTI</a>
		</security:authorize>

		<br><br> 
		
		<!-- RISERVATO ADMIN -->

		<security:authorize access="hasRole('ROLE_ADMIN')">
			<a href="dipendente" class="btn btn-warning btn-lg"> <span class="glyphicon glyphicon-user"></span> AGGIUNGI DIPENDENTE</a>
		</security:authorize>
		
		<br><br>


        </div>
	
 </center>
</body>
</html>

<!-- <title>Bentornato nella tua pagina ${user.nome}</title> 
</head>
<body>
 <h3 align="center">Benvenuto nella tua pagina ${user.nome}</h3>
	<div class="container">
		<br>
		<security:authorize access="hasRole('ROLE_ADMIN')">
		<div align="right">
			<a href="dipendente" class="button "> Aggiungi dipendente </a>
			<p> <img src="http://i65.tinypic.com/mvlrvp.png"></p>
			</div>
		</security:authorize>
		
		<br><br>
		
		<a href="dipendenti" class="button"> Dipendenti nell'albo manutentori </a>		
		&emsp;&emsp;<p align="left"> <img src="http://i63.tinypic.com/1zx6pl3.png"></p>
		
		</div>
	</body>-->
