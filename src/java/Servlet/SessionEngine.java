/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import business.User;
import business.WorkingSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author nicola
 */
public class SessionEngine extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = null;
        Connection connection = doDBConnection();
        String action = request.getParameter("action");
        
        User user = (User) request.getSession().getAttribute("user");
        
        if (action.equalsIgnoreCase("prenota")) {
            WorkingSession work = new WorkingSession();
            workingDate(request, work);
            //user.setWorks(work);

            insertDBWorkSession(connection, work, user);
            url = "/sessionWork.jsp";
        }
        else {
            readDBWorkSession(connection, request);
            url = "/historyPage.jsp";
        }
        
        getServletContext()
            .getRequestDispatcher(url)
            .forward(request, response);
    }
    
    private void workingDate(HttpServletRequest request, WorkingSession work) {
        String data = request.getParameter("dateWork").trim();
        String startTime = request.getParameter("startTime").trim();
        String finishTime = request.getParameter("finishTime");
        
        String dataStart = data + "T" + startTime;
        LocalDateTime dateStart = LocalDateTime.parse(dataStart);
        
        String dataFinish = data + "T" + finishTime;
        LocalDateTime dateFinish = LocalDateTime.parse(dataFinish);
        
        Instant startInstant = dateStart.atZone(ZoneId.of("Europe/Rome")).toInstant();
        Instant finishInstant = dateFinish.atZone(ZoneId.of("Europe/Rome")).toInstant();
        
        work.setStartSession(Timestamp.from(startInstant));
        work.setFinishSession(Timestamp.from(finishInstant));
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
    
    private void insertDBWorkSession(Connection connection, WorkingSession work, User user) {
        String insertQuery = "insert into WORK_SESSION "
                + "(MAIL, DATE_START, DATE_FINISH, STATE)"
                + "values (?, ?, ?, ?)";
        
        try {
            PreparedStatement ps = connection.prepareStatement(insertQuery);
            
            ps.setString(1, user.getEmail());
            ps.setTimestamp(2, work.getStartSession());
            ps.setTimestamp(3, work.getFinishSession());
            ps.setBoolean(4, work.isState());
            
            ps.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    private void readDBWorkSession(Connection connection, HttpServletRequest request) {
        ResultSet result = null;
        String readQuery = "select DATE_START, DATE_FINISH " +  
                "FROM work_session where MAIL = ? and STATE = true";
        
        try {
            PreparedStatement ps = connection.prepareCall(readQuery);
            
            User user = (User) request.getSession().getAttribute("user");
            ps.setString(1, user.getEmail());
            
            result = ps.executeQuery();
            
            while (result.next()) {
                WorkingSession work = new WorkingSession();
                work.setStartSession(result.getTimestamp(1));
                work.setFinishSession(result.getTimestamp(2));
                
                user.setWorks(work);
            }
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
    }
}
