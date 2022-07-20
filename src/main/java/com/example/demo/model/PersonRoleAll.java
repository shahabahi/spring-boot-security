//package com.example.demo.model;
//
//import javax.persistence.*;
//import java.io.Serializable;
//
//@Data
//@Entity
//@Table(name = "VIW_PERSON_ALL")
//public class PersonRoleAll implements Serializable {
//
//    @Id
//
//    @Column(name = "ID")
//    public Long id;
//
//    @Column(name = "PERSON_NAME")
//    private String fullName;
//
//    @Column(name = "USERNAME")
//    private String username;
//
//    @JoinColumn(name = "OPS_ROLE_ID")
//    @ManyToOne(fetch = FetchType.LAZY)
//    private Roles roles;
//
//    @Convert(converter = PersonCompanyConverter.class)
//    @Column(name = "COMPANY_ID")
//    private PersonCompany personCompany;
//
//    @Column(name = "PERSONELID")
//    private String personnelId;
//
//    @Column(name = "ENABLED")
//    private Long enabled;
//
//    public PersonRoleAllOutput toDto() {
//        PersonRoleAllOutput  output = new PersonRoleAllOutput();
//        output.setId(id);
//        output.setFullName(fullName);
//        output.setRoleId(roles.getId());
//        output.setRoleName(roles.getName());
//        output.setUsername(username);
//        output.setPersonCompany(personCompany);
//        output.setEnabled(enabled);
//        return output;
//
//    }
//
//}
