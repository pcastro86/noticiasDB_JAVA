package com.noticias.noticiasV1.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Veredicto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_veredicto;
    private String veredicto;

    public int getId_veredicto() {
        return id_veredicto;
    }

    public void setId_veredicto(int id_veredicto) {
        this.id_veredicto = id_veredicto;
    }

    public String getVeredicto() {
        return veredicto;
    }

    public void setVeredicto(String veredicto) {
        this.veredicto = veredicto;
    }
}
