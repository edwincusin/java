package com.krakedev.repasoii.entidades;

public class Genero {
	private int idGenero;
	private String nombre;
	//CONSTRUCTOR SIN PARAMETROS
	public Genero() {
	}
	//CONSTRUCTOR CON PARAMETROS
	public Genero(int idGenero, String nombre) {
		super();
		this.idGenero = idGenero;
		this.nombre = nombre;
	}
	//METODOS GET Y SET
	public int getIdGenero() {
		return idGenero;
	}
	public void setIdGenero(int idGenero) {
		this.idGenero = idGenero;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	//METODO TO STRING
	@Override
	public String toString() {
		return "Genero [idGenero=" + idGenero + ", nombre=" + nombre + "]";
	}
	
	
	
	
}
