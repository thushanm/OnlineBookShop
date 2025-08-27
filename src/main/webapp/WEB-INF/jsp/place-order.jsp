<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Place Order</title>
    <style>
        body { font-family: Arial, sans-serif; background-color: #f4f4f9; margin: 0; padding: 20px; }
        .container { max-width: 800px; margin: auto; background: #fff; padding: 30px; border-radius: 8px; box-shadow: 0 4px 8px rgba(0,0,0,0.1); }
        h1 { text-align: center; }
        .form-group { margin-bottom: 20px; }
        label { display: block; margin-bottom: 8px; }
        select, input[type="number"] { width: 100%; padding: 10px; border: 1px solid #ddd; border-radius: 4px; }
        .item-row { display: flex; align-items: center; gap: 10px; margin-bottom: 10px; }
        .item-row select { flex: 1; }
        .item-row input { width: 80px; }
        #item-container { margin-top: 10px; }
        button, input[type="submit"] { padding: 10px 20px; border-radius: 5px; border: none; cursor: pointer; }
        .add-item-btn { background-color: #007bff; color: white; }
        .submit-btn { background-color: #28a745; color: white; width: 100%; padding: 12px; }
    </style>
</head>
<body>
<div class="container">
    <h1>Place a New Order</h1>
    <form action="/orders/place" method="post">
        <div class="form-group">
            <label for="customerId">Customer:</label>
            <select id="customerId" name="customerId">
                <c:forEach var="customer" items="${customers}">
                    <option value="${customer.id}">${customer.name}</option>
                </c:forEach>
            </select>
        </div>

        <div class="form-group">
            <label>Items:</label>
            <div id="item-container">
            </div>
            <button type="button" class="add-item-btn" onclick="addItemRow()">Add Item</button>
        </div>

        <input type="submit" class="submit-btn" value="Place Order"/>
    </form>
</div>

<script>
    function addItemRow() {
        const container = document.getElementById('item-container');
        const newItemRow = document.createElement('div');
        newItemRow.className = 'item-row';

        const itemSelect = document.createElement('select');
        itemSelect.name = 'itemIds';

        <c:forEach var="item" items="${items}">
        const option = document.createElement('option');
        option.value = '${item.id}';
        option.textContent = '${item.name}';
        itemSelect.appendChild(option);
        </c:forEach>

        const quantityInput = document.createElement('input');
        quantityInput.type = 'number';
        quantityInput.name = 'quantities';
        quantityInput.min = '1';
        quantityInput.value = '1';

        newItemRow.appendChild(itemSelect);
        newItemRow.appendChild(quantityInput);
        container.appendChild(newItemRow);
    }

    // Add one item row by default
    window.onload = addItemRow;
</script>
</body>
</html>
