package com.lambdaschool.backend.models;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "allstrains")
public class AllStrain {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long allstrainid;

    @Column(unique = true, nullable = false)
    private String strainname;

    public AllStrain() {
    }

    public AllStrain(String strainname) {
        this.strainname = strainname;
    }

    //adding getters and setters
    public long getAllstrainid() {
        return allstrainid;
    }

    public void setAllstrainid(long allstrainid) {
        this.allstrainid = allstrainid;
    }

    public String getStrainname() {
        return strainname;
    }

    public void setStrainname(String strainname) {
        this.strainname = strainname;
    }
}
