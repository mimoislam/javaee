<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:if test="${! (empty username )&& ! (empty password )}"><p> <c:out value="${username}  ${password} }"></c:out></p></c:if>
<form method="post" action="register">
<label>Username</label>
<input type="text"	name="username" id="username" required="required">
<br>
<label>Email</label>
<input type="email"	name="email" id="email" required="required">
<br>
<label>Password</label>

<input type="password"	name="password" id="password" required="required">
<br>
<label>Confirme Password</label>

<input type="password"	name="validepassword" id="validepassword" required="required">
<br>

<input type="submit">

</form>

</body>
</html>