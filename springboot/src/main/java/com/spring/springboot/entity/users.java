package com.spring.springboot.entity;

import java.io.Serializable;
import java.util.Arrays;

//user的实体类
public class users implements Serializable {
    private String[] roles;
    private String avatar;
    private String name;
    private String workID;
    private String department;
    private String position;
    private String password;

    @Override
    public String toString() {
        return "users{" +
                "roles=" + Arrays.toString(roles) +
                ", avatar='" + avatar + '\'' +
                ", name='" + name + '\'' +
                ", workID='" + workID + '\'' +
                ", department='" + department + '\'' +
                ", position='" + position + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public users(String[] roles, String avatar, String name, String workID, String department, String position, String password) {
        this.roles = roles;
        this.avatar = avatar;
        this.name = name;
        this.workID = workID;
        this.department = department;
        this.position = position;
        this.password = password;
    }

    public users() {
        this.roles = new String[1];
        this.roles[0] = "";
        this.avatar = "";
        this.workID = "";
        this.department = "";
        this.position= "";
    }

    public String[] getRoles() {
        return roles;
    }

    public void setRoles(String[] roles) {
        this.roles = roles;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWorkID() {
        return workID;
    }

    public void setWorkID(String workID) {
        this.workID = workID;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
