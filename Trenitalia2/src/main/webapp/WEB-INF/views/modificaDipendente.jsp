<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/view-taglib.jsp"%>

<!DOCTYPE html>
<html>
<head>
<title>Modifica Dipendente</title>
</head>
<body>

<div class="container">
		<form:form commandName="dipendenteDaModificare" cssClass="form-horizontal">
	
		<c:if test="${param.success eq true }">
			<div class="alert alert-success"> Dipendente Modificato! </div>
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
			<label class="control-label col-sm-4" for="cid">CID</label>
			<div class="col-sm-5">
						<form:input path="cid" cssClass="form-control" />
						<form:errors path="cid" />
					</div>
		</div>
		
		<div class="form-group">
			<label class="control-label col-sm-4" for="impianto">Impianto/Struttura</label>
			<div class="col-sm-5">
						<form:input path="impianto" cssClass="form-control" />
						<form:errors path="impianto" />
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