package com.example.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "classes")
public class Classe implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_classe")
    private short idClasse;
    @Column(nullable = false, unique = true)
    private String name;

    public Classe() {
    }

    public Classe(String name) {
        this.name = name;
    }

    public Classe(short idClasse, String name) {
        this.idClasse = idClasse;
        this.name = name;
    }

    public short getIdClasse() {
        return idClasse;
    }

    public void setIdClasse(short idClasse) {
        this.idClasse = idClasse;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
