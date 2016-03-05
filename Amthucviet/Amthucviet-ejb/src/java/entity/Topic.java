/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author stom2
 */
@Entity
@Table(name = "topics")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Topic.findAll", query = "SELECT t FROM Topic t"),
    @NamedQuery(name = "Topic.findByIdtopic", query = "SELECT t FROM Topic t WHERE t.idtopic = :idtopic"),
    @NamedQuery(name = "Topic.findByIdgallery", query = "SELECT t FROM Topic t WHERE t.idgallery = :idgallery"),
    @NamedQuery(name = "Topic.findByDateCreate", query = "SELECT t FROM Topic t WHERE t.dateCreate = :dateCreate"),
    @NamedQuery(name = "Topic.findBySubject", query = "SELECT t FROM Topic t WHERE t.subject = :subject"),
    @NamedQuery(name = "Topic.findByContent", query = "SELECT t FROM Topic t WHERE t.content = :content"),
    @NamedQuery(name = "Topic.findByNumberOfView", query = "SELECT t FROM Topic t WHERE t.numberOfView = :numberOfView"),
    @NamedQuery(name = "Topic.findByLastEdit", query = "SELECT t FROM Topic t WHERE t.lastEdit = :lastEdit")})
public class Topic implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idtopic")
    private Integer idtopic;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idgallery")
    private int idgallery;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dateCreate")
    @Temporal(TemporalType.DATE)
    private Date dateCreate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "subject")
    private String subject;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "content")
    private String content;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numberOfView")
    private int numberOfView;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "tag")
    private String tag;
    @Lob
    @Size(max = 65535)
    @Column(name = "event")
    private String event;
    @Basic(optional = false)
    @NotNull
    @Column(name = "lastEdit")
    @Temporal(TemporalType.DATE)
    private Date lastEdit;
    @JoinColumn(name = "idaddress", referencedColumnName = "idaddress")
    @ManyToOne(optional = false)
    private Address idaddress;
    @JoinColumn(name = "idprofile", referencedColumnName = "idprofile")
    @ManyToOne(optional = false)
    private Profile idprofile;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idtopic1")
    private Collection<Gallery> galleryCollection;

    public Topic() {
    }

    public Topic(Integer idtopic) {
        this.idtopic = idtopic;
    }

    public Topic(Integer idtopic, int idgallery, Date dateCreate, String subject, String content, int numberOfView, String tag, Date lastEdit) {
        this.idtopic = idtopic;
        this.idgallery = idgallery;
        this.dateCreate = dateCreate;
        this.subject = subject;
        this.content = content;
        this.numberOfView = numberOfView;
        this.tag = tag;
        this.lastEdit = lastEdit;
    }

    public Integer getIdtopic() {
        return idtopic;
    }

    public void setIdtopic(Integer idtopic) {
        this.idtopic = idtopic;
    }

    public int getIdgallery() {
        return idgallery;
    }

    public void setIdgallery(int idgallery) {
        this.idgallery = idgallery;
    }

    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getNumberOfView() {
        return numberOfView;
    }

    public void setNumberOfView(int numberOfView) {
        this.numberOfView = numberOfView;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public Date getLastEdit() {
        return lastEdit;
    }

    public void setLastEdit(Date lastEdit) {
        this.lastEdit = lastEdit;
    }

    public Address getIdaddress() {
        return idaddress;
    }

    public void setIdaddress(Address idaddress) {
        this.idaddress = idaddress;
    }

    public Profile getIdprofile() {
        return idprofile;
    }

    public void setIdprofile(Profile idprofile) {
        this.idprofile = idprofile;
    }

    @XmlTransient
    public Collection<Gallery> getGalleryCollection() {
        return galleryCollection;
    }

    public void setGalleryCollection(Collection<Gallery> galleryCollection) {
        this.galleryCollection = galleryCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtopic != null ? idtopic.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Topic)) {
            return false;
        }
        Topic other = (Topic) object;
        if ((this.idtopic == null && other.idtopic != null) || (this.idtopic != null && !this.idtopic.equals(other.idtopic))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Topic[ idtopic=" + idtopic + " ]";
    }
    
}
