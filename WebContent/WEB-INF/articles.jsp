<%@page pageEncoding="UTF-8" isErrorPage="true" contentType="text/html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

<%@ page import="modele.Article" %>
<!DOCTYPE html>
<html>
	<head>
  		<meta charset="UTF-8">
	</head>
	<body>
		<table border="1">
			<tr>
			<th>Id</th>
			<th>Nom</th>
			<th>Prix</th>
		</tr>
			<c:forEach items="${articles}" var="article">
				<tr>
					<td>${article.id}</td>
					<td>${article.nom}</td>
					<td>${article.prix}</td>
				</tr>
			</c:forEach>
		</table>
	</body>
</html>