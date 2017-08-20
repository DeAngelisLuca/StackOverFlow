<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/view-taglib.jsp"%>

<!DOCTYPE html>
<html>
<head>
<title>Login</title>
</head>
<body><br><br>
<form class="form-horizontal" role="form"  action="<spring:url value="/j_spring_security_check" />" method="POST">

  <div class="form-group">
  
  <div class="alert alert-warning" align="center">
  <strong>Ricorda!</strong> L'autenticazione e' sensibile alla maiuscole e minuscole
</div>
  
    <label class="control-label col-sm-2" for="text" style="font-size: large;">Nickname</label>
    <div class="col-sm-4">
      <input type="text" class="form-control" name="j_username" id="Nickname" placeholder="Inserisci Nickname">
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-2" for="password" style="font-size: large;">Password</label>
    <div class="col-sm-4"> 
      <input type="password" class="form-control" name="j_password" id="password" placeholder="Inserisci Password">
    </div>
  </div>
  <div class="form-group"> 
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-primary">Accedi</button>
    </div>
  </div>
  

  
  
</form>

</body>








<!--  

	<div align="center" ><h3>ACCEDI</h3><br>
	
		<form class="form-signin" role="form"
			action="<spring:url value="/j_spring_security_check" />"
			method="POST">
				
				
									<div class="6u 12u$(xsmall)">
				
					<input type="text" name="j_username" class="form-control"
						placeholder="Nickname" required autofocus>
				</div><br>
				
									<div class="6u 12u$(xsmall)">
					<input type="password" name="j_password" class="form-control"
						placeholder="Password" required autofocus>
				</div>
			
			<br>
			<br>




				<div align="center" ><button class="button" type="submit">Entra</button></div>
		</form>
	</div>
</body>-->
</html>