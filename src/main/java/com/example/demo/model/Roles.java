//package com.example.demo.model;
//
//import javax.persistence.*;
//import java.io.Serializable;
//import java.util.Date;
//
//@Data
//@Entity
//@Table(name = "TBL_ROLE_GROUP")
//public class Roles  implements Serializable {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_roles")
//    @SequenceGenerator(name = "seq_roles", sequenceName = "OPR.SEQ_ROLES", allocationSize = 1)
//    @Column(name = "ID")
//    private Long id;
//
//    @GenericGenerator(
//            name = "assigned-sequence",
//            strategy = "com.eki.opr.utils.StringSequenceIdentifier"
//    )
//    @GeneratedValue(
//            generator = "assigned-sequence",
//            strategy = GenerationType.AUTO)
//    @Column(name = "LARGE_ID")
//    private String largeId;
//
//    @Column(name = "NAME")
//    private String name;
//
//    @Convert(converter = YesNoConverter.class)
//    @Column(name = "HAS_PERMISSION_ADD")
//    private YesNo hasPermissionToAdd;
//
//    public Roles() {
//        super();
//    }
//
//    public Roles(RolesInput input) {
//        fromDto(input);
//    }
//
//    public Roles(Long id) {
//        this.id=id;
//    }
//
//    public void fromDto(RolesInput input) {
//        this.name = input.getName() != null ? input.getName() : null;
//        this.hasPermissionToAdd = input.getHasPermissionToAdd() != null ? input.getHasPermissionToAdd() : null;
//        if (input.getId() == null) { //first time
//            setCreatedBy(input.getCreatedByEntity());
//            setModifiedBy(input.getCreatedByEntity());
//            setCreatedAt(new Date());
//            setModifiedAt(new Date());
//            this.largeId = StringSequenceIdentifier.generateLargeId();
//        } else {
//            this.id = input.getId();
//            setModifiedBy(input.getCreatedByEntity());
//            setModifiedAt(new Date());
//        }
//    }
//
//
//    public RolesOutput toDto() {
//        RolesOutput output = new RolesOutput();
//        output.setId(id);
//        output.setName(name);
//        return output;
//    }
//}
