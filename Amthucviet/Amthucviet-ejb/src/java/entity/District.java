/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author stom2
 */
@Entity
@Table(name = "districts")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "District.findAll", query = "SELECT d FROM District d"),
    @NamedQuery(name = "District.findByIddistrict", query = "SELECT d FROM District d WHERE d.iddistrict = :iddistrict"),
    @NamedQuery(name = "District.findByName", query = "SELECT d FROM District d WHERE d.name = :name")})
public class District implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "iddistrict")
    private Integer iddistrict;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iddistrict")
    private Collection<Address> addressCollection;
    @JoinColumn(name = "idcity", referencedColumnName = "idcity")
    @ManyToOne(optional = false)
    private City idcity;

    public District() {
    }

    public District(Integer iddistrict) {
        this.iddistrict = iddistrict;
    }

    public District(Integer iddistrict, String name) {
        this.iddistrict = iddistrict;
        this.name = name;
    }

    public Integer getIddistrict() {
        return iddistrict;
    }

    public void setIddistrict(Integer iddistrict) {
        this.iddistrict = iddistrict;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public Collection<Address> getAddressCollection() {
        return addressCollection;
    }

    public void setAddressCollection(Collection<Address> addressCollection) {
        this.addressCollection = addressCollection;
    }

    public City getIdcity() {
        return idcity;
    }

    public void setIdcity(City idcity) {
        this.idcity = idcity;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddistrict != null ? iddistrict.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof District)) {
            return false;
        }
        District other = (District) object;
        if ((this.iddistrict == null && other.iddistrict != null) || (this.iddistrict != null && !this.iddistrict.equals(other.iddistrict))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.District[ iddistrict=" + iddistrict + " ]";
    }
    
}
