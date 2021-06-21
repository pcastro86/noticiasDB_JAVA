package com.noticias.noticiasV1.models;

import javax.persistence.*;

@Entity
public class Personaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_personaje;
    private String name;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "partido", referencedColumnName = "id_partido")
    private Partido partido;

    public int getId_personaje() {
        return id_personaje;
    }

    public void setId_personaje(int id_personaje) {
        this.id_personaje = id_personaje;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Partido getPartido() {
        return partido;
    }

    public void setPartido(Partido partido) {
        this.partido = partido;
    }
}
