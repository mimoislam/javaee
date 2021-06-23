<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>login</title>
</head>
<body>

<c:if test="${! (empty error )}"><p> <c:out value="${error}  "></c:out></p></c:if>
<form method="post" action="login">
<label>Username</label>
<input type="text"	name="username" id="username" required="required">
<br>
<label>Password</label>

<input type="password"	name="password" id="password" required="required">

<br>

<input type="submit">

</form>

</body>
</html>