package com.krakedev.evaluacion.entidades;

public class Categoria {
	private String idCategoria;
	private String nombre;
	
	//CONSTRUCTOR VACIO
	public Categoria() {
	}
	//CONSTRUCTOR CON PARAMETROS
	public Categoria(String idCategoria, String nombre) {
		super();
		this.idCategoria = idCategoria;
		this.nombre = nombre;
	}
	
	//METODOS GET Y SET 
	public String getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(String idCategoria) {
		this.idCategoria = idCategoria;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	//METODO TOSTRING MODIFICADO
	@Override
	public String toString() {
		return "\n Categoria [idCategoria=" + idCategoria + ", nombre=" + nombre + "]";
	}
}
