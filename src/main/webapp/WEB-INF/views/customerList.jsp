<%@ page language="java" contentType="text/html; charset=UTF-8" 
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>	
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<html lang="en"></html>
<head>  
    <title>Customers list</title>  
    <meta charset="utf-8">  
    <meta name="viewport" content="width=device-width, initial-scale=1">  
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">  
</head> 
<body>
    <jsp:include page="../shared/header.jsp" />  
<div class="container">
    <h2>Customers list</h2>
    <p> customers list</p>            
    <table class="table">
      <thead>
        <tr>
          <th>Name</th>
          <th>Address</th>
          <th>Postal code</th>
          <th>Town</th>
          <th>Action</th>
        </tr>
      </thead>
            <tbody>
                <c:forEach var="customer" items="${ customers }">
                    <tr>
                        <td><c:out value="${ customer.name }" /></td>         
                        <td><c:out value="${ customer.address }" /></td>         
                        <td><c:out value="${ customer.postal }" /></td>         
                        <td><c:out value="${ customer.town }" /></td>  
                        <td><a class="btn btn-primary" href="${contextPath}/edit?id=<c:out value='${customer.id}' />" role="button">Update</a></td>
                        <td><a class="btn btn-primary" href="${contextPath}/delete?id=<c:out value='${customer.id}' />" role="button">Delete</a></td>
                    </tr>
                </c:forEach>
            </tbody>
            <form action="new" method="post">
              <button type="submit" class="btn btn-success">Add</button>
            </form>
    </table>
  </div>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>  
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>  
  </body>
  </html>
  