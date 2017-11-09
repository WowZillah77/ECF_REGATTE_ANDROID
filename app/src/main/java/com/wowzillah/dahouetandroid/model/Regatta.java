package com.wowzillah.dahouetandroid.model;

import java.sql.Date;

/**
 * Created by david on 07/11/17.
 */

public class Regatta {
    private int regatta_id;
    private String regatta_nom;
    private Date regatta_date;
    private Float regatta_distance;
    private String challenge_nom;

    public int getRegatta_id() {
        return regatta_id;
    }

    public void setRegatta_id(int regatta_id) {
        this.regatta_id = regatta_id;
    }

    public String getRegatta_nom() {
        return regatta_nom;
    }

    public void setRegatta_nom(String regatta_nom) {
        this.regatta_nom = regatta_nom;
    }

    public Date getRegatta_date() {
        return regatta_date;
    }

    public void setRegatta_date(Date regatta_date) {
        this.regatta_date = regatta_date;
    }

    public Float getRegatta_distance() {
        return regatta_distance;
    }

    public void setRegatta_distance(Float regatta_distance) {
        this.regatta_distance = regatta_distance;
    }

    public String getChallenge_nom() {
        return challenge_nom;
    }

    public void setChallenge_nom(String challenge_nom) {
        this.challenge_nom = challenge_nom;
    }

    public Regatta(int regatta_id, String regatta_nom, Date regatta_date, Float regatta_distance, String challenge_nom) {

        this.regatta_id = regatta_id;
        this.regatta_nom = regatta_nom;
        this.regatta_date = regatta_date;
        this.regatta_distance = regatta_distance;
        this.challenge_nom = challenge_nom;
    }
}
