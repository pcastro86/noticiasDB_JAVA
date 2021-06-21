package com.noticias.noticiasV1.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Frase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_frase;
    private String frase;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "personaje", referencedColumnName = "id_personaje")
    private Personaje personaje;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "veredicto", referencedColumnName = "id_veredicto")
    private Veredicto veredicto;

    public int getId_frase() {
        return id_frase;
    }

    public void setId_frase(int id_frase) {
        this.id_frase = id_frase;
    }

    public String getFrase() {
        return frase;
    }

    public void setFrase(String frase) {
        this.frase = frase;
    }

    public Personaje getPersonaje() {
        return personaje;
    }

    public void setPersonaje(Personaje personaje) {
        this.personaje = personaje;
    }

    public Veredicto getVeredicto() {
        return veredicto;
    }

    public void setVeredicto(Veredicto veredicto) {
        this.veredicto = veredicto;
    }


}
