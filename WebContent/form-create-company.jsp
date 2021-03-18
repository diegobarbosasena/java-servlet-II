<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:url value="/new-company" var="urlServletNewCompany" />

<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<title>Create New Company</title>
</head>
<body>

	<form action="${urlServletNewCompany}" method="post">

		Name: <input type="text" name="companyName" /> 
		Opening Date : <input type="text" name="openingDate" /> 
		
		<input type="submit" value="Enviar" />

	</form>

</body>
</html>