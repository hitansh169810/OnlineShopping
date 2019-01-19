package com.onlinestore.app;



import com.onlinestore.app.dao.ProductDAO;
import com.onlinestore.app.dto.ProductDTO;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

@WebServlet("/product")
@MultipartConfig(maxFileSize=16177215L)
public class GetProductServlet
extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        InputStream inputStream = null;
        PrintWriter out = response.getWriter();
        String pname = request.getParameter("pname");
        String pid = request.getParameter("pid");
        String pdescr = request.getParameter("pdescr");
        String pquantity = request.getParameter("pquantity");
        String pcategory = request.getParameter("pcategory");
        String pprice = request.getParameter("pprice");
        Part pimage = request.getPart("pimage");
        System.out.println("Product name " + pname);
        System.out.println("Product id " + pid);
        System.out.println("product descr " + pdescr);
        System.out.println("Product price " + pprice);
        System.out.println("Product Quantity " + pquantity);
        System.out.println("Product Category " + pcategory);
        if (pimage != null) {
            System.out.println(pimage.getName());
            System.out.println(pimage.getSize());
            System.out.println(pimage.getContentType());
            inputStream = pimage.getInputStream();
        }
        String path = "C:\\Users\\L\\eclipse-workspace\\onlineStore\\WebContent\\productImages\\";
        String extention = ".jpg";
        String pImagePath = String.valueOf(path) + pid + extention;
        ProductDTO productDTO = null;
        ProductDAO productDAO = new ProductDAO();
        try {
            productDTO = productDAO.insertProduct(pname, pid, pdescr, pquantity, pcategory, pprice, pImagePath, inputStream);
            if (productDTO != null) {
                System.out.println("Session already Created  " + (Object)request.getSession());
                System.out.println("Session Created Time " + (Object)request.getSession());
                FileInputStream fs = null;
                fs = new FileInputStream(pImagePath);
                System.out.println("Product Image name is " + pid + extention);
                byte[] arr = fs.readAllBytes();
                fs.close();
                System.out.println("arr is " + arr);
                System.out.println("Before Redirecting to addProduct.jsp : Successfully Uploaded the Product ");
                response.sendRedirect("index.jsp");
                out.print((Object)productDAO);
                out.close();
                System.out.println("After redirect Redirecting to addProduct.jsp");
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        out.close();
    }
}