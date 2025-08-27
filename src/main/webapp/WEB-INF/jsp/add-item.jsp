<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Add Item</title>
    <style>
        body { font-family: Arial, sans-serif; background-color: #f4f4f9; margin: 0; padding: 20px; }
        .container { max-width: 600px; margin: auto; background: #fff; padding: 30px; border-radius: 8px; box-shadow: 0 4px 8px rgba(0,0,0,0.1); }
        h1 { text-align: center; }
        .form-group { margin-bottom: 20px; }
        label { display: block; margin-bottom: 8px; }
        input[type="text"] { width: 100%; padding: 10px; border: 1px solid #ddd; border-radius: 4px; }
        input[type="submit"] { width: 100%; padding: 12px; background-color: #28a745; color: white; border: none; border-radius: 4px; cursor: pointer; }
    </style>
</head>
<body>
<div class="container">
    <h1>Add New Item</h1>
    <form action="/items/add" method="post">
        <div class="form-group">
            <label for="name">Name:</label>
            <input type="text" id="name" name="name"/>
        </div>
        <div class="form-group">
            <label for="price">Price:</label>
            <input type="text" id="price" name="price"/>
        </div>
        <div>
            <input type="submit" value="Save"/>
        </div>
    </form>
</div>
</body>
</html>
