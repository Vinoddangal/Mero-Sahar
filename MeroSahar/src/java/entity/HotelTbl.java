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
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Rukesh
 */
@Entity
@Table(name = "hotel_tbl", catalog = "mero_sahar_db", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HotelTbl.findAll", query = "SELECT h FROM HotelTbl h")
    , @NamedQuery(name = "HotelTbl.findById", query = "SELECT h FROM HotelTbl h WHERE h.id = :id")
    , @NamedQuery(name = "HotelTbl.findByName", query = "SELECT h FROM HotelTbl h WHERE h.name = :name")
    , @NamedQuery(name = "HotelTbl.findByConatct", query = "SELECT h FROM HotelTbl h WHERE h.conatct = :conatct")
    , @NamedQuery(name = "HotelTbl.findByLocationid", query = "SELECT h FROM HotelTbl h WHERE h.locationid = :locationid")
    , @NamedQuery(name = "HotelTbl.findByWebsite", query = "SELECT h FROM HotelTbl h WHERE h.website = :website")
    , @NamedQuery(name = "HotelTbl.findByRating", query = "SELECT h FROM HotelTbl h WHERE h.rating = :rating")})
public class HotelTbl implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "conatct")
    private long conatct;
    @Basic(optional = false)
    @Column(name = "locationid")
    private int locationid;
    @Basic(optional = false)
    @Column(name = "website")
    private String website;
    @Basic(optional = false)
    @Lob
    @Column(name = "service")
    private String service;
    @Basic(optional = false)
    @Column(name = "rating")
    private int rating;

    public HotelTbl() {
    }

    public HotelTbl(Integer id) {
        this.id = id;
    }

    public HotelTbl(Integer id, String name, long conatct, int locationid, String website, String service, int rating) {
        this.id = id;
        this.name = name;
        this.conatct = conatct;
        this.locationid = locationid;
        this.website = website;
        this.service = service;
        this.rating = rating;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getConatct() {
        return conatct;
    }

    public void setConatct(long conatct) {
        this.conatct = conatct;
    }

    public int getLocationid() {
        return locationid;
    }

    public void setLocationid(int locationid) {
        this.locationid = locationid;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
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
        if (!(object instanceof HotelTbl)) {
            return false;
        }
        HotelTbl other = (HotelTbl) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.HotelTbl[ id=" + id + " ]";
    }
    
}
