<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Home</title>
    <style>
        body { font-family: Arial, sans-serif; background-color: #f4f4f9; margin: 0; padding: 20px; text-align: center; }
        .container { max-width: 800px; margin: 40px auto; background: #fff; padding: 40px; border-radius: 8px; box-shadow: 0 4px 8px rgba(0,0,0,0.1); }
        h1 { color: #333; }
        .nav-list { list-style: none; padding: 0; margin-top: 30px; }
        .nav-list li { margin: 15px 0; }
        .nav-list a { text-decoration: none; background-color: #007bff; color: white; padding: 15px 30px; border-radius: 5px; display: block; transition: background-color 0.3s; }
        .nav-list a:hover { background-color: #0056b3; }
    </style>
</head>
<body>
<div class="container">
    <h1>Welcome to the Online Billing System</h1>
    <ul class="nav-list">
        <li><a href="/customers">Manage Customers</a></li>
        <li><a href="/items">Manage Items</a></li>
        <li><a href="/bills/create">Create Bill</a></li>
        <li><a href="/bills">View All Bills</a></li>
        <li><a href="/orders/place">Place Order</a></li>
        <li><a href="/orders">View All Orders</a></li>
        <li><a href="/help">Help</a></li>
    </ul>
</div>
</body>
</html>
