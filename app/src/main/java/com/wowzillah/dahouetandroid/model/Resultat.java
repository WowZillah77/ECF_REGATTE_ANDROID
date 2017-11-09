package com.wowzillah.dahouetandroid.model;

/**
 * Created by david on 08/11/17.
 */

public class Resultat {
    private String resultat_temp_reel;
    private String temp_compose;
    private String resultat_position;
    private String regatta_nom;
    private String bateau_nom;
    private String bateau_voile;
    private String personne_nom;
    private String personne_prenom;
    private String club_nom;
    private String classe_name;
    private String serie_nom;
    private int regatte_id;

    public String getResultat_temp_reel() {
        return resultat_temp_reel;
    }

    public void setResultat_temp_reel(String resultat_temp_reel) {
        this.resultat_temp_reel = resultat_temp_reel;
    }

    public String getTemp_compose() {
        return temp_compose;
    }

    public void setTemp_compose(String temp_compose) {
        this.temp_compose = temp_compose;
    }

    public String getResultat_position() {
        return resultat_position;
    }

    public void setResultat_position(String resultat_position) {
        this.resultat_position = resultat_position;
    }

    public String getRegatta_nom() {
        return regatta_nom;
    }

    public void setRegatta_nom(String regatta_nom) {
        this.regatta_nom = regatta_nom;
    }

    public String getBateau_nom() {
        return bateau_nom;
    }

    public void setBateau_nom(String bateau_nom) {
        this.bateau_nom = bateau_nom;
    }

    public String getBateau_voile() {
        return bateau_voile;
    }

    public void setBateau_voile(String bateau_voile) {
        this.bateau_voile = bateau_voile;
    }

    public String getPersonne_nom() {
        return personne_nom;
    }

    public void setPersonne_nom(String personne_nom) {
        this.personne_nom = personne_nom;
    }

    public String getPersonne_prenom() {
        return personne_prenom;
    }

    public void setPersonne_prenom(String personne_prenom) {
        this.personne_prenom = personne_prenom;
    }

    public String getClub_nom() {
        return club_nom;
    }

    public void setClub_nom(String club_nom) {
        this.club_nom = club_nom;
    }

    public String getClasse_nom() {
        return classe_name;
    }

    public void setClasse_nom(String classe_nom) {
        this.classe_name = classe_nom;
    }

    public String getSerie_nom() {
        return serie_nom;
    }

    public void setSerie_nom(String serie_nom) {
        this.serie_nom = serie_nom;
    }

    public int getRegatte_id() {
        return regatte_id;
    }

    public void setRegatte_id(int regatte_id) {
        this.regatte_id = regatte_id;
    }

    public Resultat(String resultat_temp_reel, String temp_compose, String resultat_position, String regatta_nom, String bateau_nom, String bateau_voile, String personne_nom, String personne_prenom, String club_nom, String classe_nom, String serie_nom, int regatte_id) {

        this.resultat_temp_reel = resultat_temp_reel;
        this.temp_compose = temp_compose;
        this.resultat_position = resultat_position;
        this.regatta_nom = regatta_nom;
        this.bateau_nom = bateau_nom;
        this.bateau_voile = bateau_voile;
        this.personne_nom = personne_nom;
        this.personne_prenom = personne_prenom;
        this.club_nom = club_nom;
        this.classe_name = classe_nom;
        this.serie_nom = serie_nom;
        this.regatte_id = regatte_id;
    }
}
