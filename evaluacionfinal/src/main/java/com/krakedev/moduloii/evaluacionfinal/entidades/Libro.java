package com.krakedev.moduloii.evaluacionfinal.entidades;

public class Libro {
	private int id;
	private String titulo;
	private int id_autor;
	private int id_genero;
	private int anio_publicacion;
	private boolean estado_disponible;
	
	// CONSTRUCTORES
	public Libro() {
		
	}

	public Libro(int id, String titulo, int id_autor, int id_genero, int anio_publicacion, boolean estado_disponible) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.id_autor = id_autor;
		this.id_genero = id_genero;
		this.anio_publicacion = anio_publicacion;
		this.estado_disponible = estado_disponible;
	}

	public Libro(String titulo, int id_autor, int id_genero, int anio_publicacion, boolean estado_disponible) {
		super();
		this.titulo = titulo;
		this.id_autor = id_autor;
		this.id_genero = id_genero;
		this.anio_publicacion = anio_publicacion;
		this.estado_disponible = estado_disponible;
	}

	// GETTERS Y SETTERS
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public int getId_autor() {
		return id_autor;
	}
	public void setId_autor(int id_autor) {
		this.id_autor = id_autor;
	}
	public int getId_genero() {
		return id_genero;
	}
	public void setId_genero(int id_genero) {
		this.id_genero = id_genero;
	}
	public int getAnio_publicacion() {
		return anio_publicacion;
	}
	public void setAnio_publicacion(int anio_publicacion) {
		this.anio_publicacion = anio_publicacion;
	}
	public boolean isEstado_disponible() {
		return estado_disponible;
	}
	public void setEstado_disponible(boolean estado_disponible) {
		this.estado_disponible = estado_disponible;
	}
	
	// TO STRING
	@Override
	public String toString() {
		return "Libro [id=" + id + ", titulo=" + titulo + ", id_autor=" + id_autor + ", id_genero=" + id_genero
				+ ", anio_publicacion=" + anio_publicacion + ", estado_disponible=" + estado_disponible + "]";
	}
	
}
