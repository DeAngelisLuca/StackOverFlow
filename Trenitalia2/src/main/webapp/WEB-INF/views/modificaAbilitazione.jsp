<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/view-taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modifica dell'abilitazione</title>
</head>
<body>
<div class="container">
		<form:form commandName="abilitazioneDaModificare" cssClass="form-horizontal">
	
		<c:if test="${param.success eq true }">
			<div class="alert alert-success"> Abilitazione Modificata! </div>
		</c:if>
	
			<div class="form-group">
			<label class="control-label col-sm-4" for="nomeAbilitazione" >Nome abilitazione</label>
			<div class="col-sm-5">
						<form:input path="nomeAbilitazione" cssClass="form-control" />
						<form:errors path="nomeAbilitazione" />
					</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-4" for="dataConseguimentoAbilitazione">Data conseguimento</label>
			<div class="col-sm-5">
						<form:input path="dataConseguimentoAbilitazione" cssClass="form-control" />
						<form:errors path="dataConseguimentoAbilitazione" />
					</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-4" for="dataScadenzaAbilitazione">Data scadenza</label>
			<div class="col-sm-5">
						<form:input path="dataScadenzaAbilitazione" cssClass="form-control" />
						<form:errors path="dataScadenzaAbilitazione" />
					</div>
		</div>
		
		<div class="form-group">
			<label class="control-label col-sm-4" for="linkAllegato">Allegato</label>
			<div class="col-sm-5">
						<form:input path="linkAllegato" cssClass="form-control" />
						<form:errors path="linkAllegato" />
					</div>
		</div>
		
		<div class="form-group">
			<label class="control-label col-sm-4" for="info">Stato</label>
			<div class="col-sm-5">
						<form:input path="info" cssClass="form-control" />
						<form:errors path="info" />
					</div>
		</div>
		
	
		
		
		
		
		<div class="form-group">
			<div class="col-sm-2">
				<input type="submit" value="Modifica" class="btn btn-lg btn-warning"  />
			</div>
		</div>
		
		</form:form>
	</div>


</body>
</html>