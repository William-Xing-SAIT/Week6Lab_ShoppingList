<%-- 
    Document   : register
    Created on : 26-Feb-2021, 4:32:48 PM
    Author     : 814545
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        <form action = "ShoppingList?action=register" method = "post">
            Username: <input type="text" name="username">
            <input type="submit" value="Register name">
        </form>
    </body>
</html>
