
package com.onlinestore.utils;

import com.onlinestore.app.dto.ProductDTO;
import com.onlinestore.utils.CommonConstants;
import com.onlinestore.utils.CommonDAO;
import java.io.PrintStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public final class ProductLoader
implements CommonConstants {
    private static HashMap<String, ArrayList<ProductDTO>> cacheMap = new HashMap();

    public static HashMap<String, ArrayList<ProductDTO>> loadProducts() throws ClassNotFoundException, SQLException {
        ArrayList<ProductDTO> products = CommonDAO.getProducts();
        cacheMap.put("PRODUCTS", products);
        System.out.println("cacheMap created " + cacheMap);
        return cacheMap;
    }

    public static ArrayList<ProductDTO> getProducts() {
        System.out.println("Inside getProducts()   : ");
        return cacheMap.get("PRODUCTS");
    }
}