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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author stom2
 */
@Entity
@Table(name = "profile")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Profile.findAll", query = "SELECT p FROM Profile p"),
    @NamedQuery(name = "Profile.findByIdprofile", query = "SELECT p FROM Profile p WHERE p.idprofile = :idprofile")})
public class Profile implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idprofile")
    private Integer idprofile;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idprofile")
    private Collection<Comment> commentCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idprofile")
    private Collection<Topic> topicCollection;
    @JoinColumn(name = "idaccount", referencedColumnName = "idaccount")
    @ManyToOne(optional = false)
    private Account idaccount;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idtopic")
    private Collection<Gallery> galleryCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idprofile")
    private Collection<Favoritetopic> favoritetopicCollection;

    public Profile() {
    }

    public Profile(Integer idprofile) {
        this.idprofile = idprofile;
    }

    public Integer getIdprofile() {
        return idprofile;
    }

    public void setIdprofile(Integer idprofile) {
        this.idprofile = idprofile;
    }

    @XmlTransient
    public Collection<Comment> getCommentCollection() {
        return commentCollection;
    }

    public void setCommentCollection(Collection<Comment> commentCollection) {
        this.commentCollection = commentCollection;
    }

    @XmlTransient
    public Collection<Topic> getTopicCollection() {
        return topicCollection;
    }

    public void setTopicCollection(Collection<Topic> topicCollection) {
        this.topicCollection = topicCollection;
    }

    public Account getIdaccount() {
        return idaccount;
    }

    public void setIdaccount(Account idaccount) {
        this.idaccount = idaccount;
    }

    @XmlTransient
    public Collection<Gallery> getGalleryCollection() {
        return galleryCollection;
    }

    public void setGalleryCollection(Collection<Gallery> galleryCollection) {
        this.galleryCollection = galleryCollection;
    }

    @XmlTransient
    public Collection<Favoritetopic> getFavoritetopicCollection() {
        return favoritetopicCollection;
    }

    public void setFavoritetopicCollection(Collection<Favoritetopic> favoritetopicCollection) {
        this.favoritetopicCollection = favoritetopicCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idprofile != null ? idprofile.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Profile)) {
            return false;
        }
        Profile other = (Profile) object;
        if ((this.idprofile == null && other.idprofile != null) || (this.idprofile != null && !this.idprofile.equals(other.idprofile))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Profile[ idprofile=" + idprofile + " ]";
    }
    
}
