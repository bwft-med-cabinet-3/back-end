package com.lambdaschool.backend.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "strains")
public class Strain {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private String strainid;

    //popular strains by mood, name,description,from d2
    @Column(unique = true, nullable = false)
    private String mood;
    private String name;
    private String description;

    //many to one
    @ManyToOne
    @JoinColumn(name = "dispensarycode", nullable = false)
    @JsonIgnoreProperties("strains")
    private Dispensary dispensary;

    public Strain() {
    }

    public Strain(String mood, String name, String description, Dispensary dispensary) {
        this.mood = mood;
        this.name = name;
        this.description = description;
        this.dispensary = dispensary;
    }

    public Dispensary getDispensary() {
        return dispensary;
    }

    public void setDispensary(Dispensary dispensary) {
        this.dispensary = dispensary;
    }

    public String getStrainid() {
        return strainid;
    }

    public void setStrainid(String strainid) {
        this.strainid = strainid;
    }

    public String getMood() {
        return mood;
    }

    public void setMood(String mood) {
        this.mood = mood;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
