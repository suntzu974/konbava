<%@ page language="java" contentType="text/html; charset=UTF-8" 
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>	
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Csutomers</title>
</head>
<body>
    <div class="container">
        <h1>Customers Form</h1>
        <div class="card">
            <div class="card-body">
                <form method="post" action="insert">
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
                    <button type="submit" class="btn btn-primary">Submit</button>
                </form>
            </div>
        </div>
    </div>
    
</body>
</html>
