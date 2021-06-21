package com.noticias.noticiasV1.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Fuente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_fuente;
    private String name;

    @OneToOne
    @JoinColumn(name = "canal", referencedColumnName = "id_canal")
    private Canal canal;


    public int getId_fuente() {
        return id_fuente;
    }

    public void setId_fuente(int id_fuente) {
        this.id_fuente = id_fuente;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Canal getCanal() {
        return canal;
    }

    public void setCanal(Canal canal) {
        this.canal = canal;
    }

}
