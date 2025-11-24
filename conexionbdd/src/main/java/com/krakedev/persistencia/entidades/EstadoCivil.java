package com.krakedev.persistencia.entidades;

public class EstadoCivil {
	private String codigo;
	private String descripcion;
	//CONSTRUCTOR VACIO
	public EstadoCivil() {
	}	
	//CONSTRUCTOR CON PARAMETROS
	public EstadoCivil(String codigo, String descripcion) {
		super();
		this.codigo = codigo;
		this.descripcion = descripcion;
	}
	
	//METODOS GET Y SET
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	//METODO TO STRING PARA RETORNO CON FORMATO LKOS DATOS DEL OBJETO
	@Override
	public String toString() {
		return "EstadoCivil [codigo=" + codigo + ", descripcion=" + descripcion + "]";
	}
	
	
	
}
