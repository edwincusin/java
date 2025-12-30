package com.krakedev.moduloii.evaluacionfinal.entidades;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Prestamo {
	private int id;
	private int id_libro;
	private String usuario;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date fecha_prestamo;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date fecha_devolucion;
	
	// CONSTRUCTORES
	public Prestamo() {
		
	}
	
	public Prestamo(int id, int id_libro, String usuario, Date fecha_prestamo, Date fecha_devolucion) {
		super();
		this.id = id;
		this.id_libro = id_libro;
		this.usuario = usuario;
		this.fecha_prestamo = fecha_prestamo;
		this.fecha_devolucion = fecha_devolucion;
	}
	
	public Prestamo(int id_libro, String usuario, Date fecha_prestamo, Date fecha_devolucion) {
		super();
		this.id_libro = id_libro;
		this.usuario = usuario;
		this.fecha_prestamo = fecha_prestamo;
		this.fecha_devolucion = fecha_devolucion;
	}
	
	public Prestamo(String usuario, Date fecha_prestamo, Date fecha_devolucion) {
		super();
		this.usuario = usuario;
		this.fecha_prestamo = fecha_prestamo;
		this.fecha_devolucion = fecha_devolucion;
	}

	// GETTERS Y SETTERS
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId_libro() {
		return id_libro;
	}
	public void setId_libro(int id_libro) {
		this.id_libro = id_libro;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public Date getFecha_prestamo() {
		return fecha_prestamo;
	}
	public void setFecha_prestamo(Date fecha_prestamo) {
		this.fecha_prestamo = fecha_prestamo;
	}
	public Date getFecha_devolucion() {
		return fecha_devolucion;
	}
	public void setFecha_devolucion(Date fecha_devolucion) {
		this.fecha_devolucion = fecha_devolucion;
	}
	
	// TO STRING
	@Override
	public String toString() {
		return "Prestamo [id=" + id + ", id_libro=" + id_libro + ", usuario=" + usuario + ", fecha_prestamo="
				+ fecha_prestamo + ", fecha_devolucion=" + fecha_devolucion + "]";
	}
	
}
