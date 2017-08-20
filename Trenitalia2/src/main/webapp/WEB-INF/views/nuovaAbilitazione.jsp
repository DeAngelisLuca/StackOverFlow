<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/view-taglib.jsp"%>

<%@ page
	import="it.uniroma3.service.*, java.util.List, it.uniroma3.model.*"%>
<!DOCTYPE html>
<html>
<head>
<title>Nuova Abilitazione</title>
</head>
<body>

	<div class="container">
		<form:form commandName="abilitazione" method="post" cssClass="form-horizontal" enctype="multipart/form-data">

			<c:if test="${param.success eq true }">
				<div class="alert alert-success">Abilitazione inserita con successo!</div>
			</c:if>
			<c:if test="${param.success eq false }">
				<div class="alert alert-danger">Una abilitazione con questo nome è già inserita per questo dipendente!</div>
			</c:if>

			<div class="form-group" >
				<label for="nomeAbilitazione" class="col-sm-2 control-label" > 	Nome Abilitazione: </label>
				<div class="col-sm-10">
					<form:input path="nomeAbilitazione" cssClass="form-control" />
					<form:errors path="nomeAbilitazione" />
				</div>
			</div>

			<div class="form-group">
				<label for="info" class="col-sm-2 control-label">
					Stato: </label>
				<div class="col-sm-10">
					<form:input path="info" cssClass="form-control" />
					<form:errors path="info" />
				</div>
			</div>
			
			<div class="form-group">
				<label for="linkAllegato" class="col-sm-2 control-label">
					Link Allegato: </label>
				<div class="col-sm-10">
					<form:input path="linkAllegato" cssClass="form-control" />
					<form:errors path="linkAllegato" />
				</div>
			</div>
			
			<div class="form-group">
				<label for="giornoConseguimento" class="col-sm-2 control-label">
					Giorno Conseguimento: </label>
				<div class="col-sm-10">
					<form:input  path="giornoConseguimento" cssClass="form-control" />
					<form:errors path="giornoConseguimento" />
				</div>
			</div>
			
			<div class="form-group">
				<label for="meseConseguimento" class="col-sm-2 control-label">
					Mese Conseguimento: </label>
				<div class="col-sm-10">
					<form:input  path="meseConseguimento" cssClass="form-control" />
					<form:errors path="meseConseguimento" />
				</div>
			</div>
			
			<div class="form-group">
				<label for="annoConseguimento" class="col-sm-2 control-label">
					Anno Conseguimento: </label>
				<div class="col-sm-10">
					<form:input  path="annoConseguimento" cssClass="form-control" />
					<form:errors path="annoConseguimento" />
				</div>
			</div>
			
			<div class="form-group">
				<label for="giornoScadenza" class="col-sm-2 control-label">
					Giorno Scadenza: </label>
				<div class="col-sm-10">
					<form:input  path="giornoScadenza" cssClass="form-control" />
					<form:errors path="giornoScadenza" />
				</div>
			</div>
			
			<div class="form-group">
				<label for="meseScadenza" class="col-sm-2 control-label">
					Mese Scadenza: </label>
				<div class="col-sm-10">
					<form:input  path="meseScadenza" cssClass="form-control" />
					<form:errors path="meseScadenza" />
				</div>
			</div>
			
			<div class="form-group">
				<label for="annoScadenza" class="col-sm-2 control-label">
					Anno Scadenza: </label>
				<div class="col-sm-10">
					<form:input  path="annoScadenza" cssClass="form-control" />
					<form:errors path="annoScadenza" />
				</div>
			</div>
			
			

			<div class="form-group">
				<div class="col-sm-2"> 
					<input type="submit" value="Salva" class="btn btn-lg btn-primary" />
				</div>
			</div>
		</form:form>
	</div>
</body>
</html>