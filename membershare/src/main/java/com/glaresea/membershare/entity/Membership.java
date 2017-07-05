/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.glaresea.membershare.entity;

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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 2017-7-5 21:12:51
 * @author Weiguang Wang
 * @Email: wangwg2005@163.com
 */
@Entity
@Table(name = "membership")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Membership.findAll", query = "SELECT m FROM Membership m"),
    @NamedQuery(name = "Membership.findById", query = "SELECT m FROM Membership m WHERE m.id = :id"),
    @NamedQuery(name = "Membership.findByMemberNo", query = "SELECT m FROM Membership m WHERE m.memberNo = :memberNo"),
    @NamedQuery(name = "Membership.findByIssuer", query = "SELECT m FROM Membership m WHERE m.issuer = :issuer"),
    @NamedQuery(name = "Membership.findByType", query = "SELECT m FROM Membership m WHERE m.type = :type")})
public class Membership implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Size(max = 31)
    @Column(name = "member_no")
    private String memberNo;
    @Size(max = 31)
    @Column(name = "issuer")
    private String issuer;
    @Size(max = 20)
    @Column(name = "type")
    private String type;
    @JoinColumn(name = "owner", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private User owner;

    public Membership() {
    }

    public Membership(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(String memberNo) {
        this.memberNo = memberNo;
    }

    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
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
        if (!(object instanceof Membership)) {
            return false;
        }
        Membership other = (Membership) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.glaresea.membershare.entity.Membership[ id=" + id + " ]";
    }

}
