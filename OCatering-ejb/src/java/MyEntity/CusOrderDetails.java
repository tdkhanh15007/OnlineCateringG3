/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MyEntity;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author K
 */
@Entity
@Table(name = "CusOrderDetails")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CusOrderDetails.findAll", query = "SELECT c FROM CusOrderDetails c"),
    @NamedQuery(name = "CusOrderDetails.findByCusorderId", query = "SELECT c FROM CusOrderDetails c WHERE c.cusOrderDetailsPK.cusorderId = :cusorderId"),
    @NamedQuery(name = "CusOrderDetails.findByFoodId", query = "SELECT c FROM CusOrderDetails c WHERE c.cusOrderDetailsPK.foodId = :foodId")})
public class CusOrderDetails implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CusOrderDetailsPK cusOrderDetailsPK;
    @JoinColumn(name = "cusorder_id", referencedColumnName = "cusorder_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private CusOrder cusOrder;

    public CusOrderDetails() {
    }

    public CusOrderDetails(CusOrderDetailsPK cusOrderDetailsPK) {
        this.cusOrderDetailsPK = cusOrderDetailsPK;
    }

    public CusOrderDetails(int cusorderId, int foodId) {
        this.cusOrderDetailsPK = new CusOrderDetailsPK(cusorderId, foodId);
    }

    public CusOrderDetailsPK getCusOrderDetailsPK() {
        return cusOrderDetailsPK;
    }

    public void setCusOrderDetailsPK(CusOrderDetailsPK cusOrderDetailsPK) {
        this.cusOrderDetailsPK = cusOrderDetailsPK;
    }

    public CusOrder getCusOrder() {
        return cusOrder;
    }

    public void setCusOrder(CusOrder cusOrder) {
        this.cusOrder = cusOrder;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cusOrderDetailsPK != null ? cusOrderDetailsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CusOrderDetails)) {
            return false;
        }
        CusOrderDetails other = (CusOrderDetails) object;
        if ((this.cusOrderDetailsPK == null && other.cusOrderDetailsPK != null) || (this.cusOrderDetailsPK != null && !this.cusOrderDetailsPK.equals(other.cusOrderDetailsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MyEntity.CusOrderDetails[ cusOrderDetailsPK=" + cusOrderDetailsPK + " ]";
    }
    
}
