package com.example.entity;

import javax.persistence.*;

@Entity @Table(name = "formateurs")
@PrimaryKeyJoinColumn( name = "id_person" )
public class Formateur extends Person {
    @OneToOne
    @JoinColumn(name = "id_classe", nullable = false)
    private Classe classe;
    @OneToOne
    @JoinColumn(name = "id_specialite", nullable = false)
    private Specialite specialite;

    public Formateur() {
    }

    public Formateur(Classe classe, Specialite specialite) {
        this.classe = classe;
        this.specialite = specialite;
    }

    public Formateur(String firstName, String lastName, String phoneNumber, String email, String password, Classe classe, Specialite specialite) {
        super(firstName, lastName, phoneNumber, email, password);
        this.classe = classe;
        this.specialite = specialite;
    }

    public Formateur(String firstName, String lastName, String phoneNumber, Role role, String email, String password, Classe classe, Specialite specialite) {
        super(firstName, lastName, phoneNumber, role, email, password);
        this.classe = classe;
        this.specialite = specialite;
    }

    public Formateur(Long idUser, String firstName, String lastName, String phoneNumber, Role role, String email, String password, Classe classe, Specialite specialite) {
        super(idUser, firstName, lastName, phoneNumber, role, email, password);
        this.classe = classe;
        this.specialite = specialite;
    }

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }

    public Specialite getSpecialite() {
        return specialite;
    }

    public void setSpecialite(Specialite specialite) {
        this.specialite = specialite;
    }
}
