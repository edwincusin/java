package com.krakedev.herencia;

public class Persona {
	private String cedula;
	private String nombre;
	
	//COSNTRUCTOR
	public Persona(String cedula, String nombre) {
		super();
		this.cedula = cedula;
		this.nombre = nombre;
	}
	
	//METODOS GET Y SET
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	// TO STRING SOBREESCRITO DE LA CLASE PADRE 
	@Override
	public String toString() {
		return "Persona [cedula=" + cedula + ", nombre=" + nombre + "]";
	}
	
}
