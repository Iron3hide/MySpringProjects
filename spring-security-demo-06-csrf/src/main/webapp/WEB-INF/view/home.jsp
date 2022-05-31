<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 


<html>

<head>
	<title>Company Home Page</title>
</head>

<body>
	<h2>Company Home Page -- Yoohoo Silly Goose - No soup</h2>
	<hr>
	
	Welcome to the company home page!
	
	<!-- Add a logout button -->
	<form:form action="${pageContext.request.contextPath}/logout"
			   method="POST">
			   
			<input type="submit" value="Logout"/>
	</form:form>		   
			 
	
</body>

</html>