<%-- 
    Document   : registration
    Created on : 1-ott-2018, 18.25.05
    Author     : nicola
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Iscriviti a KlynApp | KlynApp</title>
    </head>
    <body>
        <form action="registrazione" method="post">
            <table style="margin-left:auto; margin-right:auto;margin-top:12%;">
                <tr>
                    <td>Nome: </td>
                    <td><input type="text" name="name" value=""></td>
                </tr>
                <tr>
                    <td>Cognome: </td>
                    <td><input type="text" name="surname" value=""></td>
                </tr>
                <tr>
                    <td>Data di nascita: </td>
                    <td><input type="text" name="dateBirth" value=""></td>
                </tr>
                <tr>
                    <td>Maschio <input type="radio" name="gender" value="m"></td>
                    <td>Femmina <input type="radio" name="gender" value="f"></td>
                </tr>
                <tr>
                    <td>Numero di telefono: </td>
                    <td><input type="tel" name="numberPhone" value=""></td>
                </tr>
                <tr>
                    <td>E-mail: </td>
                    <td><input type="email" name="email" value=""></td>
                </tr>
                <tr>
                    <td>Carta di accredito: </td>
                    <td><input type="text" name="creditCard" value=""></td>
                </tr>
                <tr>
                    <td>Occupazione: </td>
                    <td><input type="text" name="job" value=""></td>
                </tr>
                <tr>
                    <td>Luogo di interesse: </td>
                    <td><input type="text" name="placeInterest" value=""></td>
                </tr>
                <tr>
                    <td>Ruolo: </td>
                    <td>
                        <select name="role">
                            <option value="p">Pulitore</option>
                            <option value="c">Cliente</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Password: </td>
                    <td><input type="password" name="password" value=""></td>
                </tr>
                <tr>
                    <td>Ripeti password: </td>
                    <td><input type="password" name="Ripassword" value=""></td>
                </tr>
                <tr>
                    <td>
                        <input type="submit" name="send" value="Invia">
                        <input type="reset" name="reset" value="Annulla">
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>
