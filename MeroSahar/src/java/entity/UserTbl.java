/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Rukesh
 */
@Entity
@Table(name = "user_tbl")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserTbl.findAll", query = "SELECT u FROM UserTbl u")
    , @NamedQuery(name = "UserTbl.findById", query = "SELECT u FROM UserTbl u WHERE u.id = :id")
    , @NamedQuery(name = "UserTbl.findByFirstname", query = "SELECT u FROM UserTbl u WHERE u.firstname = :firstname")
    , @NamedQuery(name = "UserTbl.findByLastname", query = "SELECT u FROM UserTbl u WHERE u.lastname = :lastname")
    , @NamedQuery(name = "UserTbl.findByContact", query = "SELECT u FROM UserTbl u WHERE u.contact = :contact")
    , @NamedQuery(name = "UserTbl.findByLocationid", query = "SELECT u FROM UserTbl u WHERE u.locationid = :locationid")
    , @NamedQuery(name = "UserTbl.findByEmail", query = "SELECT u FROM UserTbl u WHERE u.email = :email")
    , @NamedQuery(name = "UserTbl.findByPassword", query = "SELECT u FROM UserTbl u WHERE u.password = :password")})
public class UserTbl implements Serializable {

    @OneToMany(mappedBy = "userid")
    private Collection<ArticalTbl> articalTblCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "firstname")
    private String firstname;
    @Basic(optional = false)
    @Column(name = "lastname")
    private String lastname;
    @Basic(optional = false)
    @Column(name = "contact")
    private long contact;
    @Basic(optional = false)
    @Column(name = "locationid")
    private int locationid;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @Column(name = "password")
    private String password;

    public UserTbl() {
    }

    public UserTbl(Integer id) {
        this.id = id;
    }

    public UserTbl(Integer id, String firstname, String lastname, long contact, int locationid, String email, String password) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.contact = contact;
        this.locationid = locationid;
        this.email = email;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public long getContact() {
        return contact;
    }

    public void setContact(long contact) {
        this.contact = contact;
    }

    public int getLocationid() {
        return locationid;
    }

    public void setLocationid(int locationid) {
        this.locationid = locationid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
        if (!(object instanceof UserTbl)) {
            return false;
        }
        UserTbl other = (UserTbl) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.UserTbl[ id=" + id + " ]";
    }

    @XmlTransient
    public Collection<ArticalTbl> getArticalTblCollection() {
        return articalTblCollection;
    }

    public void setArticalTblCollection(Collection<ArticalTbl> articalTblCollection) {
        this.articalTblCollection = articalTblCollection;
    }
    
}
