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
import javax.persistence.Lob;
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
@Table(name = "blog_tbl", catalog = "mero_sahar_db", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BlogTbl.findAll", query = "SELECT b FROM BlogTbl b")
    , @NamedQuery(name = "BlogTbl.findById", query = "SELECT b FROM BlogTbl b WHERE b.id = :id")
    , @NamedQuery(name = "BlogTbl.findByHeading", query = "SELECT b FROM BlogTbl b WHERE b.heading = :heading")
    , @NamedQuery(name = "BlogTbl.findByLocationid", query = "SELECT b FROM BlogTbl b WHERE b.locationid = :locationid")
    , @NamedQuery(name = "BlogTbl.findByDate", query = "SELECT b FROM BlogTbl b WHERE b.date = :date")
    , @NamedQuery(name = "BlogTbl.findByUserid", query = "SELECT b FROM BlogTbl b WHERE b.userid = :userid")
    , @NamedQuery(name = "BlogTbl.findByExpenses", query = "SELECT b FROM BlogTbl b WHERE b.expenses = :expenses")})
public class BlogTbl implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "heading")
    private String heading;
    @Basic(optional = false)
    @Lob
    @Column(name = "content")
    private String content;
    @Basic(optional = false)
    @Column(name = "locationid")
    private int locationid;
    @Basic(optional = false)
    @Lob
    @Column(name = "photo")
    private String photo;
    @Basic(optional = false)
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Basic(optional = false)
    @Column(name = "userid")
    private int userid;
    @Basic(optional = false)
    @Lob
    @Column(name = "tag")
    private String tag;
    @Basic(optional = false)
    @Column(name = "expenses")
    private int expenses;

    public BlogTbl() {
    }

    public BlogTbl(Integer id) {
        this.id = id;
    }

    public BlogTbl(Integer id, String heading, String content, int locationid, String photo, Date date, int userid, String tag, int expenses) {
        this.id = id;
        this.heading = heading;
        this.content = content;
        this.locationid = locationid;
        this.photo = photo;
        this.date = date;
        this.userid = userid;
        this.tag = tag;
        this.expenses = expenses;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getLocationid() {
        return locationid;
    }

    public void setLocationid(int locationid) {
        this.locationid = locationid;
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

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public int getExpenses() {
        return expenses;
    }

    public void setExpenses(int expenses) {
        this.expenses = expenses;
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
        if (!(object instanceof BlogTbl)) {
            return false;
        }
        BlogTbl other = (BlogTbl) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.BlogTbl[ id=" + id + " ]";
    }
    
}
