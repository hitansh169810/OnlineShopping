
package com.onlinestore.app.dto;

import com.onlinestore.app.dto.RightDTO;
import java.util.ArrayList;

public class UserDTO {
    String name;
    String imagelink;
    String email;
    String contact;
    String address;
    String userid;
    private String roleName;
    private ArrayList<RightDTO> rights;

    public String getUserid() {
        return this.userid;
    }

    public String getRoleName() {
        return this.roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public ArrayList<RightDTO> getRights() {
        return this.rights;
    }

    public void setRights(ArrayList<RightDTO> rights) {
        this.rights = rights;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getImagelink() {
        return this.imagelink;
    }

    public void setImagelink(String imagelink) {
        this.imagelink = imagelink;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return this.contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}