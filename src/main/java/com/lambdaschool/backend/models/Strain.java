package com.lambdaschool.backend.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "strains")
public class Strain {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private long strainid;

    //popular strains by mood, name,description,from d2
    @Column(nullable = false)
    private String mood;
    private String strainname;
    private String description;

    //many to one
    @ManyToOne
    @JoinColumn(name = "dispensarycode", nullable = false)
    @JsonIgnoreProperties("strains")
    private Dispensary dispensary;

    public Strain() {
    }

    public Strain(String mood, String strainname, String description, Dispensary dispensary) {
        this.mood = mood;
        this.strainname = strainname;
        this.description = description;
        this.dispensary = dispensary;
    }

    public Dispensary getDispensary() {
        return dispensary;
    }

    public void setDispensary(Dispensary dispensary) {
        this.dispensary = dispensary;
    }

    public long getStrainid() {
        return strainid;
    }

    public void setStrainid(long strainid) {
        this.strainid = strainid;
    }

    public String getMood() {
        return mood;
    }

    public void setMood(String mood) {
        this.mood = mood;
    }

    public String getStrainname() {
        return strainname;
    }

    public void setStrainname(String name) {
        this.strainname = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
