package com.example.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "specialities")
public class Specialite implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_specialitie")
    private short idSpecialitie;
    @Column(nullable = false, unique = true)
    private String name;

    public Specialite() {
    }

    public Specialite(String name) {
        this.name = name;
    }

    public Specialite(short idSpecialitie, String name) {
        this.idSpecialitie = idSpecialitie;
        this.name = name;
    }

    public short getIdSpecialitie() {
        return idSpecialitie;
    }

    public void setIdSpecialitie(short idSpecialitie) {
        this.idSpecialitie = idSpecialitie;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
