/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.glaresea.membershare.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 * 2017-7-5 21:12:51
 * @author Weiguang Wang
 * @Email: wangwg2005@163.com
 */
@Embeddable
public class FriendPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "user1")
    private int user1;
    @Basic(optional = false)
    @NotNull
    @Column(name = "user2")
    private int user2;

    public FriendPK() {
    }

    public FriendPK(int user1, int user2) {
        this.user1 = user1;
        this.user2 = user2;
    }

    public int getUser1() {
        return user1;
    }

    public void setUser1(int user1) {
        this.user1 = user1;
    }

    public int getUser2() {
        return user2;
    }

    public void setUser2(int user2) {
        this.user2 = user2;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) user1;
        hash += (int) user2;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FriendPK)) {
            return false;
        }
        FriendPK other = (FriendPK) object;
        if (this.user1 != other.user1) {
            return false;
        }
        if (this.user2 != other.user2) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.glaresea.membershare.entity.FriendPK[ user1=" + user1 + ", user2=" + user2 + " ]";
    }

}
