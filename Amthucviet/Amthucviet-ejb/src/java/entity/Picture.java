/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author stom2
 */
@Entity
@Table(name = "pictures")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Picture.findAll", query = "SELECT p FROM Picture p"),
    @NamedQuery(name = "Picture.findByIdpicture", query = "SELECT p FROM Picture p WHERE p.idpicture = :idpicture"),
    @NamedQuery(name = "Picture.findByLink", query = "SELECT p FROM Picture p WHERE p.link = :link"),
    @NamedQuery(name = "Picture.findByStatus", query = "SELECT p FROM Picture p WHERE p.status = :status"),
    @NamedQuery(name = "Picture.findByDateUpload", query = "SELECT p FROM Picture p WHERE p.dateUpload = :dateUpload")})
public class Picture implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idpicture")
    private Integer idpicture;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "link")
    private String link;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    private boolean status;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dateUpload")
    @Temporal(TemporalType.DATE)
    private Date dateUpload;
    @JoinColumn(name = "idgallery", referencedColumnName = "idgallery")
    @ManyToOne(optional = false)
    private Gallery idgallery;

    public Picture() {
    }

    public Picture(Integer idpicture) {
        this.idpicture = idpicture;
    }

    public Picture(Integer idpicture, String link, boolean status, Date dateUpload) {
        this.idpicture = idpicture;
        this.link = link;
        this.status = status;
        this.dateUpload = dateUpload;
    }

    public Integer getIdpicture() {
        return idpicture;
    }

    public void setIdpicture(Integer idpicture) {
        this.idpicture = idpicture;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Date getDateUpload() {
        return dateUpload;
    }

    public void setDateUpload(Date dateUpload) {
        this.dateUpload = dateUpload;
    }

    public Gallery getIdgallery() {
        return idgallery;
    }

    public void setIdgallery(Gallery idgallery) {
        this.idgallery = idgallery;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpicture != null ? idpicture.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Picture)) {
            return false;
        }
        Picture other = (Picture) object;
        if ((this.idpicture == null && other.idpicture != null) || (this.idpicture != null && !this.idpicture.equals(other.idpicture))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Picture[ idpicture=" + idpicture + " ]";
    }
    
}
