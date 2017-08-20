<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/view-taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>Albo manutentori</title>
</head>
<body>

<div class="container">
  <h2 align="center">L'albo manutentori è composto da ${dipendentiSize} dipendenti</h2>
  <br><br>
              
  <table class="table table-hover">
    <thead>
      <tr>
        <th>CID</th>
        <th>Cognome</th>
        <th>Nome</th>
        <th>Impianto</th>
        <th>Informazioni</th>
        
      </tr>
    </thead>
    <tbody>
     <tbody>
				<c:forEach items="${dipendenti}" var="dipendente">
				
					<tr>
						
					    <td> <c:out	value="${dipendente.cid}" /> </td>
						<td> <c:out	value="${dipendente.cognome}" /> </td>
						<td> <c:out	value="${dipendente.nome}" /> </td>
						<td> <c:out	value="${dipendente.impianto}" /> </td>
						
						
						<td> <a href="<spring:url value="/dipendenti/${dipendente.id}" />" class="btn btn-primary btn-md">
          <span class="glyphicon glyphicon-book"></span> Dettagli
        </a> </td>
        
                       
					
						
					
						
					</tr>
				</c:forEach>
		</tbody>
  </table>
</div>

 


</body>











<!--  	<div class="container">
	<br>
		<h2> Lista dei dipendenti attualmente presenti nell'albo manutentori: </h2>
		<br><br>
		
		<c:forEach items="${dipendenti}" var="dipendente">		
		<a href="<spring:url value="/dipendenti/${dipendente.id}" />"> 
		<c:out	value="${dipendente.nome}" />
	    <c:out	value="${dipendente.cognome}" />
	    <c:out	value="${dipendente.cid}" />
	    <br><br>
		</a>
	    </c:forEach>
	    
	    
			
		
	</div>
	-->


</html>