<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>




<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Albo Manutentori</title>
</head>
<body>




	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">Home</a>
			</div>
			<ul class="nav navbar-nav">

				<security:authorize access="! isAuthenticated()">
					<li><a href="<spring:url value="/login" />">Accedi</a></li>    <!-- Collegato al LoginController Ok bug tolti! -->
				</security:authorize>


				<security:authorize access="hasRole('ROLE_ADMIN')">
					<li><a href="<spring:url value="/users" />">Utenti(RDO)</a></li> <!-- Collegato al AmministratoreController Ok bug tolti! -->
					<li><a href="<spring:url value="/register" />">Registrazione(RDO)</a></li> <!-- Collegato a RegistrazioneController Ok bug tolti! -->
				</security:authorize>
				
				<security:authorize access="! isAuthenticated()">
					<li><a href="<spring:url value="/registrazioneVisitatore" />">Richiesta di accesso</a></li>    <!-- Collegato al LoginController Ok bug tolti! -->
				</security:authorize>



				<security:authorize access="isAuthenticated()">
					<security:authorize access="hasRole('ROLE_USER')">
						<li><a href="<spring:url value="/account" />">Operazioni</a></li>  <!-- Collegato a OperazioniController Ok bug tolti! -->
					</security:authorize>
				</security:authorize>

				<security:authorize access="hasRole('ROLE_USER')">
					<li><a href="<spring:url value="/logout" />">Logout</a></li>
				</security:authorize>

			</ul>
		</div>
	</nav>
	<h1 align="center">
	<marquee hspace="35%" behavior="alternate"> Benvenuto in AlboManutentori </marquee>
	<br><br><br>
	</h1>
	
	<h2 align="justify">AlboManutentori è la piattaforma web contenente i dettagli delle abilitazioni conseguite dai manutentori dei rotabili di Trenitalia.
    L'accesso a questo sito è riservato esclusivamente ai referenti di organo per l'accesso e la consultazione dell'albo manutentori nello svolgimento delle loro attività di verifica per mantenimento competenze.
	 Se sei un referente d'organo, puoi procedere con la registrazione compilando l'apposito modulo ed attendere che un amministratore ti abiliti all'accesso.</h2>
	 <h3 align="center">La documentazione contenuta deve essere considerata aziendale/riservata e ogni utilizzo illecito o abusivo del sito o della documentazione ivi contenuta sarà perseguibile a termini di legge</h3>
	
	
	
	


</body>
</html>