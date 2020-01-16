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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Rukesh
 */
@Entity
@Table(name = "artical_tbl")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ArticalTbl.findAll", query = "SELECT a FROM ArticalTbl a")
    , @NamedQuery(name = "ArticalTbl.findById", query = "SELECT a FROM ArticalTbl a WHERE a.id = :id")
    , @NamedQuery(name = "ArticalTbl.findByHeading", query = "SELECT a FROM ArticalTbl a WHERE a.heading = :heading")
    , @NamedQuery(name = "ArticalTbl.findBySubheading", query = "SELECT a FROM ArticalTbl a WHERE a.subheading = :subheading")
    , @NamedQuery(name = "ArticalTbl.findByDate", query = "SELECT a FROM ArticalTbl a WHERE a.date = :date")
    , @NamedQuery(name = "ArticalTbl.findByType", query = "SELECT a FROM ArticalTbl a WHERE a.type = :type")})
public class ArticalTbl implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "heading")
    private String heading;
    @Column(name = "subheading")
    private String subheading;
    @Lob
    @Column(name = "content")
    private String content;
    @Lob
    @Column(name = "photo")
    private String photo;
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Lob
    @Column(name = "tags")
    private String tags;
    @Column(name = "type")
    private String type;
    @JoinColumn(name = "locationid", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private LocationTabl locationid;
    @JoinColumn(name = "userid", referencedColumnName = "id")
    @ManyToOne
    private UserTbl userid;

    public ArticalTbl() {
    }

    public ArticalTbl(Integer id) {
        this.id = id;
    }

    public ArticalTbl(Integer id, String heading) {
        this.id = id;
        this.heading = heading;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getSubheading() {
        return subheading;
    }

    public void setSubheading(String subheading) {
        this.subheading = subheading;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocationTabl getLocationid() {
        return locationid;
    }

    public void setLocationid(LocationTabl locationid) {
        this.locationid = locationid;
    }

    public UserTbl getUserid() {
        return userid;
    }

    public void setUserid(UserTbl userid) {
        this.userid = userid;
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
        if (!(object instanceof ArticalTbl)) {
            return false;
        }
        ArticalTbl other = (ArticalTbl) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.ArticalTbl[ id=" + id + " ]";
    }
    
}
