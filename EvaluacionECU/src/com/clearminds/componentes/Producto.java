package com.clearminds.componentes;

public class Producto {
	private String nombre;
	private double precio;
	private String codigo;
	
	//CONSTRUCTOR 
	public Producto(String codigo, String nombre, double precio) {
		this.nombre=nombre;
		this.codigo=codigo;
		this.precio=precio;
	}
	
	//METODO PARA INCREMENTAR PRECIO 
	public void incrementarPrecio(int porcentaje) {
		double valorIncremento=(precio*porcentaje)/100;
		precio+=valorIncremento;
	}
	
	//METODO PARA DISMINUIR PRECIO 
	public void disminuirPrecio(double descuento) {
		double valorDisminuir=(precio*descuento)/100;
		precio-=valorDisminuir;
	}

	
	//METODOS GET Y SET
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	
	
}
