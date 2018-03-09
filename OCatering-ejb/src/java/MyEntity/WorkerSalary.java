/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MyEntity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author K
 */
@Entity
@Table(name = "WorkerSalary")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WorkerSalary.findAll", query = "SELECT w FROM WorkerSalary w"),
    @NamedQuery(name = "WorkerSalary.findBySalaryId", query = "SELECT w FROM WorkerSalary w WHERE w.salaryId = :salaryId"),
    @NamedQuery(name = "WorkerSalary.findByWorkingdays", query = "SELECT w FROM WorkerSalary w WHERE w.workingdays = :workingdays"),
    @NamedQuery(name = "WorkerSalary.findByTotalpay", query = "SELECT w FROM WorkerSalary w WHERE w.totalpay = :totalpay"),
    @NamedQuery(name = "WorkerSalary.findByFromdate", query = "SELECT w FROM WorkerSalary w WHERE w.fromdate = :fromdate"),
    @NamedQuery(name = "WorkerSalary.findByTodate", query = "SELECT w FROM WorkerSalary w WHERE w.todate = :todate")})
public class WorkerSalary implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "salary_id")
    private Integer salaryId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "workingdays")
    private int workingdays;
    @Basic(optional = false)
    @NotNull
    @Column(name = "totalpay")
    private double totalpay;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "fromdate")
    private String fromdate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "todate")
    private String todate;
    @JoinColumn(name = "worker_id", referencedColumnName = "worker_id")
    @ManyToOne(optional = false)
    private Worker workerId;

    public WorkerSalary() {
    }

    public WorkerSalary(Integer salaryId) {
        this.salaryId = salaryId;
    }

    public WorkerSalary(Integer salaryId, int workingdays, double totalpay, String fromdate, String todate) {
        this.salaryId = salaryId;
        this.workingdays = workingdays;
        this.totalpay = totalpay;
        this.fromdate = fromdate;
        this.todate = todate;
    }

    public Integer getSalaryId() {
        return salaryId;
    }

    public void setSalaryId(Integer salaryId) {
        this.salaryId = salaryId;
    }

    public int getWorkingdays() {
        return workingdays;
    }

    public void setWorkingdays(int workingdays) {
        this.workingdays = workingdays;
    }

    public double getTotalpay() {
        return totalpay;
    }

    public void setTotalpay(double totalpay) {
        this.totalpay = totalpay;
    }

    public String getFromdate() {
        return fromdate;
    }

    public void setFromdate(String fromdate) {
        this.fromdate = fromdate;
    }

    public String getTodate() {
        return todate;
    }

    public void setTodate(String todate) {
        this.todate = todate;
    }

    public Worker getWorkerId() {
        return workerId;
    }

    public void setWorkerId(Worker workerId) {
        this.workerId = workerId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (salaryId != null ? salaryId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WorkerSalary)) {
            return false;
        }
        WorkerSalary other = (WorkerSalary) object;
        if ((this.salaryId == null && other.salaryId != null) || (this.salaryId != null && !this.salaryId.equals(other.salaryId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MyEntity.WorkerSalary[ salaryId=" + salaryId + " ]";
    }
    
}
