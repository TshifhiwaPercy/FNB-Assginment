package com.example.fnb.assignment.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="API_AUTHENTICATION")
public class API_ENTITY{
    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public API_ENTITY(){}
    @Id
    @Column(name="User_Id")
    public long userId;


    public API_ENTITY(long userId) {
        this.userId = userId;

    }
}
