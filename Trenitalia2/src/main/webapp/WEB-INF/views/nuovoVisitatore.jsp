<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/view-taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>Registrazione Visitatore</title>
</head>
<body>
	<form:form commandName="nuovoVisitatore" class="form-horizontal" >
             
	
		<c:if test="${param.success eq true }">
			<div class="alert alert-success">Registrazione effettuata con sucesso!</div>
		</c:if>
		
		<c:if test="${param.success eq false }">
			<div class="alert alert-danger">Attenzione! risulti essere già in attesa di approvazione</div>
		</c:if>
		
		<div class="form-group">
			<label class="control-label col-sm-4" for="nome" >Nome</label>
			<div class="col-sm-5">
						<form:input path="nome" cssClass="form-control" />
						<form:errors path="nome" />
					</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-4" for="cognome">Cognome</label>
			<div class="col-sm-5">
						<form:input path="cognome" cssClass="form-control" />
						<form:errors path="cognome" />
					</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-4" for="email">Email</label>
			<div class="col-sm-5">
						<form:input path="email" cssClass="form-control" />
						<form:errors path="email" />
					</div>
		</div>
		
		<div class="form-group">
			<label class="control-label col-sm-4" for="password">Password</label>
			<div class="col-sm-5">
						<form:input path="password" cssClass="form-control" />
						<form:errors path="password" />
					</div>
		</div>
		
		<div class="form-group" >
			<label class="control-label col-sm-4" for="messaggioNote" >Se necessario utilizza questo campo per lasciare un messaggio all'amministratore</label>
			<div class="col-sm-5" >
						<form:input path="messaggioNote" cssClass="form-control" />
						<form:errors path="messaggioNote" />
					</div>
		</div>
		
		<br><br>
		<div class="form-group">
			<div class="col-sm-offset-5 col-sm-10">
			
				<input type="submit" value="Registrami"
							class="btn btn-primary btn-md" />
			</div>
		</div>
	</form:form>
	

</body>
</html>