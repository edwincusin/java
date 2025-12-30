package com.krakedev.repasoii.entidades;

import java.util.Date;

public class Autor {
	private int idAutor;
	private String nombre;
	private	Date fechaNacimiento;
	private String nacionalidad;
	
	public Autor() {
	}
	
	
	public Autor(int idAutor, String nombre, Date fechaNacimiento, String nacionalidad) {
		super();
		this.idAutor = idAutor;
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
		this.nacionalidad = nacionalidad;
	}
	
	
	
	public int getIdAutor() {
		return idAutor;
	}
	public void setIdAutor(int idAutor) {
		this.idAutor = idAutor;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public String getNacionalidad() {
		return nacionalidad;
	}
	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	
	
	
	@Override
	public String toString() {
		return "\n Autor [idAutor=" + idAutor + ", nombre=" + nombre + ", fechaNacimiento=" + fechaNacimiento
				+ ", nacionalidad=" + nacionalidad + "]";
	}
	
	
	
	
}
