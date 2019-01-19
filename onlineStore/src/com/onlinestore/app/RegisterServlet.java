package com.onlinestore.app;



import com.onlinestore.app.dao.UserDAO;
import com.onlinestore.app.dto.UserDTO;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

@WebServlet("/register")
@MultipartConfig(maxFileSize=16177215L)
public class RegisterServlet
extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        System.out.println("inside register servlet");
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmpassword");
        String userid = request.getParameter("userid");
        String email = request.getParameter("email");
        String contact = request.getParameter("contactno");
        String address = request.getParameter("address");
        System.out.println("contact is " + contact + " " + request.getParameter("contact"));
        Part filePart = request.getPart("photo");
        InputStream inputStream = null;
        if (filePart != null) {
            System.out.println(filePart.getName());
            System.out.println(filePart.getSize());
            System.out.println(filePart.getContentType());
            inputStream = filePart.getInputStream();
        }
        String path = "C:\\Users\\L\\eclipse-workspace\\onlineStore\\WebContent\\userImages\\";
        String extention = ".jpg";
        String imagepath = String.valueOf(path) + userid + extention;
        UserDTO userDTO = null;
        UserDAO userDAO = new UserDAO();
        try {
            if (password.equals(confirmPassword)) {
                userDTO = userDAO.doRegister(name, userid, password, imagepath, inputStream, email, contact, address);
            }
            if (userDTO != null) {
                HttpSession session = request.getSession(true);
                System.out.println("Session Created  " + session.getId());
                System.out.println("Session Created Time " + session.getCreationTime());
                session.setAttribute("uid", (Object)userDTO.getUserid());
                session.setAttribute("userdata", (Object)userDTO);
                session.setAttribute("imagepath", (Object)imagepath);
                FileInputStream fs = null;
                fs = new FileInputStream(imagepath);
                System.out.println("file name is " + fs);
                byte[] arr = fs.readAllBytes();
                fs.close();
                System.out.println("arr is " + arr);
                response.sendRedirect("index.jsp");
                out = response.getWriter();
                out.print((Object)userDAO);
                out.close();
                System.out.println("After response.sendredirect(index.jsp)");
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