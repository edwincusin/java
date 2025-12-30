package com.krakedev.moduloii.evaluacionfinal.entidades;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Autor {
	private int id;
	private String nombre;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date fecha_nacimiento;
	private String nacionalidad;
	
	// CONSTRUCTORES
	public Autor() {
		
	}
	
	public Autor(int id, String nombre, Date fecha_nacimiento, String nacionalidad) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.fecha_nacimiento = fecha_nacimiento;
		this.nacionalidad = nacionalidad;
	}

	public Autor(String nombre, Date fecha_nacimiento, String nacionalidad) {
		super();
		this.nombre = nombre;
		this.fecha_nacimiento = fecha_nacimiento;
		this.nacionalidad = nacionalidad;
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
	public Date getFecha_nacimiento() {
		return fecha_nacimiento;
	}
	public void setFecha_nacimiento(Date fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}
	public String getNacionalidad() {
		return nacionalidad;
	}
	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	
	// TO STRING
	@Override
	public String toString() {
		return "Autor [id=" + id + ", nombre=" + nombre + ", fecha_nacimiento=" + fecha_nacimiento + ", nacionalidad="
				+ nacionalidad + "]";
	}
}
