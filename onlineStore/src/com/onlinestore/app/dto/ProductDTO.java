
package com.onlinestore.app.dto;

public class ProductDTO {
    String pname;
    String pid;
    String pdescr;
    String pquantity;
    String pcategory;
    String pprice;
    String pimage;

    public String getPname() {
        return this.pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPid() {
        return this.pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getPdescr() {
        return this.pdescr;
    }

    public void setPdescr(String pdescr) {
        this.pdescr = pdescr;
    }

    public String getPquantity() {
        return this.pquantity;
    }

    public void setPquantity(String pquantity) {
        this.pquantity = pquantity;
    }

    public String getPcategory() {
        return this.pcategory;
    }

    public void setPcategory(String pcategory) {
        this.pcategory = pcategory;
    }

    public String getPprice() {
        return this.pprice;
    }

    public void setPprice(String pprice) {
        this.pprice = pprice;
    }

    public String getPimage() {
        return this.pimage;
    }

    public void setPimage(String pimage) {
        this.pimage = pimage;
    }
}