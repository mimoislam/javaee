<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
   
<!DOCTYPE html>
<html>
<head>
<link href="assets/style.css" rel="stylesheet">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1 >Home Page</h1>
<c:if test="${! (empty sessionScope.username )}"><p> <c:out value="${sessionScope.email}  "></c:out></p></c:if>
<c:if test="${! (empty listNotes )}">

<table>
 <c:forEach items="${listNotes}" var="item" varStatus="note">
 	
 	 <thead>Notes</thead>
 	
     <tr>
     <td><c:out value="${item.getNote()}  "></c:out></td>
     <td><a href="edit?action=edit&id=<c:out value="${item.getId()}"/>">Edit</a></td>
     <td><a href="delete?action=delete&id=<c:out value="${item.getId()}"/>">Delete</a></td>
    
    </tr>
 </c:forEach>
 </table>
</c:if>
<c:if test="${ (empty listNotes )}">
This User didn't Create Ant notes
</c:if>

</body>
</html>