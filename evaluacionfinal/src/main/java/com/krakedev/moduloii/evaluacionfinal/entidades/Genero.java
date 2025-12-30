package com.krakedev.moduloii.evaluacionfinal.entidades;

public class Genero {
	private int id;
	private String nombre;
	
	// CONSTRUCTORES
	public Genero() {
		
	}
	public Genero(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}
	public Genero(String nombre) {
		super();
		this.nombre = nombre;
	}

	// GETTERS Y SETTERS
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	// TO STRING
	@Override
	public String toString() {
		return "Genero [id=" + id + ", nombre=" + nombre + "]";
	}
	
	
}
