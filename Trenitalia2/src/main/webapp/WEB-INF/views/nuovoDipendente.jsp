<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/view-taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Nuovo dipendente</title>
</head>
<body>

<form:form commandName="dipendente" class="form-horizontal" >
             
	
		<c:if test="${param.success eq true }">
			<div class="alert alert-success">Dipendente inserito con sucesso!</div>
		</c:if>
		
		<c:if test="${param.success eq false }">
			<div class="alert alert-danger">Attenzione! il dipendente è già inserito!</div>
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
		<br><br>
		<div class="form-group">
			<div class="col-sm-offset-5 col-sm-10">
			
				<input type="submit" value="Aggiungi"
							class="btn btn-primary btn-md" />
			</div>
		</div>
	</form:form>
	
	
	




</body>
</html>
<!--  <body><center><h3 align="center">Inserisci un nuovo dipendente</h3><br><br>
	<div class="6u 12u$(xsmall)">
		<form:form commandName="dipendente" cssClass="form-horizontal">
	
		<c:if test="${param.success eq true }">
			<div class="alert alert-success"> Dipendente inserito con sucesso! </div>
		</c:if>
		<c:if test="${param.success eq false }">
			<div class="alert alert-danger"> Dipendente già inserito! </div>
		</c:if>
	
		<div class="field half">
			<label for="nome" class="col-sm-5 control-label"> Nome </label>
			<div class="col-sm-2">
				<form:input path="nome" cssClass="form-control" />
				<form:errors path="nome"/>
			</div>
		</div>
		
		<div class="field half">
			<label for="cognome" class="col-sm-3 control-label"> Cognome </label>
			<div class="col-sm-5">
				<form:input path="cognome" cssClass="form-control" />
				<form:errors path="cognome"/>
			</div>
		</div>
		
		<div class="field half">
			<label for="cid" class="col-sm-5 control-label"> Cid </label>
			<div class="col-sm-5">
				<form:input path="cid" cssClass="form-control" />
				<form:errors path="cid"/>
			</div>
		</div>
		
				<div class="field">
					<br><br>
				<div align="center" >	<input  type="submit" value="Salva" class="button" />
					</div>
				</div>
			
			

		</form:form>
	</div></center>
-->
