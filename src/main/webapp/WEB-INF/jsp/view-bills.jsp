<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>View Bills</title>
    <style>
        body { font-family: Arial, sans-serif; background-color: #f4f4f9; margin: 0; padding: 20px; }
        .container { max-width: 1000px; margin: auto; background: #fff; padding: 30px; border-radius: 8px; box-shadow: 0 4px 8px rgba(0,0,0,0.1); }
        h1 { color: #333; text-align: center; }
        .bill-table { width: 100%; border-collapse: collapse; }
        .bill-table th, .bill-table td { border: 1px solid #ddd; padding: 12px; text-align: left; }
        .home-link { display: inline-block; margin-top: 20px; padding: 10px 20px; background-color: #6c757d; color: white; text-decoration: none; border-radius: 5px; }
    </style>
</head>
<body>
<div class="container">
    <h1>All Bills</h1>
    <table class="bill-table">
        <thead>
        <tr>
            <th>Bill ID</th>
            <th>Customer Name</th>
            <th>Account Number</th>
            <th>Units Consumed</th>
            <th>Total Amount</th>
            <th>Bill Date</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="bill" items="${bills}">
            <tr>
                <td>${bill.id}</td>
                <td>${bill.customerName}</td>
                <td>${bill.customerAccountNumber}</td>
                <td>${bill.unitsConsumed}</td>
                <td>${bill.totalAmount}</td>
                <td>${bill.billDate}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <a href="/home" class="home-link">Back to Home</a>
</div>
</body>
</html>
