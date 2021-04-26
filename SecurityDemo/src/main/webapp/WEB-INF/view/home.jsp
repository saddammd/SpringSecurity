<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>  
<html>
<body>
<form:form action = "http://localhost:8080/SecurityDemo/logout" method = "POST">

<input type = "submit" value = "logout">

</form:form>

<sec:authentication property="principal.username"/>  
<sec:authentication property="principal.authorities"/>    
<hr>
<h2>Hello World!</h2>
</body>
</html>
