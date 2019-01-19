package com.onlinestore.app;



import com.google.gson.Gson;
import com.onlinestore.app.dao.UserDAO;
import com.onlinestore.app.dto.UserDTO;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet
extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        System.out.println("inside login servlet");
        String userid = request.getParameter("userid");
        String password = request.getParameter("pwd");
        UserDAO userDAO = new UserDAO();
        try {
            UserDTO userDTO = userDAO.doLogin(userid, password);
            if (userDTO != null) {
                System.out.println("inside loginservlet before session creation");
                HttpSession session = request.getSession(true);
                System.out.println("Session Created  " + session.getId());
                System.out.println("Session Created Time " + session.getCreationTime());
                session.setAttribute("uid", (Object)userDTO.getUserid());
                session.setAttribute("userdata", (Object)userDTO);
                session.setAttribute("userdata", (Object)userDTO);
                session.setAttribute("imagepath", (Object)userDTO.getImagelink());
                System.out.println("imagepath is " + userDTO.getImagelink());
                response.sendRedirect("index.jsp");
                Gson gson = new Gson();
                String json = gson.toJson((Object)userDTO);
                System.out.println("json is " + json);
                response.setContentType("application/json");
                out = response.getWriter();
                out.println(json);
                out.close();
                response.sendRedirect("index.jsp");
            } else {
                out.println("Invalid Userid or Password....");
            }
        }
        catch (ClassNotFoundException e3) {
            response.sendRedirect("error.html");
        }
        catch (SQLException e3) {
        }
        catch (Exception e3) {
            // empty catch block
        }
        out.close();
    }
}