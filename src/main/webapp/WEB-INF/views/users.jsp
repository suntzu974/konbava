<%@ page language="java" contentType="text/html; charset=UTF-8" 
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>	
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <title>Csutomers</title>
    </head>
    <body>
        <div class="container">
            <h1>Customers Form</h1>
            <div class="card">
                <div class="card-body">
                    <form method="post" action="customers">
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
        <ul>
            <c:forEach var="customer" items="${ customers }">
                <li>
                    <c:out value="${ customer.name }" /> 
                    <c:out value="${ customer.address }" />
                    <c:out value="${ customer.town }" />
                    <c:out value="${ customer.postal }" />
                </li>
            </c:forEach>
        </ul>    
    </body>
</html>
