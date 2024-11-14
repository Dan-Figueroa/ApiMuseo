package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "artista")
public class Artista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idA;
    private String Nombre;
    private String Apellidos;
    private String Pais;  
    
	public Artista() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Artista(String nombre, String apellidos, String pais) {
		super();
		Nombre = nombre;
		Apellidos = apellidos;
		Pais = pais;
	}
	
	public Integer getIdA() {
		return idA;
	}

	public void setIdA(Integer idA) {
		this.idA = idA;
	}

	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getApellidos() {
		return Apellidos;
	}
	public void setApellidos(String apellidos) {
		Apellidos = apellidos;
	}
	public String getPais() {
		return Pais;
	}
	public void setPais(String pais) {
		Pais = pais;
	}

   
}
