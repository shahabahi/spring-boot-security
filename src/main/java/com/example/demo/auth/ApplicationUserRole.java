package com.example.demo.auth;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;


@Data
@Entity
@Table(name="TBL_APPLICATION_USER_ROLE")
public class ApplicationUserRole implements Serializable {

    @Id
    @Column(name="ID")
    private Long id;

    @Column(name="ROLE")
    private String role;
}