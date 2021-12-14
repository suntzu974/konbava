<%@ page language="java" contentType="text/html; charset=UTF-8" 
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>	
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Test</title>
</head>
<body>
    <form method="post" action="users">
        <p>
            <label for="nom">Name : </label>
            <input type="text" name="name" id="name" />
        </p>
        
        <input type="submit" />
    </form>
    
    <ul>
        <c:forEach var="user" items="${ users }">
            <li><c:out value="${ user.name }" /> </li>
        </c:forEach>
    </ul>    
</body>
</html>
