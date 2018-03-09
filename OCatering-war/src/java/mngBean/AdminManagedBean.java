/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mngBean;

import MySsbean.AdminFacadeLocal;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

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
    
}
