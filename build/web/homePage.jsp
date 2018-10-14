<%-- 
    Document   : homePage
    Created on : 4-ott-2018, 16.49.05
    Author     : nicola
--%>

<%@page import="java.time.Instant"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home page</title>
    </head>
    <body>
        <%= Instant.now() %>
        <c:if test="${not empty user}">
            <div style="margin-left: auto; margin-right: auto;">
                <h1> Registrazione avvenuta con successo </h1>
                <p>Nome: ${user.name}</p>
                <p>Cognome: ${user.surname}</p>
            </div>
        </c:if>
        
        <c:if test="${empty user}">
            <form action="login" method="post">
                <table style="margin-left: auto; margin-right: auto;margin-top: 20%;">
                    <tr>
                        <td>Username: </td>
                        <td><input type="text" name="username" value=""></td>
                    </tr>
                    <tr>
                        <td>Password: </td>
                        <td><input type="password" name="password" value=""></td>
                    </tr>
                    <tr>
                        <td><input type="submit" name="login" value="Invia"></td>
                        <td><input type="reset" name="reset" value="Annulla"></td>
                    </tr>
                </table>
            </form>
        </c:if>
    </body>
</html>
