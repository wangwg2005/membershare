/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.glaresea.membershare.entity;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 2017-7-5 21:12:51
 * @author Weiguang Wang
 * @Email: wangwg2005@163.com
 */
@Entity
@Table(name = "friend")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Friend.findAll", query = "SELECT f FROM Friend f"),
    @NamedQuery(name = "Friend.findByUser1", query = "SELECT f FROM Friend f WHERE f.friendPK.user1 = :user1"),
    @NamedQuery(name = "Friend.findByUser2", query = "SELECT f FROM Friend f WHERE f.friendPK.user2 = :user2")})
public class Friend implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected FriendPK friendPK;

    public Friend() {
    }

    public Friend(FriendPK friendPK) {
        this.friendPK = friendPK;
    }

    public Friend(int user1, int user2) {
        this.friendPK = new FriendPK(user1, user2);
    }

    public FriendPK getFriendPK() {
        return friendPK;
    }

    public void setFriendPK(FriendPK friendPK) {
        this.friendPK = friendPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (friendPK != null ? friendPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Friend)) {
            return false;
        }
        Friend other = (Friend) object;
        if ((this.friendPK == null && other.friendPK != null) || (this.friendPK != null && !this.friendPK.equals(other.friendPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.glaresea.membershare.entity.Friend[ friendPK=" + friendPK + " ]";
    }

}
