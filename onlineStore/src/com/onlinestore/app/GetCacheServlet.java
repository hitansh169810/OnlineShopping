package com.onlinestore.app;



import com.google.gson.Gson;

import com.onlinestore.app.dto.CacheDTO;
import com.onlinestore.utils.CacheLoader;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;

@WebServlet("/cache")
public class GetCacheServlet
extends HttpServlet {
    private static final long serialVersionUID = 1L;
    Logger logger = Logger.getLogger(GetCacheServlet.class);

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String key = request.getParameter("key");
        System.out.println("key inside GetCacheServlet is " + key);
        ArrayList cacheList = CacheLoader.getCache((String)"CATEGORIES");
        Gson gson = new Gson();
        System.out.println("*********** COMMON PARA CACHE START");
        String json = gson.toJson((Object)cacheList);
        System.out.println("JSON is " + json);
        this.logger.debug((Object)("JSON is " + json));
        CacheDTO cacheDTO = new CacheDTO();
        cacheDTO.setData(cacheList);
        json = gson.toJson((Object)cacheDTO);
        System.out.println("Now JSON Again " + json);
        this.logger.debug((Object)("Now JSON is " + json));
        response.setContentType("application/json");
        System.out.println("CacheList is " + cacheList);
        System.out.println("CacheDTO is " + (Object)cacheDTO);
        System.out.println("**********##################***************");
        String path = this.getServletContext().getContextPath();
        System.out.println("path is " + path);
        System.out.println("**********###############***********");
        System.out.println("************** COMMON PARA CACHE END ");
        PrintWriter out = response.getWriter();
        out.println(json);
        out.close();
    }
}