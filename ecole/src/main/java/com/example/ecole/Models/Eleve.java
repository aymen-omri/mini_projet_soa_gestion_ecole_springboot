package com.example.ecole.Models;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class Eleve {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id_eleve; 
    private String nom;
    private LocalDate date_naiss;
    private String adresse;
    private String email;
    private int num_tel_eleve;

    @ManyToOne
    @JoinColumn(name = "id_ecole")
    Ecole ecole ; 

    public Eleve(){}

    public Eleve(long id_eleve, String nom, LocalDate date_naiss, String adresse, String email, int num_tel_eleve) {
        this.id_eleve = id_eleve;
        this.nom = nom;
        this.date_naiss = date_naiss;
        this.adresse = adresse;
        this.email = email;
        this.num_tel_eleve = num_tel_eleve;
    }

    

    public long getId_eleve() {
        return id_eleve;
    }

    public void setId_eleve(long id_eleve) {
        this.id_eleve = id_eleve;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public LocalDate getDate_naiss() {
        return date_naiss;
    }

    public void setDate_naiss(LocalDate date_naiss) {
        this.date_naiss = date_naiss;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getNum_tel_eleve() {
        return num_tel_eleve;
    }

    public void setNum_tel_eleve(int num_tel_eleve) {
        this.num_tel_eleve = num_tel_eleve;
    }

    public Ecole getEcole() {
        return ecole;
    }

    public void setEcole(Ecole ecole) {
        this.ecole = ecole;
    }

    
    

}
