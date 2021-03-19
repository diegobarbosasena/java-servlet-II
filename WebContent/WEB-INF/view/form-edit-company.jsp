<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<c:url value="/entry" var="urlEntryServlet" />

<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<title>Create New Company</title>
</head>
<body>

	<form action="${urlEntryServlet}" method="post">

		Name: <input type="text" name="companyName" value="${company.name }" />

		Opening Date : <input type="text" name="openingDate"
			value="<fmt:formatDate value="${ company.openingDate }" pattern="dd/MM/yyyy" />" />

		<input type="hidden" name="id" value="${ company.id }"> 
		<input type="hidden" name="controller" value="UpdateCompany"> 
		
		<input type="submit" value="Update" />

	</form>

</body>
</html>
