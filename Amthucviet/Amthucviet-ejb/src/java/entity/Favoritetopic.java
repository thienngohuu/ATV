/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author stom2
 */
@Entity
@Table(name = "favoritetopic")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Favoritetopic.findAll", query = "SELECT f FROM Favoritetopic f"),
    @NamedQuery(name = "Favoritetopic.findByIdFavoriteTopic", query = "SELECT f FROM Favoritetopic f WHERE f.idFavoriteTopic = :idFavoriteTopic"),
    @NamedQuery(name = "Favoritetopic.findByIdtopic", query = "SELECT f FROM Favoritetopic f WHERE f.idtopic = :idtopic")})
public class Favoritetopic implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idFavoriteTopic")
    private Integer idFavoriteTopic;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idtopic")
    private int idtopic;
    @JoinColumn(name = "idprofile", referencedColumnName = "idprofile")
    @ManyToOne(optional = false)
    private Profile idprofile;

    public Favoritetopic() {
    }

    public Favoritetopic(Integer idFavoriteTopic) {
        this.idFavoriteTopic = idFavoriteTopic;
    }

    public Favoritetopic(Integer idFavoriteTopic, int idtopic) {
        this.idFavoriteTopic = idFavoriteTopic;
        this.idtopic = idtopic;
    }

    public Integer getIdFavoriteTopic() {
        return idFavoriteTopic;
    }

    public void setIdFavoriteTopic(Integer idFavoriteTopic) {
        this.idFavoriteTopic = idFavoriteTopic;
    }

    public int getIdtopic() {
        return idtopic;
    }

    public void setIdtopic(int idtopic) {
        this.idtopic = idtopic;
    }

    public Profile getIdprofile() {
        return idprofile;
    }

    public void setIdprofile(Profile idprofile) {
        this.idprofile = idprofile;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFavoriteTopic != null ? idFavoriteTopic.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Favoritetopic)) {
            return false;
        }
        Favoritetopic other = (Favoritetopic) object;
        if ((this.idFavoriteTopic == null && other.idFavoriteTopic != null) || (this.idFavoriteTopic != null && !this.idFavoriteTopic.equals(other.idFavoriteTopic))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Favoritetopic[ idFavoriteTopic=" + idFavoriteTopic + " ]";
    }
    
}
