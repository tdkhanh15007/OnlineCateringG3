/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import MyEntity.Admin;
import MySsbean.AdminFacadeLocal;
import dao.AdminDAO;
import dao.MainMethod;
import java.sql.SQLException;
import java.util.List;
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

    public String admin_us, admin_email, password , pass2;
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

    public String getPass2() {
        return pass2;
    }

    public void setPass2(String pass2) {
        this.pass2 = pass2;
    }

    /**
     * Creates a new instance of AdminManagedBean
     */
    public AdminManagedBean() {
    }

    public String login() throws SQLException {
        AdminDAO udao = new AdminDAO();
        if (udao.check(admin_us, password)) {
            return "index";
        } else {
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, new FacesMessage("Username of password invalid!"));
            return null;
        }
    }

    public List<Admin> showAll() {
        try {
            return adminFacade.findAll();
        } catch (Exception e) {
            return null;
        }
    }

    public String findAdmin(String us) {
        Admin adm = adminFacade.find(us);
        setAdmin_us(adm.getAdminUs());
        setAdmin_email(adm.getAdminEmail());
        return "updateadmin";
    }
    
    public String updateAdmin(){
        Admin adm = adminFacade.find(admin_us);
        MainMethod mmt = new MainMethod();
        String md5pass = mmt.covertoMD5(password);
        adm.setAdminEmail(admin_email);
        adm.setPassword(md5pass);
        adm.setStatus(status);
        adminFacade.edit(adm);
        return "listadmin";
    }
}
