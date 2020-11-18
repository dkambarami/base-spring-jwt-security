package com.base_security.business.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "username"))
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String username;
    String password;
    String role = "ROLE_USER";
    public boolean isAccountNonLocked;
    public boolean isCredentialsNonExpired;
    public boolean isAccountNonExpired;
    public boolean isEnabled;
    private String grantedAuthorities;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isAccountNonLocked() {
        return isAccountNonLocked;
    }

    public boolean isCredentialsNonExpired() {
        return isCredentialsNonExpired;
    }

    public boolean isAccountNonExpired() {
        return isAccountNonExpired;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public String getGrantedAuthorities() {
        return grantedAuthorities;
    }

    public void setAccountNonLocked(boolean isAccountNonLocked) {
        this.isAccountNonLocked = isAccountNonLocked;
    }

    public void setCredentialsNonExpired(boolean isCredentialsNonExpired) {
        this.isCredentialsNonExpired = isCredentialsNonExpired;
    }

    public void setAccountNonExpired(boolean isAccountNonExpired) {
        this.isAccountNonExpired = isAccountNonExpired;
    }

    public void setEnabled(boolean isEnabled) {
        this.isEnabled = isEnabled;
    }

    public void setGrantedAuthorities(String grantedAuthorities) {
        this.grantedAuthorities = grantedAuthorities;
    }

    public User(String username, String password,  String grantedAuthorities, boolean isAccountNonLocked, boolean isCredentialsNonExpired,
            boolean isAccountNonExpired, boolean isEnabled) {
        this.username = username;
        this.password = password;
        this.isAccountNonLocked = isAccountNonLocked;
        this.isCredentialsNonExpired = isCredentialsNonExpired;
        this.isAccountNonExpired = isAccountNonExpired;
        this.isEnabled = isEnabled;
        this.grantedAuthorities = grantedAuthorities;
    }

    public User(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User() {
    }

}
