<%@ page language="java" contentType="text/html; charset=UTF-8" 
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>	
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Test</title>
</head>
<body>
    <form method="post" action="/customers">
        <p>
            <label for="nom">Name : </label>
            <input type="text" name="name" id="name" />
        </p>
        <p>
            <label for="account">Account : </label>
            <input type="text" name="account" id="account" />
        </p>
        
        <input type="submit" />
    </form>
    
    <ul>
        <c:forEach var="customer" items="${ customers }">
            <li><c:out value="${ customer.name }" /> <c:out value="${ customer.account }" /></li>
        </c:forEach>
    </ul>    
</body>
</html>
