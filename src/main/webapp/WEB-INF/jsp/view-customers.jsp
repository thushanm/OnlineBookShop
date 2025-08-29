<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Manage Customers</title>
    <style>
        body { font-family: Arial, sans-serif; background-color: #f4f4f9; margin: 0; padding: 20px; }
        .container { max-width: 1000px; margin: auto; background: #fff; padding: 30px; border-radius: 8px; box-shadow: 0 4px 8px rgba(0,0,0,0.1); }
        h1 { color: #333; text-align: center; }
        .add-button { display: inline-block; margin-bottom: 20px; padding: 10px 20px; background-color: #28a745; color: white; text-decoration: none; border-radius: 5px; }
        .customer-table { width: 100%; border-collapse: collapse; }
        .customer-table th, .customer-table td { border: 1px solid #ddd; padding: 12px; text-align: left; }
        .action-links a { margin-right: 10px; }
        .home-link { display: inline-block; margin-top: 20px; padding: 10px 20px; background-color: #6c757d; color: white; text-decoration: none; border-radius: 5px; }
        .error-message { color: #d9534f; background-color: #f2dede; border: 1px solid #ebccd1; padding: 15px; border-radius: 4px; margin-bottom: 20px; }
    </style>
</head>
<body>
<div class="container">
    <h1>Customer Management</h1>
    <c:if test="${not empty errorMessage}">
        <p class="error-message">${errorMessage}</p>
    </c:if>
    <a href="/customers/add" class="add-button">Add New Customer</a>
    <table class="customer-table">
        <thead>
        <tr>
            <th>Customer ID</th>
            <th>Account Number</th>
            <th>Name</th>
            <th>Address</th>
            <th>Telephone</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="customer" items="${customers}">
            <tr>
                <td>${customer.id}</td>
                <td>${customer.accountNumber}</td>
                <td>${customer.name}</td>
                <td>${customer.address}</td>
                <td>${customer.telephone}</td>
                <td class="action-links">
                    <a href="/customers/edit/${customer.id}">Edit</a>
                    <a href="/customers/delete/${customer.id}" class="delete">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <a href="/home" class="home-link">Back to Home</a>
</div>
</body>
</html>
