<%@page pageEncoding="UTF-8" contentType="text/html"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
  <head>
    <title>Java EE</title>
    <meta charset="utf-8">
  </head>
  <body>
 	<!-- <table border="1">
 		<tbody>
			<c:forEach items="${paramValues}" var="p">
				<tr>
					<td><c:out value="${p.key}"/></td>
					<td><c:out value="${fn:join(p.value, ',')}"/></td>
				</tr>
			</c:forEach>
 		</tbody>
 	</table>-->
 	
 	<p>Liste des articles </p>
 	<br/>
 	
 	<table border="1">
 		<tr>
 			<th>idArticle</th>
 			<th>nom</th>
 			<th>coût de fabrication</th>
 		</tr>
 		<tr>
 			<td>valeur 1</td>
 			<td>valeur 2</td>
 			<td>valeur 3</td>
 		</tr>
 	</table>
  </body>
</html>