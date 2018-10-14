/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import business.User;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author nicola
 */
public class Login extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String url ="/homePage.jsp";
        Connection connection = doDBConnection();
        // PENSARE A MODIFICA PER CERCARE O NUMERO TELEFONO O MAIL
        ResultSet result = searchUser(request, connection);
        
        HttpSession session = request.getSession();
        
        try {
            if (result.first()) {
                url = "/sessionWork.jsp";
                User user = createUser(result);
                final Object lock = session.getId().intern();
                synchronized (lock) {
                    session.setAttribute("user", user);
                }
            }
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }

    private Connection doDBConnection() {
        Connection connection = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch(ClassNotFoundException e) {
            e.printStackTrace();
        }
        
        String dbURL = "jdbc:mysql://localhost:3306/klynapp_test?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        String username = "root";
        String password = "lol1234567";
        
        try {
            connection = DriverManager.getConnection(dbURL, username, password);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        
        return connection;
    }

    private ResultSet searchUser(HttpServletRequest request, Connection connection) {
        ResultSet result = null;
        String query = "SELECT * FROM USER WHERE MAIL = ? AND PASSWORD = ?";
        
        try {
            PreparedStatement ps = connection.prepareCall(query);
            ps.setString(1, request.getParameter("username"));
            ps.setString(2, request.getParameter("password"));
            
            result = ps.executeQuery();
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        
        return result;
    }
    
    private User createUser(ResultSet result) throws SQLException {
        // PENSARE SE CI SONO PROBLEMI SE MANCA QUALCHE VALORE...
        User user = new User();
        user.setName(result.getString("NOME"));
        user.setSurname(result.getString("COGNOME"));
        user.setDate(result.getString("DATA_NASCITA"));
        user.setGender(result.getString("SESSO"));
        user.setNumberPhone(result.getString("NUMERO_TELEFONO"));
        user.setEmail(result.getString("MAIL"));
        user.setJob(result.getString("OCCUPAZIONE"));
        user.setPlaceInterest(result.getString("ZONA"));
        user.setRole(result.getString("RUOLO"));
        user.setPassword(result.getString("password"));
        
        return user;
    }
}
