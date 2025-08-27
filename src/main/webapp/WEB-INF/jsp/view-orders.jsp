<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>View Orders</title>
    <style>
        body { font-family: Arial, sans-serif; background-color: #f4f4f9; margin: 0; padding: 20px; }
        .container { max-width: 1000px; margin: auto; background: #fff; padding: 30px; border-radius: 8px; box-shadow: 0 4px 8px rgba(0,0,0,0.1); }
        h1 { color: #333; text-align: center; }
        .order-table { width: 100%; border-collapse: collapse; }
        .order-table th, .order-table td { border: 1px solid #ddd; padding: 12px; text-align: left; }
        .home-link { display: inline-block; margin-top: 20px; text-decoration: none; background-color: #007bff; color: white; padding: 10px 20px; border-radius: 5px; }
    </style>
</head>
<body>
<div class="container">
    <h1>All Orders</h1>
    <table class="order-table">
        <thead>
        <tr>
            <th>Order ID</th>
            <th>Customer Name</th>
            <th>Order Date</th>
            <th>Total Amount</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="order" items="${orders}">
            <tr>
                <td>${order.id}</td>
                <td>${order.customerName}</td>
                <td>${order.orderDate}</td>
                <td>${order.totalAmount}</td>
                <td>
                    <a href="/reports/order/${order.id}">Download Bill</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <a href="/home" class="home-link">Back to Home</a>
</div>
</body>
</html>
