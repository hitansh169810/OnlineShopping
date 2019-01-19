
package com.onlinestore.app.dto;

import com.onlinestore.app.dto.CommonGenericDTO;
import java.util.ArrayList;

public class CacheDTO {
    ArrayList<CommonGenericDTO> data;

    public ArrayList<CommonGenericDTO> getData() {
        return this.data;
    }

    public void setData(ArrayList<CommonGenericDTO> data) {
        this.data = data;
    }
}