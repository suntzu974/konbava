<!DOCTYPE html>  
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<html lang="en">  
<head>  
  <title>Bootstrap Case</title>  
  <meta charset="utf-8">  
  <meta name="viewport" content="width=device-width, initial-scale=1">  
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">  
    
</head>  
<body>  
  
<nav class="navbar navbar-inverse">  
  <div class="container-fluid">  
    <div class="navbar-header">  
      <a class="navbar-brand" href="#">Recouvrement</a>  
    </div>  
    <ul class="nav navbar-nav">  
      <li class="active"><a href="${contextPath}/">Home</a></li>  
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Actions<span class="caret"></span></a>  
        <ul class="dropdown-menu">  
          <li><a href="${contextPath}/users">Users</a></li>  
          <li><a href="${contextPath}/customers">List All Customers</a></li>  
          <li><a href="#">Page 1-3</a></li>  
        </ul>  
      </li>  
      <li><a href="#">Page 2</a></li>  
      <li><a href="#">Page 3</a></li>  
    </ul>  
    <ul class="nav navbar-nav navbar-right">  
      <li><a href="#"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>  
      <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>  
    </ul>  
  </div>  
</nav>  
    
<div class="container">  
  <h3>Recouvrement de créances clients</h3>  
  <p> The .navbar-right class is used to right-align navigation bar buttons.</p>  
</div>  
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>  
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>  
</body>  
</html>