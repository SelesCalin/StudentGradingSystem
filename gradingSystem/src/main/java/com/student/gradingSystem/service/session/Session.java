package com.student.gradingSystem.service.session;

import com.student.gradingSystem.domain.entity.enumeration.RoleType;

import java.util.Date;

public class Session  {
    private static final long SESSION_VALIDITY= 24*60*60;
    private Integer userId;
    private RoleType userRole;
    private Date expirationDate;

    public Session(Integer userId, RoleType userRole) {
        this.userId = userId;
        this.userRole = userRole;
        this.expirationDate=new Date(System.currentTimeMillis() + SESSION_VALIDITY * 1000);
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public RoleType getUserRole() {
        return userRole;
    }

    public void setUserRole(RoleType userRole) {
        this.userRole = userRole;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public boolean isExpired(){
        return expirationDate.before(new Date());
    }

}
