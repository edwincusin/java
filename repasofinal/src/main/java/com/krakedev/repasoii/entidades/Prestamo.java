package com.krakedev.repasoii.entidades;

import java.util.Date;

public class Prestamo {
	private int idPrestamo;
	private Libro libro;
	private	String usuario;
	private Date fechaPrestamo;
	private Date fechaDevolucion;
	
	public Prestamo() {
	}
	
	public Prestamo(int idPrestamo, Libro libro, String usuario, Date fechaPrestamo, Date fechaDevolucion) {
		super();
		this.idPrestamo = idPrestamo;
		this.libro = libro;
		this.usuario = usuario;
		this.fechaPrestamo = fechaPrestamo;
		this.fechaDevolucion = fechaDevolucion;
	}

	public int getIdPrestamo() {
		return idPrestamo;
	}

	public void setIdPrestamo(int idPrestamo) {
		this.idPrestamo = idPrestamo;
	}

	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public Date getFechaPrestamo() {
		return fechaPrestamo;
	}

	public void setFechaPrestamo(Date fechaPrestamo) {
		this.fechaPrestamo = fechaPrestamo;
	}

	public Date getFechaDevolucion() {
		return fechaDevolucion;
	}

	public void setFechaDevolucion(Date fechaDevolucion) {
		this.fechaDevolucion = fechaDevolucion;
	}

	@Override
	public String toString() {
		return "\n \n Prestamo [ idPrestamo=" + idPrestamo + ", libro=" + libro + ", usuario=" + usuario + ", fechaPrestamo="
				+ fechaPrestamo + ", fechaDevolucion=" + fechaDevolucion + "]";
	}
	
}
