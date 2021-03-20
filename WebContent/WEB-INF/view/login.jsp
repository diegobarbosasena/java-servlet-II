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

		Login: <input type="text" name="login" /> 
		Password: <input type="password" name="pass" /> 
		
		<input type="hidden" name="controller" value="Login"> 
		
		<input type="submit" value="Enviar" />

	</form>

</body>
</html>
