<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.util.List,br.com.diego.manager.model.Company"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<c:url value="/entry" var="urlEntryServlet" />

<!DOCTYPE html>
<html lang=pt-br>
<head>
	<meta charset="UTF-8">
	<title>Java Standard Tag Library</title>
</head>
<body>

	<c:if test="${ not empty company }">
		<h2>${ company } company successfully registered</h2>
	</c:if>

	<h2>Companies</h2>

	<ul>
		<c:forEach items="${companies }" var="company">
		
			<li>
				${company.name } <fmt:formatDate value="${ company.openingDate }" pattern="dd/MM/yyyy" /> 
				
				<a href="${urlEntryServlet }?controller=ShowCompany&id=${company.id }">edit</a> 
				<a href="${urlEntryServlet }?controller=RemoveCompany&id=${company.id }">remove</a>
			</li>
		
		</c:forEach>
	</ul>

</body>
</html>
