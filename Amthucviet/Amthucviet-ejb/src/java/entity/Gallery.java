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
@Table(name = "galleries")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Gallery.findAll", query = "SELECT g FROM Gallery g"),
    @NamedQuery(name = "Gallery.findByIdgallery", query = "SELECT g FROM Gallery g WHERE g.idgallery = :idgallery"),
    @NamedQuery(name = "Gallery.findByIdmember", query = "SELECT g FROM Gallery g WHERE g.idmember = :idmember"),
    @NamedQuery(name = "Gallery.findByDescription", query = "SELECT g FROM Gallery g WHERE g.description = :description")})
public class Gallery implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idgallery")
    private Integer idgallery;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idmember")
    private int idmember;
    @Size(max = 45)
    @Column(name = "description")
    private String description;
    @JoinColumn(name = "idtopic", referencedColumnName = "idprofile")
    @ManyToOne(optional = false)
    private Profile idtopic;
    @JoinColumn(name = "idtopic", referencedColumnName = "idtopic")
    @ManyToOne(optional = false)
    private Topic idtopic1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idgallery")
    private Collection<Picture> pictureCollection;

    public Gallery() {
    }

    public Gallery(Integer idgallery) {
        this.idgallery = idgallery;
    }

    public Gallery(Integer idgallery, int idmember) {
        this.idgallery = idgallery;
        this.idmember = idmember;
    }

    public Integer getIdgallery() {
        return idgallery;
    }

    public void setIdgallery(Integer idgallery) {
        this.idgallery = idgallery;
    }

    public int getIdmember() {
        return idmember;
    }

    public void setIdmember(int idmember) {
        this.idmember = idmember;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Profile getIdtopic() {
        return idtopic;
    }

    public void setIdtopic(Profile idtopic) {
        this.idtopic = idtopic;
    }

    public Topic getIdtopic1() {
        return idtopic1;
    }

    public void setIdtopic1(Topic idtopic1) {
        this.idtopic1 = idtopic1;
    }

    @XmlTransient
    public Collection<Picture> getPictureCollection() {
        return pictureCollection;
    }

    public void setPictureCollection(Collection<Picture> pictureCollection) {
        this.pictureCollection = pictureCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idgallery != null ? idgallery.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Gallery)) {
            return false;
        }
        Gallery other = (Gallery) object;
        if ((this.idgallery == null && other.idgallery != null) || (this.idgallery != null && !this.idgallery.equals(other.idgallery))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Gallery[ idgallery=" + idgallery + " ]";
    }
    
}
