/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.UserDAO;
import java.sql.SQLException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Khanh
 */
@ManagedBean
@RequestScoped

public class UserManagedBean {

    private String username, password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserManagedBean(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public UserManagedBean() {
    }

    public String login() throws SQLException {
        UserDAO udao = new UserDAO();
//        if (udao.check(username, password)) {
        if(username!=""){
//            return "index";
//            FacesContext fc = FacesContext.getCurrentInstance();
//            fc.addMessage(null, new FacesMessage("Login success!"));
            return "index";
        } else {
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, new FacesMessage("Username of password invalid!"));
            return null;
        }
    }
}
