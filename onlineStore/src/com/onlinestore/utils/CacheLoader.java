
package com.onlinestore.utils;

import com.onlinestore.app.dto.CommonGenericDTO;
import com.onlinestore.utils.CommonConstants;
import com.onlinestore.utils.CommonDAO;
import java.io.PrintStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public final class CacheLoader
implements CommonConstants {
    private static HashMap<String, ArrayList<CommonGenericDTO>> cacheMap = new HashMap();

    public static HashMap<String, ArrayList<CommonGenericDTO>> loadCache() throws ClassNotFoundException, SQLException {
        ArrayList gender = CommonDAO.getCommonGenericParameters((String)"GENDER");
        cacheMap.put("GENDER", gender);
        ArrayList city = CommonDAO.getCommonGenericParameters((String)"CITY");
        cacheMap.put("CITY", city);
        ArrayList categories = CommonDAO.getCommonGenericParameters((String)"CATEGORIES");
        cacheMap.put("CATEGORIES", categories);
        System.out.println("cacheMap created " + cacheMap);
        return cacheMap;
    }

    public static ArrayList<CommonGenericDTO> getCache(String key) {
        if (cacheMap.get(key) != null) {
            System.out.println("key inside getCache() is  : " + key);
            return cacheMap.get(key);
        }
        return null;
    }

    public static void cleanCache() {
        cacheMap = null;
        System.gc();
    }
}