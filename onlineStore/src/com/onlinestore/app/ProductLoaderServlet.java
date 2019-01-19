/*
 * Decompiled with CFR 0_132.
 * 
 * Could not load the following classes:
 *  com.google.gson.Gson
 *  com.onlinestore.app.dto.ProductDTO
 *  com.onlinestore.app.dto.ProductListDTO
 *  com.onlinestore.utils.ProductLoader
 *  javax.servlet.ServletException
 *  javax.servlet.annotation.WebServlet
 *  javax.servlet.http.HttpServlet
 *  javax.servlet.http.HttpServletRequest
 *  javax.servlet.http.HttpServletResponse
 */
package com.onlinestore.app;

import com.google.gson.Gson;
import com.onlinestore.app.dto.ProductDTO;
import com.onlinestore.app.dto.ProductListDTO;
import com.onlinestore.utils.ProductLoader;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value={"/products"})
public class ProductLoaderServlet
extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList productList = ProductLoader.getProducts();
        Gson gson = new Gson();
        PrintWriter out = response.getWriter();
        System.out.println("ProductList is " + productList);
        System.out.println("ProductList is " + ((ProductDTO)productList.get(0)).getPname());
        System.out.println("**************PRODUCTS CACHE START ");
        String products = gson.toJson((Object)productList);
        System.out.println("JSON is " + products);
        ProductListDTO productListDTO = new ProductListDTO();
        productListDTO.setData(productList);
        products = gson.toJson((Object)productListDTO);
        System.out.println("Now JSON is " + products);
        System.out.println("**************PRODUCTS CACHE END ");
        out.println(products);
        out.close();
    }
}
