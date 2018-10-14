// bisogna implementare sessione e controlli sui valori inseriti
package Servlet;

import business.User;
import java.io.IOException;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author nicola
 */
@WebServlet(name = "signUp", urlPatterns = {"/registrazione"})
public class signUp extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response); // -------  USARE PER DEBUG ----------
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        User user = createUserBean(request);
        
        // INSERIMENTO DATI UTENTE REGISTRATO
        Connection connection = doDBConnection();
        insertDBUSer(connection, user);
        
        getServletContext()
                .getRequestDispatcher("/homePage.jsp")
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
    
    private void insertDBUSer(Connection connection, User user) {
        String insertQuery = "insert into USER "
                + "(NOME, COGNOME, DATA_NASCITA, SESSO, NUMERO_TELEFONO, MAIL, OCCUPAZIONE, ZONA, RUOLO, PASSWORD)"
                + "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        try {
            PreparedStatement ps = connection.prepareStatement(insertQuery);
            ps.setString(1, user.getName());
            ps.setString(2, user.getSurname());
            ps.setString(3, user.getDate());
            ps.setString(4, user.getGender());
            ps.setString(5, user.getNumberPhone());
            ps.setString(6, user.getEmail());
            ps.setString(7, user.getJob());
            ps.setString(8, user.getPlaceInterest());
            ps.setString(9, user.getRole());
            ps.setString(10, user.getPassword());
            
            ps.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    private User createUserBean(HttpServletRequest request) {
        User user = new User();
        user.setName(request.getParameter("name"));
        user.setSurname(request.getParameter("surname"));
        user.setDate(request.getParameter("dateBirth"));
        user.setGender(request.getParameter("gender"));
        user.setNumberPhone(request.getParameter("numberPhone"));
        user.setEmail(request.getParameter("email"));
        user.setJob(request.getParameter("job"));
        user.setPlaceInterest(request.getParameter("placeInterest"));
        user.setRole(request.getParameter("role"));
        user.setPassword(request.getParameter("password"));
        
        request.setAttribute("user", user);
        
        return user;
    }
}
