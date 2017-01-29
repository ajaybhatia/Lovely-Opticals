/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.triinfotech.entity;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.Transient;

/**
 *
 * @author ajay
 */
@Entity
public class EyeSight implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private float sphLeftEye;
    private float cylLeftEye;
    private float axisLeftEye;
    private float addLeftEye;
    private float sphRightEye;
    private float cylRightEye;
    private float axisRightEye;
    private float addRightEye;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date createdAt;
    @ManyToOne
    private Customer customer;

    public EyeSight() {
    }

    public EyeSight(float sphLeftEye, float cylLeftEye, float axisLeftEye, float addLeftEye, float sphRightEye, float cylRightEye, float axisRightEye, float addRightEye, Date createdAt, Customer customer) {
        this.sphLeftEye = sphLeftEye;
        this.cylLeftEye = cylLeftEye;
        this.axisLeftEye = axisLeftEye;
        this.addLeftEye = addLeftEye;
        this.sphRightEye = sphRightEye;
        this.cylRightEye = cylRightEye;
        this.axisRightEye = axisRightEye;
        this.addRightEye = addRightEye;
        this.createdAt = createdAt;
        this.customer = customer;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        Long oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public float getSphLeftEye() {
        return sphLeftEye;
    }

    public void setSphLeftEye(float sphLeftEye) {
        float oldSphLeftEye = this.sphLeftEye;
        this.sphLeftEye = sphLeftEye;
        changeSupport.firePropertyChange("sphLeftEye", oldSphLeftEye, sphLeftEye);
    }

    public float getCylLeftEye() {
        return cylLeftEye;
    }

    public void setCylLeftEye(float cylLeftEye) {
        float oldCylLeftEye = this.cylLeftEye;
        this.cylLeftEye = cylLeftEye;
        changeSupport.firePropertyChange("cylLeftEye", oldCylLeftEye, cylLeftEye);
    }

    public float getAxisLeftEye() {
        return axisLeftEye;
    }

    public void setAxisLeftEye(float axisLeftEye) {
        float oldAxisLeftEye = this.axisLeftEye;
        this.axisLeftEye = axisLeftEye;
        changeSupport.firePropertyChange("axisLeftEye", oldAxisLeftEye, axisLeftEye);
    }

    public float getAddLeftEye() {
        return addLeftEye;
    }

    public void setAddLeftEye(float addLeftEye) {
        float oldAddLeftEye = this.addLeftEye;
        this.addLeftEye = addLeftEye;
        changeSupport.firePropertyChange("addLeftEye", oldAddLeftEye, addLeftEye);
    }

    public float getSphRightEye() {
        return sphRightEye;
    }

    public void setSphRightEye(float sphRightEye) {
        float oldSphRightEye = this.sphRightEye;
        this.sphRightEye = sphRightEye;
        changeSupport.firePropertyChange("sphRightEye", oldSphRightEye, sphRightEye);
    }

    public float getCylRightEye() {
        return cylRightEye;
    }

    public void setCylRightEye(float cylRightEye) {
        float oldCylRightEye = this.cylRightEye;
        this.cylRightEye = cylRightEye;
        changeSupport.firePropertyChange("cylRightEye", oldCylRightEye, cylRightEye);
    }

    public float getAxisRightEye() {
        return axisRightEye;
    }

    public void setAxisRightEye(float axisRightEye) {
        float oldAxisRightEye = this.axisRightEye;
        this.axisRightEye = axisRightEye;
        changeSupport.firePropertyChange("axisRightEye", oldAxisRightEye, axisRightEye);
    }

    public float getAddRightEye() {
        return addRightEye;
    }

    public void setAddRightEye(float addRightEye) {
        float oldAddRightEye = this.addRightEye;
        this.addRightEye = addRightEye;
        changeSupport.firePropertyChange("addRightEye", oldAddRightEye, addRightEye);
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        Date oldCreatedAt = this.createdAt;
        this.createdAt = createdAt;
        changeSupport.firePropertyChange("createdAt", oldCreatedAt, createdAt);
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        Customer oldCustomer = this.customer;
        this.customer = customer;
        changeSupport.firePropertyChange("customer", oldCustomer, customer);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EyeSight)) {
            return false;
        }
        EyeSight other = (EyeSight) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "in.triinfotech.entity.EyeSight[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
