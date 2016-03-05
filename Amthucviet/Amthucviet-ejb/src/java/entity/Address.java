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
@Table(name = "addresses")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Address.findAll", query = "SELECT a FROM Address a"),
    @NamedQuery(name = "Address.findByIdaddress", query = "SELECT a FROM Address a WHERE a.idaddress = :idaddress"),
    @NamedQuery(name = "Address.findByLongitude", query = "SELECT a FROM Address a WHERE a.longitude = :longitude"),
    @NamedQuery(name = "Address.findByLatitude", query = "SELECT a FROM Address a WHERE a.latitude = :latitude"),
    @NamedQuery(name = "Address.findByDetailAddress", query = "SELECT a FROM Address a WHERE a.detailAddress = :detailAddress")})
public class Address implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idaddress")
    private Integer idaddress;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "longitude")
    private Float longitude;
    @Column(name = "latitude")
    private Float latitude;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "detailAddress")
    private String detailAddress;
    @JoinColumn(name = "idcity", referencedColumnName = "idcity")
    @ManyToOne(optional = false)
    private City idcity;
    @JoinColumn(name = "iddistrict", referencedColumnName = "iddistrict")
    @ManyToOne(optional = false)
    private District iddistrict;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idaddress")
    private Collection<Topic> topicCollection;

    public Address() {
    }

    public Address(Integer idaddress) {
        this.idaddress = idaddress;
    }

    public Address(Integer idaddress, String detailAddress) {
        this.idaddress = idaddress;
        this.detailAddress = detailAddress;
    }

    public Integer getIdaddress() {
        return idaddress;
    }

    public void setIdaddress(Integer idaddress) {
        this.idaddress = idaddress;
    }

    public Float getLongitude() {
        return longitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }

    public Float getLatitude() {
        return latitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    public String getDetailAddress() {
        return detailAddress;
    }

    public void setDetailAddress(String detailAddress) {
        this.detailAddress = detailAddress;
    }

    public City getIdcity() {
        return idcity;
    }

    public void setIdcity(City idcity) {
        this.idcity = idcity;
    }

    public District getIddistrict() {
        return iddistrict;
    }

    public void setIddistrict(District iddistrict) {
        this.iddistrict = iddistrict;
    }

    @XmlTransient
    public Collection<Topic> getTopicCollection() {
        return topicCollection;
    }

    public void setTopicCollection(Collection<Topic> topicCollection) {
        this.topicCollection = topicCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idaddress != null ? idaddress.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Address)) {
            return false;
        }
        Address other = (Address) object;
        if ((this.idaddress == null && other.idaddress != null) || (this.idaddress != null && !this.idaddress.equals(other.idaddress))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Address[ idaddress=" + idaddress + " ]";
    }
    
}
