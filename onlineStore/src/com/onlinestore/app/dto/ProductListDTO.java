
package com.onlinestore.app.dto;

import com.onlinestore.app.dto.ProductDTO;
import java.util.ArrayList;

public class ProductListDTO {
    ArrayList<ProductDTO> product;

    public ArrayList<ProductDTO> getData() {
        return this.product;
    }

    public void setData(ArrayList<ProductDTO> product) {
        this.product = product;
    }
}