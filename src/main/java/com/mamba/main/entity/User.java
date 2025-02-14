package com.mamba.main.entity;

import jakarta.persistence.*;

@Entity

public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long UID;
   @Column
    private String Name;
    @Column(unique=true)
    private String emailid;
    @Column
    private String password;



    public User(Long UID, String name, String emailid, String password) {
        this.UID = UID;
        Name = name;
        this.emailid = emailid;
        this.password = password;
    }

    public User() {
        super();
    }

    public Long getUID() {
        return UID;
    }

    public void setUID(Long UID) {
        this.UID = UID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmailid() {
        return emailid;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
