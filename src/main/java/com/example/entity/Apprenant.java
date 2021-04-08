package com.example.entity;

import javax.persistence.*;

@Entity @Table(name = "apprenants")
@PrimaryKeyJoinColumn( name = "id_person" )
public class Apprenant extends Person {
    @OneToOne
    @JoinColumn(name = "id_classe", nullable = false)
    private Classe classe;
    @OneToOne
    @JoinColumn(name = "id_specialite", nullable = false)
    private Specialite specialite;
    @OneToOne
    @JoinColumn(name = "id_promo", nullable = false)
    private Promo promo;

    public Apprenant() {
    }

    public Apprenant(Classe classe, Specialite specialite, Promo promo) {
        this.classe = classe;
        this.specialite = specialite;
        this.promo = promo;
    }

    public Apprenant(String firstName, String lastName, String phoneNumber, Role role, String email, String password, Classe classe, Specialite specialite, Promo promo) {
        super(firstName, lastName, phoneNumber, role, email, password);
        this.classe = classe;
        this.specialite = specialite;
        this.promo = promo;
    }

    public Apprenant(Long idUser, String firstName, String lastName, String phoneNumber, Role role, String email, String password, Classe classe, Specialite specialite, Promo promo) {
        super(idUser, firstName, lastName, phoneNumber, role, email, password);
        this.classe = classe;
        this.specialite = specialite;
        this.promo = promo;
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

    public Promo getPromo() {
        return promo;
    }

    public void setPromo(Promo promo) {
        this.promo = promo;
    }
}
