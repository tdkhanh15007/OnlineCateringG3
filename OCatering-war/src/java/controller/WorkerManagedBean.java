/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import MyEntity.District;
import MyEntity.Worker;
import MyEntity.WorkerType;
import MySsbean.DistrictFacadeLocal;
import MySsbean.WorkerFacadeLocal;
import MySsbean.WorkerTypeFacadeLocal;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Khanh
 */
@ManagedBean
@RequestScoped
public class WorkerManagedBean {

    @EJB
    private WorkerTypeFacadeLocal workerTypeFacade;
    @EJB
    private DistrictFacadeLocal districtFacade;
    @EJB
    private WorkerFacadeLocal workerFacade;

    int workerID, worktype, distID;
    String name, address, phone, mess = "";
    Date datejoin;
    boolean status;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getWorkerID() {
        return workerID;
    }

    public void setWorkerID(int workerID) {
        this.workerID = workerID;
    }

    public int getWorktype() {
        return worktype;
    }

    public void setWorktype(int worktype) {
        this.worktype = worktype;
    }

    public int getDistID() {
        return distID;
    }

    public void setDistID(int distID) {
        this.distID = distID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMess() {
        return mess;
    }

    public void setMess(String mess) {
        this.mess = mess;
    }

    public Date getDatejoin() {
        return datejoin;
    }

    public void setDatejoin(Date datejoin) {
        this.datejoin = datejoin;
    }

    public List<District> listD() {
        return districtFacade.findAll();
    }
    
    public List<WorkerType> listT() {
        return workerTypeFacade.findAll();
    }

    /**
     * Creates a new instance of WorkerManagedBean
     */
    public WorkerManagedBean() {
    }

    public String idtotype(int id) {
        WorkerType wt = workerTypeFacade.find(id);
        return wt.getType();
    }

    public String findWorker(int id) {
        Worker wk = workerFacade.find(id);
        setWorkerID(id);
        setName(wk.getName());
        setAddress(wk.getAddress());
        setPhone(wk.getPhone());
        setDistID(wk.getDistrictId().getDistrictId());
        setWorktype(1);
        setStatus(wk.getStatus());
        return "updateworker";
    }

    public String create() {
        try {
            District ds = districtFacade.find(distID);
            WorkerType type = workerTypeFacade.find(worktype);
            Date date = new Date();
            Worker worker = new Worker(name, address, phone, date, status, ds, type);
            workerFacade.create(worker);
            return "worker";
        } catch (Exception e) {
            mess = "Can not create";
            return "createworker";
        }
    }

    public String update(int id) {
        try {
            District ds = districtFacade.find(distID);
            WorkerType type = workerTypeFacade.find(worktype);
            Worker wk = workerFacade.find(id);
            wk.setName(name);
            wk.setAddress(address);
            wk.setPhone(phone);
            wk.setWorktypeId(type);
            wk.setDistrictId(ds);
            wk.setStatus(status);
            wk.setDatejoin(wk.getDatejoin());
            workerFacade.edit(wk);
            return "worker";
        } catch (Exception e) {
            mess = "Can not update";
            return "updateworker";
        }
    }

    public String action1(int id) {
        setWorktype(id);
        return "worker.xhtml?id="+id;
    }

    public List<Worker> listbyType(int id) {
        WorkerType wt = workerTypeFacade.find(id);
        return workerFacade.findType(wt);
    }
}
