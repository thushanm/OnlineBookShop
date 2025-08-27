<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Create Bill</title>
    <style>
        body { font-family: Arial, sans-serif; background-color: #f4f4f9; margin: 0; padding: 20px; }
        .container { max-width: 600px; margin: auto; background: #fff; padding: 30px; border-radius: 8px; box-shadow: 0 4px 8px rgba(0,0,0,0.1); }
        h1 { text-align: center; }
        .form-group { margin-bottom: 20px; }
        label { display: block; margin-bottom: 8px; }
        input, select { width: 100%; padding: 10px; border: 1px solid #ddd; border-radius: 4px; }
        input[type="submit"] { background-color: #28a745; color: white; cursor: pointer; }
    </style>
</head>
<body>
<div class="container">
    <h1>Create New Bill</h1>
    <form action="/bills/create" method="post">
        <div class="form-group">
            <label for="customerId">Customer:</label>
            <select id="customerId" name="customerId">
                <c:forEach var="customer" items="${customers}">
                    <option value="${customer.id}">${customer.name}</option>
                </c:forEach>
            </select>
        </div>
        <div class="form-group">
            <label for="unitsConsumed">Units Consumed:</label>
            <input type="text" id="unitsConsumed" name="unitsConsumed"/>
        </div>
        <div>
            <input type="submit" value="Create Bill"/>
        </div>
    </form>
</div>
</body>
</html>
