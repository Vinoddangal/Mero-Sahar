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
@Table(name = "location_tabl", catalog = "mero_sahar_db", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LocationTabl.findAll", query = "SELECT l FROM LocationTabl l")
    , @NamedQuery(name = "LocationTabl.findById", query = "SELECT l FROM LocationTabl l WHERE l.id = :id")
    , @NamedQuery(name = "LocationTabl.findByState", query = "SELECT l FROM LocationTabl l WHERE l.state = :state")
    , @NamedQuery(name = "LocationTabl.findByCity", query = "SELECT l FROM LocationTabl l WHERE l.city = :city")
    , @NamedQuery(name = "LocationTabl.findByStreet", query = "SELECT l FROM LocationTabl l WHERE l.street = :street")
    , @NamedQuery(name = "LocationTabl.findByDistrict", query = "SELECT l FROM LocationTabl l WHERE l.district = :district")})
public class LocationTabl implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "locationid")
    private Collection<ArticalTbl> articalTblCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "state")
    private int state;
    @Basic(optional = false)
    @Column(name = "city")
    private String city;
    @Basic(optional = false)
    @Column(name = "street")
    private String street;
    @Basic(optional = false)
    @Column(name = "district")
    private String district;

    public LocationTabl() {
    }

    public LocationTabl(Integer id) {
        this.id = id;
    }

    public LocationTabl(Integer id, int state, String city, String street, String district) {
        this.id = id;
        this.state = state;
        this.city = city;
        this.street = street;
        this.district = district;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
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
        if (!(object instanceof LocationTabl)) {
            return false;
        }
        LocationTabl other = (LocationTabl) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.LocationTabl[ id=" + id + " ]";
    }

    @XmlTransient
    public Collection<ArticalTbl> getArticalTblCollection() {
        return articalTblCollection;
    }

    public void setArticalTblCollection(Collection<ArticalTbl> articalTblCollection) {
        this.articalTblCollection = articalTblCollection;
    }
    
}
