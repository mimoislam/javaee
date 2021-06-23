<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
           <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Page</title>
</head>
<body>
<h1 >Edit Page</h1>
<c:if test="${! (empty note )}">
<form action="edit" method="post">
<input type="hidden" name="id" id="id"  value='<c:out value="${note.getId()}  "></c:out>'>

<input name="note" id="note" required="required" value='<c:out value="${note.getNote()}  "></c:out>'>
<br>
<input type="submit">
</form>
</c:if>
<c:if test="${ (empty note )}">
This User didn't Create Ant notes
</c:if>

</body>
</html>