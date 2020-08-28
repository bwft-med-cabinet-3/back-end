package com.lambdaschool.backend.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "dispensarys")
public class Dispensary {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private long dispensarycode;

    @Column(unique = true, nullable = false)
    private String dispensaryname;

    private String cityname;
    private String statename;
    private String zipcode;


    @OneToMany(mappedBy = "dispensary", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties("dispensarys")
    private List<Strain> strains = new ArrayList<>();

    public Dispensary() {
    }

    public Dispensary(String dispensaryname, String cityname, String statename, String zipcode) {
        this.dispensaryname = dispensaryname;
        this.cityname = cityname;
        this.statename = statename;
        this.zipcode = zipcode;
    }

    public long getDispensarycode() {
        return dispensarycode;
    }

    public void setDispensarycode(long dispensarycode) {
        this.dispensarycode = dispensarycode;
    }

    public String getDispensaryname() {
        return dispensaryname;
    }

    public void setDispensaryname(String dispensaryname) {
        this.dispensaryname = dispensaryname;
    }

    public String getCityname() {
        return cityname;
    }

    public void setCityname(String cityname) {
        this.cityname = cityname;
    }

    public String getStatename() {
        return statename;
    }

    public void setStatename(String statename) {
        this.statename = statename;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }
}
