<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/view-taglib.jsp"%>

<!DOCTYPE html>
<html>
<head>
<title>Lista Utenti</title>
</head>
<body>

<div class="container">
  <h2 align="center">Lista di tutti gli utenti registrati</h2>
  <br><br>
              
  <table class="table table-hover">
    <thead>
      <tr>
        <th>Username</th>
        <th>Email</th>
        <th>Elimina</th>
        <th>Modifica da implementare dopo modifica dip</th>
      </tr>
    </thead>
    <tbody>
     <tbody>
				<c:forEach items="${users}" var="user"> 
					<tr>
						<td> <c:out	value="${user.nome}" /> </td>
						<td> <c:out	value="${user.email}" /> </td>
					
						<td> <a href="<spring:url value="/users/remove/${user.id}" />" class="btn btn-danger"> Rimuovi </a></td>
					</tr>
				</c:forEach>
		</tbody>
  </table>
</div>

</body>
</html>