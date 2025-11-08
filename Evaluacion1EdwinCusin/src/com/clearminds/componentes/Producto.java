package com.clearminds.componentes;

public class Producto {
	private String nombre;
	private double precio;
	private String codigo;

	//CONSTRUCTOR
	public Producto(String nombre, String codigo,double precio) {
		this.nombre = nombre;
		this.precio = precio;
		this.codigo = codigo;
	}

	
	// METODO INCREMENTAR PRECIO
	public void incrementarPrecio(int porcentaje) {
		double valorIncrementar=(this.precio*porcentaje)/100;
		this.precio+=valorIncrementar;
	}


	// METODO DISMINUIR PRECIO
	public void disminuirPrecio(double valorDescuento) {
		this.precio-=valorDescuento;
	}

	// METODOS GET Y SET
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
