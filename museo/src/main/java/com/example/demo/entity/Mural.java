package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Mural {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idM;  
    private String Titulo;
    private String Autor; 
    private String Dimensiones; 
    private String Materiales;
    private Double Rating;
    @ManyToOne
    @JoinColumn(name = "idA", referencedColumnName = "idA")
    
    private Artista artista;
	public Mural() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Mural(Integer idM, String titulo, String autor, String dimensiones, String materiales, Double rating,
			Artista artista) {
		super();
		this.idM = idM;
		Titulo = titulo;
		Autor = autor;
		Dimensiones = dimensiones;
		Materiales = materiales;
		Rating = rating;
		this.artista = artista;
	}
	public Integer getIdM() {
		return idM;
	}
	public void setIdM(Integer idM2) {
		this.idM = idM2;
	}
	public String getTitulo() {
		return Titulo;
	}
	public void setTitulo(String titulo) {
		Titulo = titulo;
	}
	public String getAutor() {
		return Autor;
	}
	public void setAutor(String autor) {
		Autor = autor;
	}
	public String getDimensiones() {
		return Dimensiones;
	}
	public void setDimensiones(String dimensiones) {
		Dimensiones = dimensiones;
	}
	public String getMateriales() {
		return Materiales;
	}
	public void setMateriales(String materiales) {
		Materiales = materiales;
	}
	public Double getRating() {
		return Rating;
	}
	public void setRating(Double rating) {
		Rating = rating;
	}
	public Artista getArtista() {
		return artista;
	}
	public void setArtista(Artista artista) {
		this.artista = artista;
	}

    

    
}
