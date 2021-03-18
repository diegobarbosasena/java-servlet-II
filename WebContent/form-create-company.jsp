<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:url value="/entry" var="urlEntryServlet" />

<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<title>Create New Company</title>
</head>
<body>

	<form action="${urlEntryServlet}" method="post">

		Name: <input type="text" name="companyName" /> 
		Opening Date : <input type="text" name="openingDate" /> 
		
		<input type="hidden" name="controller" value="newCompany"> 
		
		<input type="submit" value="Enviar" />

	</form>

</body>
</html>
