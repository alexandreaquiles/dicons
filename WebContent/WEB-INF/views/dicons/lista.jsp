<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dicons</title>
</head>
<body>
	<h1>Lista de Dicons</h1>
	<c:choose>
		<c:when test="${empty dicons}">
			<h2>Não há dicons para o atendimento ${param.numeroAtendimento}</h2>
		</c:when>
		<c:otherwise>
			<table>
				<c:forEach items="${dicons}" var="dicon">
					<tr>
						<td>${dicon.numeroAtendimento}</td>
						<td>${dicon.cliente}</td>
						<td><a href="download?diretorio=${dicon.diretorio}">Download</a></td>
					</tr>
				</c:forEach>
			</table>
		</c:otherwise>
	</c:choose>

</body>
</html>