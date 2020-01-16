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
@Table(name = "review_tbl", catalog = "mero_sahar_db", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ReviewTbl.findAll", query = "SELECT r FROM ReviewTbl r")
    , @NamedQuery(name = "ReviewTbl.findById", query = "SELECT r FROM ReviewTbl r WHERE r.id = :id")
    , @NamedQuery(name = "ReviewTbl.findByArticalid", query = "SELECT r FROM ReviewTbl r WHERE r.articalid = :articalid")
    , @NamedQuery(name = "ReviewTbl.findByUserid", query = "SELECT r FROM ReviewTbl r WHERE r.userid = :userid")
    , @NamedQuery(name = "ReviewTbl.findByDate", query = "SELECT r FROM ReviewTbl r WHERE r.date = :date")
    , @NamedQuery(name = "ReviewTbl.findByLikes", query = "SELECT r FROM ReviewTbl r WHERE r.likes = :likes")})
public class ReviewTbl implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "articalid")
    private int articalid;
    @Basic(optional = false)
    @Column(name = "userid")
    private int userid;
    @Basic(optional = false)
    @Lob
    @Column(name = "comment")
    private String comment;
    @Basic(optional = false)
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Basic(optional = false)
    @Column(name = "likes")
    private int likes;

    public ReviewTbl() {
    }

    public ReviewTbl(Integer id) {
        this.id = id;
    }

    public ReviewTbl(Integer id, int articalid, int userid, String comment, Date date, int likes) {
        this.id = id;
        this.articalid = articalid;
        this.userid = userid;
        this.comment = comment;
        this.date = date;
        this.likes = likes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getArticalid() {
        return articalid;
    }

    public void setArticalid(int articalid) {
        this.articalid = articalid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
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
        if (!(object instanceof ReviewTbl)) {
            return false;
        }
        ReviewTbl other = (ReviewTbl) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.ReviewTbl[ id=" + id + " ]";
    }
    
}
