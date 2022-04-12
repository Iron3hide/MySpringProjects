package com.example.demo.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name="guardians")
public class Guardian {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_Guardian;

    @Column(name = "name_Guardian", nullable = false)
    private String name_Guardian;

    @Column(name = "dob_Guardian")
    private Date dob_Guardian;

    @Column(name = "relationShip_Guardian")
    private String relationShip_Guardian;

    @Column(name = "address1_Guardian")
    private String address1_Guardian;

    @Column(name = "address2_Guardian")
    private String address2_Guardian;

    @Column(name = "address3_Guardian")
    private String address3_Guardian;

    @Column(name = "address4_Guardian")
    private String address4_Guardian;

    public Guardian() {
    }

    public Guardian(long id_Guardian, String name_Guardian,Date dob_Guardian, String relationShip_Guardian, String address1_Guardian, String address2_Guardian, String address3_Guardian, String address4_Guardian) {
        this.id_Guardian = id_Guardian;
        this.name_Guardian = name_Guardian;
        this.dob_Guardian = dob_Guardian;
        this.relationShip_Guardian = relationShip_Guardian;
        this.address1_Guardian = address1_Guardian;
        this.address2_Guardian = address2_Guardian;
        this.address3_Guardian = address3_Guardian;
        this.address4_Guardian = address4_Guardian;
    }

    public long getId_Guardian() {
        return id_Guardian;
    }

    public void setId_Guardian(long id_Guardian) {
        this.id_Guardian = id_Guardian;
    }

    public String getName_Guardian() {
        return name_Guardian;
    }

    public void setName_Guardian(String name_Guardian) {
        this.name_Guardian = name_Guardian;
    }

    public Date getDob_Guardian() {
        return dob_Guardian;
    }

    public void setDob_Guardian(Date dob_Guardian) {
        this.dob_Guardian = dob_Guardian;
    }

    public String getRelationShip_Guardian() {
        return relationShip_Guardian;
    }

    public void setRelationShip_Guardian(String relationShip_Guardian) {
        this.relationShip_Guardian = relationShip_Guardian;
    }

    public String getAddress1_Guardian() {
        return address1_Guardian;
    }

    public void setAddress1_Guardian(String address1_Guardian) {
        this.address1_Guardian = address1_Guardian;
    }

    public String getAddress2_Guardian() {
        return address2_Guardian;
    }

    public void setAddress2_Guardian(String address2_Guardian) {
        this.address2_Guardian = address2_Guardian;
    }

    public String getAddress3_Guardian() {
        return address3_Guardian;
    }

    public void setAddress3_Guardian(String address3_Guardian) {
        this.address3_Guardian = address3_Guardian;
    }

    public String getAddress4_Guardian() {
        return address4_Guardian;
    }

    public void setAddress4_Guardian(String address4_Guardian) {
        this.address4_Guardian = address4_Guardian;
    }
}