<%-- 
    Document   : shoppinglist
    Created on : 26-Feb-2021, 8:55:09 PM
    Author     : 814545
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping list</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        <p>Hello, ${username} <a href="ShoppingList?action=logout">Logout</a></p>
        <h3>List</h3>
        <form action = "ShoppingList?action=add" method = "post">
            Add item: <input type="text" name="item">
            <input type="submit" value="Add">
        </form>
    </body>
</html>
