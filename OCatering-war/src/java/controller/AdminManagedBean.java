/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import MySsbean.AdminFacadeLocal;
import dao.UserDAO;
import java.sql.SQLException;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author K
 */
@ManagedBean(name = "adminManagedBean1")
@RequestScoped
public class AdminManagedBean {
    @EJB
    private AdminFacadeLocal adminFacade;

    public String admin_us,admin_email,password;
    public boolean status;

    public String getAdmin_us() {
        return admin_us;
    }

    public void setAdmin_us(String admin_us) {
        this.admin_us = admin_us;
    }

    public String getAdmin_email() {
        return admin_email;
    }

    public void setAdmin_email(String admin_email) {
        this.admin_email = admin_email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    /**
     * Creates a new instance of AdminManagedBean
     */
    public AdminManagedBean() {
    }
    
    public String login() throws SQLException {
        UserDAO udao = new UserDAO();
//        if (udao.check(username, password)) {
        if(admin_us!=""){
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
