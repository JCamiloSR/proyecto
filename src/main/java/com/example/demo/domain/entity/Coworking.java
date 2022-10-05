package com.example.demo.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "Coworking")
public class Coworking {

    @Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String descripcion;
    private String media;
    
    public Coworking() {
    }

    public Coworking(Long id, String titulo, String descripcion, String media) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.media = media;
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getMedia() {
        return media;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setMedia(String media) {
        this.media = media;
    }
    
    // @JoinColumn(name = "FK_Usuario", nullable = false, updatable = false)
    // @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    // private Usuario usuario;
    
}
