package com.krakedev.repasoii.entidades;

public class Libro {
	private int idlibro;
	private String titulo;
	private Autor autor;
	private	Genero genero;
	private	int anioPublicacion;
	private boolean estadoDisponibilidad;
	public Libro() {
	}
	
	
	public Libro(int idlibro, String titulo, Autor autor, Genero genero, int anioPublicacion,
			boolean estadoDisponibilidad) {
		super();
		this.idlibro = idlibro;
		this.titulo = titulo;
		this.autor = autor;
		this.genero = genero;
		this.anioPublicacion = anioPublicacion;
		this.estadoDisponibilidad = estadoDisponibilidad;
	}


	public int getIdlibro() {
		return idlibro;
	}

	public void setIdlibro(int idlibro) {
		this.idlibro = idlibro;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public int getAnioPublicacion() {
		return anioPublicacion;
	}

	public void setAnioPublicacion(int anioPublicacion) {
		this.anioPublicacion = anioPublicacion;
	}

	public boolean isEstadoDisponibilidad() {
		return estadoDisponibilidad;
	}

	public void setEstadoDisponibilidad(boolean estadoDisponibilidad) {
		this.estadoDisponibilidad = estadoDisponibilidad;
	}


	@Override
	public String toString() {
		return "\n Libro [idlibro=" + idlibro + ", titulo=" + titulo + ", autor=" + autor + ", genero=" + genero
				+ ", anioPublicacion=" + anioPublicacion + ", estadoDisponibilidad=" + estadoDisponibilidad + "]";
	}
	
	
	
	
	
}
