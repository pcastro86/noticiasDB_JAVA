package com.noticias.noticiasV1.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Canal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_canal;
    private String name;


    public int getId_canal() {
        return id_canal;
    }

    public void setId_canal(int id_canal) {
        this.id_canal = id_canal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
