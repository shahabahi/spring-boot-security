package com.example.demo.auth;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "TBL_APPLICATION_USER", schema = "OPR")
public class ApplicationUser implements Serializable {

    @Id
    private Long id;

    private  String password;

    @Column(name = "USER_NAME")
    private  String userName;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "TBL_USER_ROLES",joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))

    private Set<ApplicationUserRole> roles;

    private  boolean isAccountNonExpired;
    private  boolean isAccountNonLocked;
    private  boolean isCredentialsNonExpired;
    private  boolean isEnabled;


}
