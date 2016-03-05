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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author stom2
 */
@Entity
        @Table(name = "accounts")
        @XmlRootElement
        @NamedQueries({
            @NamedQuery(name = "Account.findAll", query = "SELECT a FROM Account a"),
            @NamedQuery(name = "Account.findByIdaccount", query = "SELECT a FROM Account a WHERE a.idaccount = :idaccount"),
            @NamedQuery(name = "Account.findByUsername", query = "SELECT a FROM Account a WHERE a.username like :username AND a.idrole = :idrole"),
            @NamedQuery(name = "Account.findByEmail", query = "SELECT a FROM Account a WHERE a.email like :email AND a.idrole = :idrole"),           
        @NamedQuery(name = "Account.findByStatus", query = "SELECT a FROM Account a WHERE a.status = :status")

})
public class Account implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idaccount")
    private Integer idaccount;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "password")
    private String password;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "email")
    private String email;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "phone")
    private String phone;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    private boolean status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idaccount")
    private Collection<Profile> profileCollection;
    @JoinColumn(name = "idrole", referencedColumnName = "idrole")
    @ManyToOne(optional = false)
    private Role idrole;

    public Account() {
    }

    public Account(Integer idaccount) {
        this.idaccount = idaccount;
    }

    public Account(Integer idaccount, String username, String password, String email, String phone, boolean status) {
        this.idaccount = idaccount;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.status = status;
    }

    public Integer getIdaccount() {
        return idaccount;
    }

    public void setIdaccount(Integer idaccount) {
        this.idaccount = idaccount;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @XmlTransient
    public Collection<Profile> getProfileCollection() {
        return profileCollection;
    }

    public void setProfileCollection(Collection<Profile> profileCollection) {
        this.profileCollection = profileCollection;
    }

    public Role getIdrole() {
        return idrole;
    }

    public void setIdrole(Role idrole) {
        this.idrole = idrole;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idaccount != null ? idaccount.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Account)) {
            return false;
        }
        Account other = (Account) object;
        if ((this.idaccount == null && other.idaccount != null) || (this.idaccount != null && !this.idaccount.equals(other.idaccount))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Account[ idaccount=" + idaccount + " ]";
    }

}
