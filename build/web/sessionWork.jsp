<%-- 
    Document   : sessionWork
    Created on : 12-ott-2018, 14.28.07
    Author     : nicola
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.time.Instant"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Session work</title>
    </head>
    <body>
        <form action="session" method="post">
        <div style="margin-left: auto; margin-right: auto">
            <table>
                <thead>
                    <tr>
                        <td>Crea una sessione: </td>
                        <td><input type="date" name="dateWork" value=""></td>
                    </tr>
                    <tr>
                        <td>Dalle: <input type="time" name="startTime" value=""></td>
                        <td>Alle: <input type="time" name="finishTime" value=""></td>
                    </tr>
                    <tr>
                        <td><input type="submit" name="action" value="Prenota"></td>
                        <td><input type="submit" name="action" value="Sotrico prenotazioni"></td>
                    </tr>
                </thead>
            </table>
        </div>
        </form>
    </body>
</html>
