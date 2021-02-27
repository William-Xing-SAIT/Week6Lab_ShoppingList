<%-- 
    Document   : shoppinglist
    Created on : 26-Feb-2021, 9:48:09 AM
    Author     : 814545
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping List</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        <p>Hello, ${username} <a href="ShoppingList?action=logout">Logout</a></p>
        <h3>List</h3>
        <form action = "ShoppingList?action=add" method = "post">
            Add item: <input type="text" name="item" >
            <input type="submit" value="Add">
        </form>


        <form action = "ShoppingList?action=delete" method = "post">
            <ul>
                <c:forEach var="item" items="${items}" >
                    <input type="radio" name="radiobutton" value="${item}">
                    <label>${item}</label><br>
                </c:forEach>
            </ul>
            <c:if test="${items.size() > 0}">
                <input type="submit" value="Delete">
            </c:if>
        </form>


        ${number}

    </body>
</html>
