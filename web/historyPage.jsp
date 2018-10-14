<%-- 
    Document   : historyPage
    Created on : 12-ott-2018, 17.12.45
    Author     : nicola
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>History page</title>
    </head>
    <body>
        <table>
            <c:forEach items="${user.works}" var="history">
                <tr>
                    <td>Inizio: </td>
                    <td>${history.startSession}</td>
                    <td>Fine: </td>
                    <td>${history.finishSession}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
