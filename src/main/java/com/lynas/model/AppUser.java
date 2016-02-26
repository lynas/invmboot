package com.lynas.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by LynAs on 26-Feb-16
 */
@Entity
public class AppUser {
    @Id
    @GeneratedValue
    private long id;
    @Column(nullable = false, unique = true)
    private String userName;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String fullName;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<UserRole> roles;

    public AppUser() {
    }

    public AppUser(String userName, String password, String fullName, List<UserRole> roles) {
        this.userName = userName;
        this.password = password;
        this.fullName = fullName;
        this.roles = roles;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public List<UserRole> getRoles() {
        return roles;
    }

    public void setRoles(List<UserRole> roles) {
        this.roles = roles;
    }
}
