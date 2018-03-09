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

    
    /**
     * Creates a new instance of AdminManagedBean
     */
    public AdminManagedBean() {
    }
    
}
