package com.example.entity;

import javax.persistence.*;

@Entity
@Table(name = "promos")
public class Promo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_promo")
    private short idPromo;
    @Column(name = "promo_period", nullable = false, unique = true)
    private String promoPeriod;

    public Promo() {
    }

    public Promo(String promoPeriod) {
        this.promoPeriod = promoPeriod;
    }

    public Promo(short idPromo, String promoPeriod) {
        this.idPromo = idPromo;
        this.promoPeriod = promoPeriod;
    }

    public short getIdPromo() {
        return idPromo;
    }

    public void setIdPromo(short idPromo) {
        this.idPromo = idPromo;
    }

    public String getPromoPeriod() {
        return promoPeriod;
    }

    public void setPromoPeriod(String promoPeriod) {
        this.promoPeriod = promoPeriod;
    }
}
