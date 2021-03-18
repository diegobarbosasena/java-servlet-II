<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<body>

	<c:if test="${ not empty company }">	
		<h2>${ company } company successfully registered</h2>
	</c:if>

	<c:if test="${ empty company }">	
		<h2>no registered company</h2>
	</c:if>

</body>
</html>

