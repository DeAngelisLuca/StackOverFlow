<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/view-taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>





<title>Dettagli Dipendente</title>
</head>
<body>

<div class="container">
  <h2 align="center">Informazioni del dipendente ${dipendente.cid}</h2><br><br>
<ul class="list-group" align="center">

 <li class="list-group-item">Cognome ----<strong> ${dipendente.cognome}</strong></li>
 
  <li class="list-group-item">Nome ----<strong> ${dipendente.nome} </strong></li>
  
  <li class="list-group-item">CID ---- <strong> ${dipendente.cid}</strong></li>
  
  <li class="list-group-item">Ha conseguito  <strong>[ ${dipendenteNumeroAbilitazioni} ]</strong> abilitazioni in totale</li>
  

			
			
			
			
		
  
</ul>
</div>
<br><br>
<div class="container">
  <h2 align="center">Dettaglio delle abilitazioni di ${dipendente.cognome} ${dipendente.nome} </h2>
      <br><br>
  <table class="table table-hover">
    <thead>
      <tr>
        <th>Nome</th>
        <th>Stato</th>
        <th>Data conseguimento (aaaa/mm/gg)</th>
        <th>Data scadenza (aaaa/mm/gg)</th>
        <th>Certificato</th>
        
        <security:authorize access="hasRole('ROLE_ADMIN')">
        <th>Modifica</th>
        <th>Elimina</th>
        </security:authorize>
        
      </tr>
    </thead>
    <c:forEach var="abilitazione" items="${dipendente.abilitazioni}">
    <tbody>		
    			<!-- Qualora l'abilitazione fosse scaduta setto anche il suo stato-->
    			<c:if test="${abilitazione.dataScadenzaAbilitazioneTot.isBefore(abilitazione.dataLocale)}">
    			   ${abilitazione.setInfo("S")}
    				
					<tr class="danger">
						<td><c:out value="${abilitazione.nomeAbilitazione}" /></td>
						<td><c:out value="${abilitazione.info}" /></td>
						<td><c:out value="${abilitazione.dataConseguimentoAbilitazioneTot}" /></td>
						<td><c:out value="${abilitazione.dataScadenzaAbilitazioneTot}" /></td>
						<td><a href="${abilitazione.linkAllegato }">Attestato</a></td>
						
						<security:authorize access="hasRole('ROLE_ADMIN')">
						<td> 
								<a href="<spring:url value="/modificaAbilitazione/${abilitazione.id}" />" class="btn btn-success btn-med">
                            	 <span class="glyphicon glyphicon-refresh"></span> Modifica Abilitazione
                             	</a>   
                        </td>
                        
                        <td> 
								<a href="<spring:url value="/eliminaAbilitazione/${abilitazione.id}" />" class="btn btn-danger btn-med">
                            	 <span class="glyphicon glyphicon-remove"></span> Elimina Abilitazione
                             	</a>   
                        </td>
                        </security:authorize>
                        
					</tr>
					
				
					
				</c:if>	
				
					<!-- Qualora l'abilitazione fosse valida -->
    			<c:if test="${abilitazione.dataScadenzaAbilitazioneTot.isAfter(abilitazione.dataLocale.plusDays(10))}">
    			   
    				
					<tr class="success">
						<td><c:out value="${abilitazione.nomeAbilitazione}" /></td>
						<td><c:out value="${abilitazione.info}" /></td>
						<td><c:out value="${abilitazione.dataConseguimentoAbilitazioneTot}" /></td>
						<td><c:out value="${abilitazione.dataScadenzaAbilitazioneTot}" /></td>
						<td><a href="${abilitazione.linkAllegato }">Attestato</a></td>
						
						<security:authorize access="hasRole('ROLE_ADMIN')">
						<td> 
								<a href="<spring:url value="/modificaAbilitazione/${abilitazione.id}" />" class="btn btn-success btn-med">
                            	 <span class="glyphicon glyphicon-refresh"></span> Modifica Abilitazione
                             	</a>   
                        </td>
                        
                        <td> 
								<a href="<spring:url value="/eliminaAbilitazione/${abilitazione.id}" />" class="btn btn-danger btn-med">
                            	 <span class="glyphicon glyphicon-remove"></span> Elimina Abilitazione
                             	</a>   
                        </td>
                        </security:authorize>
                        
					</tr>
					
				
					
				</c:if>	
				
				<!-- Qualora l'abilitazione fosse in fase di scadenza 10gg prima-->   
    			<c:if test="${
    							 abilitazione.dataScadenzaAbilitazioneTot.minusDays(10).equals(abilitazione.dataLocale) ||
    							 abilitazione.dataScadenzaAbilitazioneTot.minusDays(9).equals(abilitazione.dataLocale) ||
    							 abilitazione.dataScadenzaAbilitazioneTot.minusDays(8).equals(abilitazione.dataLocale) ||
    							 abilitazione.dataScadenzaAbilitazioneTot.minusDays(7).equals(abilitazione.dataLocale) ||
    							 abilitazione.dataScadenzaAbilitazioneTot.minusDays(6).equals(abilitazione.dataLocale) ||
    							 abilitazione.dataScadenzaAbilitazioneTot.minusDays(5).equals(abilitazione.dataLocale) ||
    							 abilitazione.dataScadenzaAbilitazioneTot.minusDays(4).equals(abilitazione.dataLocale) ||
    							 abilitazione.dataScadenzaAbilitazioneTot.minusDays(3).equals(abilitazione.dataLocale) ||
    							 abilitazione.dataScadenzaAbilitazioneTot.minusDays(2).equals(abilitazione.dataLocale) ||
    							 abilitazione.dataScadenzaAbilitazioneTot.minusDays(1).equals(abilitazione.dataLocale) || 
    							  abilitazione.dataScadenzaAbilitazioneTot.minusDays(0).equals(abilitazione.dataLocale)
    							

    							  }">
    			   
    				
					<tr class="warning">
						<td><c:out value="${abilitazione.nomeAbilitazione}" /></td>
						<td><c:out value="${abilitazione.info}" /></td>
						<td><c:out value="${abilitazione.dataConseguimentoAbilitazioneTot}" /></td>
						<td><c:out value="${abilitazione.dataScadenzaAbilitazioneTot}" /></td>
						<td><a href="${abilitazione.linkAllegato }">Attestato</a></td>
						
						<security:authorize access="hasRole('ROLE_ADMIN')">
						<td>  
						
								<a href="<spring:url value="/modificaAbilitazione/${abilitazione.id}" />" class="btn btn-success btn-med">
                            	 <span class="glyphicon glyphicon-refresh"></span> Modifica Abilitazione
                             	</a>   
                             	
                        </td>
                        
                        <td> 
                        
								<a href="<spring:url value="/eliminaAbilitazione/${abilitazione.id}" />" class="btn btn-danger btn-med">
                            	 <span class="glyphicon glyphicon-remove"></span> Elimina Abilitazione
                             	</a>   
                             	
                        </td>
                        </security:authorize>
                        
					</tr>
					
				
					
				</c:if>	 


				</tbody>
    </c:forEach>
  </table>
</div>
<br><br>





	<security:authorize access="hasRole('ROLE_ADMIN')">
	<h2 align="center">Operazioni Riservate  <br><br><br>
	
	<a href="<spring:url value="/abilitazione/${dipendente.id}" />" class="btn btn-primary btn-med">
          <span class="glyphicon glyphicon-plus"></span> Aggiungi Abilitazione 
        </a>
           
        
        
    <a href="<spring:url value="/modifica/${dipendente.id}" />" class="btn btn-warning btn-med">
          <span class="glyphicon glyphicon-user"></span> Modifica Dipendente
        </a>   
        
     <a href="<spring:url value="/dipendenti/remove/${dipendente.id}" />" class="btn btn-danger btn-med">
          <span class="glyphicon glyphicon-remove"></span> Rimuovi Dipendente
        </a> 
        
        
        
        </h2>
	
	
	
	
			
	</security:authorize>
	
	


</body>
</html>