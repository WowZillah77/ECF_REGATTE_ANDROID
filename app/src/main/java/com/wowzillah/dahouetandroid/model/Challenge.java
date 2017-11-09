package com.wowzillah.dahouetandroid.model;


import java.util.Date;

/**
 * Created by david on 07/11/17.
 */

public class Challenge {
    private int challenge_id;
    private String challenge_nom;
    private Date challenge_date_debut;
    private Date challenge_date_fin;
    private String challenge_code;

    public int getChallenge_id() {
        return challenge_id;
    }

    public void setChallenge_id(int challenge_id) {
        this.challenge_id = challenge_id;
    }

    public String getChallenge_nom() {
        return challenge_nom;
    }

    public void setChallenge_nom(String challenge_nom) {
        this.challenge_nom = challenge_nom;
    }

    public Date getChallenge_date_debut() {
        return challenge_date_debut;
    }

    public void setChallenge_date_debut(Date challenge_date_debut) {
        this.challenge_date_debut = challenge_date_debut;
    }

    public Date getChallenge_date_fin() {
        return challenge_date_fin;
    }

    public void setChallenge_date_fin(Date challenge_date_fin) {
        this.challenge_date_fin = challenge_date_fin;
    }

    public String getChallenge_code() {
        return challenge_code;
    }

    public void setChallenge_code(String challenge_code) {
        this.challenge_code = challenge_code;
    }

    public Challenge(int challenge_id, String challenge_nom, Date challenge_date_debut, Date challenge_date_fin, String challenge_code) {

        this.challenge_id = challenge_id;
        this.challenge_nom = challenge_nom;
        this.challenge_date_debut = challenge_date_debut;
        this.challenge_date_fin = challenge_date_fin;
        this.challenge_code = challenge_code;
    }
}
