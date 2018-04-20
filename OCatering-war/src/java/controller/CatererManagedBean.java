/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import MyEntity.Caterer;
import MyEntity.District;
import MySsbean.CatererFacadeLocal;
import MySsbean.DistrictFacadeLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;

/**
 *
 * @author Trung Trung
 */
@Named(value = "catererMB")
@SessionScoped
public class CatererManagedBean implements Serializable {

    @EJB
    private DistrictFacadeLocal districtFacade;
    private String ctrddress;
    private String ctrname;
    private String ctrphone;
    private int drr;

    private Caterer caterers;
    private District d;
    private String catererUser;
    private String catererPass;
    private String distric;
    private String mess;
    private String oldpass;
    private String newpass;
    private String cfnewpass;

    @EJB
    private CatererFacadeLocal catererFacade;

    /**
     * Creates a new instance of CatererManagedBean
     */
    public CatererManagedBean() {
    }

    public String login() throws SQLException {
        FacesContext context = FacesContext.getCurrentInstance();
        if (catererFacade.checklogin(catererUser, catererPass)) {
            caterers = catererFacade.find(catererUser);
            context.getExternalContext().getSessionMap().put("sscaterer", caterers);
            District a = caterers.getDistrictId();
            distric = a.getDistname();
            drr = caterers.getDistrictId().getDistrictId();
            
//            return "index";
//            FacesContext fc = FacesContext.getCurrentInstance();
//            fc.addMessage(null, new FacesMessage("Login success!"));
            return "index.xhtml";
        } else {
            return "error.xhtml";
        }
    }

    public String catererslogout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "login.xhtml";
    }


    public String changePassword() {
        if (caterers.getPassword().equals(oldpass)) {
            System.out.println(caterers.getPassword());
            if (newpass.equals(cfnewpass)) {
                caterers = catererFacade.find(catererUser);
                caterers.setPassword(newpass);
                catererFacade.edit(caterers);
                return "caterer_info.xhtml";
            }
            }
        return "error.xhtml";
    }

    
    public void validatePassword(ComponentSystemEvent event) {

		FacesContext fc = FacesContext.getCurrentInstance();

		UIComponent components = event.getComponent();

		// get password
		UIInput uiInputPassword = (UIInput) components
				.findComponent("password");

		String password = uiInputPassword.getLocalValue() == null ? ""
				: uiInputPassword.getLocalValue().toString();

		String passwordId = uiInputPassword.getClientId();

		// get confirm password
		UIInput uiInputConfirmPassword = (UIInput) components
				.findComponent("confirmPassword");
		String confirmPassword = uiInputConfirmPassword.getLocalValue() == null ? ""
				: uiInputConfirmPassword.getLocalValue().toString();

		// Let required="true" do its job.
		if (password.isEmpty() || confirmPassword.isEmpty()) {
			return;
		}

		if (!password.equals(confirmPassword)) {

			FacesMessage msg = new FacesMessage(
					"Password must match confirm password");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			fc.addMessage(passwordId, msg);
			fc.renderResponse();
		}
	}
    
    
    
    public List<District> showlistdt() {
        return districtFacade.findAll();

    }

    public String updateCarterer() {
        caterers = catererFacade.find(catererUser);
        caterers.setAddress(ctrddress);
        caterers.setCatererName(ctrname);
        caterers.setPhone(ctrphone);
        d = districtFacade.find(drr);
        d.setDistrictId(drr);
        caterers.setDistrictId(d);
        catererFacade.edit(caterers);
        return "caterer_info";
    }

    public Caterer getCaterers() {
        return caterers;
    }

    public void setCaterers(Caterer caterers) {
        this.caterers = caterers;
    }

    public String getCatererUser() {
        return catererUser;
    }

    public void setCatererUser(String catererUser) {
        this.catererUser = catererUser;
    }

    public String getCatererPass() {
        return catererPass;
    }

    public void setCatererPass(String catererPass) {
        this.catererPass = catererPass;
    }

    public String getDistric() {
        return distric;
    }

    public void setDistric(String distric) {
        this.distric = distric;
    }

    public District getD() {
        return d;
    }

    public void setD(District d) {
        this.d = d;
    }

    public String getCtrddress() {
        return ctrddress;
    }

    public void setCtrddress(String ctrddress) {
        this.ctrddress = ctrddress;
    }

    public String getCtrname() {
        return ctrname;
    }

    public void setCtrname(String ctrname) {
        this.ctrname = ctrname;
    }

    public String getCtrphone() {
        return ctrphone;
    }

    public void setCtrphone(String ctrphone) {
        this.ctrphone = ctrphone;
    }

    public int getDrr() {
        return drr;
    }

    public void setDrr(int drr) {
        this.drr = drr;
    }

    public String getOldpass() {
        return oldpass;
    }

    public void setOldpass(String oldpass) {
        this.oldpass = oldpass;
    }

    public String getNewpass() {
        return newpass;
    }

    public void setNewpass(String newpass) {
        this.newpass = newpass;
    }

    public String getCfnewpass() {
        return cfnewpass;
    }

    public void setCfnewpass(String cfnewpass) {
        this.cfnewpass = cfnewpass;
    }

    public String getMess() {
        return mess;
    }

    public void setMess(String mess) {
        this.mess = mess;
    }

}
