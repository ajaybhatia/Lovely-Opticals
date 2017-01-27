/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.triinfotech.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author ajay
 */
@Entity
public class EyeSight implements Serializable {

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
    @ManyToOne
    private Customer customer;

    public EyeSight() {
    }

    public EyeSight(float sphLeftEye, float cylLeftEye, float axisLeftEye, float addLeftEye, float sphRightEye, float cylRightEye, float axisRightEye, float addRightEye, Customer customer) {
        this.sphLeftEye = sphLeftEye;
        this.cylLeftEye = cylLeftEye;
        this.axisLeftEye = axisLeftEye;
        this.addLeftEye = addLeftEye;
        this.sphRightEye = sphRightEye;
        this.cylRightEye = cylRightEye;
        this.axisRightEye = axisRightEye;
        this.addRightEye = addRightEye;
        this.customer = customer;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public float getSphLeftEye() {
        return sphLeftEye;
    }

    public void setSphLeftEye(float sphLeftEye) {
        this.sphLeftEye = sphLeftEye;
    }

    public float getCylLeftEye() {
        return cylLeftEye;
    }

    public void setCylLeftEye(float cylLeftEye) {
        this.cylLeftEye = cylLeftEye;
    }

    public float getAxisLeftEye() {
        return axisLeftEye;
    }

    public void setAxisLeftEye(float axisLeftEye) {
        this.axisLeftEye = axisLeftEye;
    }

    public float getAddLeftEye() {
        return addLeftEye;
    }

    public void setAddLeftEye(float addLeftEye) {
        this.addLeftEye = addLeftEye;
    }

    public float getSphRightEye() {
        return sphRightEye;
    }

    public void setSphRightEye(float sphRightEye) {
        this.sphRightEye = sphRightEye;
    }

    public float getCylRightEye() {
        return cylRightEye;
    }

    public void setCylRightEye(float cylRightEye) {
        this.cylRightEye = cylRightEye;
    }

    public float getAxisRightEye() {
        return axisRightEye;
    }

    public void setAxisRightEye(float axisRightEye) {
        this.axisRightEye = axisRightEye;
    }

    public float getAddRightEye() {
        return addRightEye;
    }

    public void setAddRightEye(float addRightEye) {
        this.addRightEye = addRightEye;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
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
    
}
