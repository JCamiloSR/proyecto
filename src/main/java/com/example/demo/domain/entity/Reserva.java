package com.example.demo.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Reserva")
public class Reserva {

    @Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombres;
    private String correo;
    private String telefono;
    private String espacio;
    private String cantidad;
    private String hora_inicial;
    private String hora_final;
    private String fecha;
    
    public Reserva() {
    }

    public Reserva(Long id, String nombres, String correo, String telefono, String espacio, String cantidad,
            String hora_inicial, String hora_final, String fecha) {
        this.id = id;
        this.nombres = nombres;
        this.correo = correo;
        this.telefono = telefono;
        this.espacio = espacio;
        this.cantidad = cantidad;
        this.hora_inicial = hora_inicial;
        this.hora_final = hora_final;
        this.fecha = fecha;
    }

    public Long getId() {
        return id;
    }

    public String getNombres() {
        return nombres;
    }

    public String getCorreo() {
        return correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getEspacio() {
        return espacio;
    }

    public String getCantidad() {
        return cantidad;
    }

    public String getHora_inicial() {
        return hora_inicial;
    }

    public String getHora_final() {
        return hora_final;
    }

    public String getFecha() {
        return fecha;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setEspacio(String espacio) {
        this.espacio = espacio;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public void setHora_inicial(String hora_inicial) {
        this.hora_inicial = hora_inicial;
    }

    public void setHora_final(String hora_final) {
        this.hora_final = hora_final;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    } 
    
}
