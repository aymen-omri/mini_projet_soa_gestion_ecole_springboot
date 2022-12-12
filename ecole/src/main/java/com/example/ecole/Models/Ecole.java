package com.example.ecole.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Ecole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_ecole ; 

    private String nom ; 
    private String adresse ; 
    private int num_tel ;
    private int num_fax;
    private String email;
    
    public Ecole(){}

    public Ecole(long id_ecole, String nom, String adresse, int num_tel, int num_fax, String email) {
        this.id_ecole = id_ecole;
        this.nom = nom;
        this.adresse = adresse;
        this.num_tel = num_tel;
        this.num_fax = num_fax;
        this.email = email;
    }

    public long getId_ecole() {
        return id_ecole;
    }

    public void setId_ecole(long id_ecole) {
        this.id_ecole = id_ecole;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getNum_tel() {
        return num_tel;
    }

    public void setNum_tel(int num_tel) {
        this.num_tel = num_tel;
    }

    public int getNum_fax() {
        return num_fax;
    }

    public void setNum_fax(int num_fax) {
        this.num_fax = num_fax;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    } 

    


    
}
