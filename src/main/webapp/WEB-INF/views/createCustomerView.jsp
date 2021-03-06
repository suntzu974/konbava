<%@ page language="java" contentType="text/html; charset=UTF-8" 
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>	
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Customers</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"> 
</head>
<body>
    <jsp:include page="../shared/header.jsp" />  
    <div class="container">
        <h1>Customers Form</h1>
        <div class="card">
            <div class="card-body">
                <form method="post" action="${contextPath}/customers/insert">
                    <div class="form-group row">
                        <label for="name" class="col-sm-2 col-form-label">Name</label>
                        <div class="col-sm-7">
                             <input type="text" class="form-control" name="name"  placeholder="Enter name" id="name">
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="address" class="col-sm-2 col-form-label">Address</label>
                        <div class="col-sm-7">
                             <input type="text" class="form-control" name="address"  placeholder="Enter Address" id="address">
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="town" class="col-sm-2 col-form-label">Town</label>
                        <div class="col-sm-7">
                             <input type="text" class="form-control" name="town"  placeholder="Enter Town" id="town">
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="postal" class="col-sm-2 col-form-label">Postal</label>
                        <div class="col-sm-7">
                             <input type="text" class="form-control" name="postal"  placeholder="Enter Postal code" id="postal">
                        </div>
                    </div>
                    <button type="submit" class="btn btn-primary">Save</button>
                </form>
            </div>
        </div>
    </div>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>  
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>  
</body>
</html>
