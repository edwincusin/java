package com.cmc.repaso.entidades;

public class Producto {
	private String nombre;
	private double precio;
	
	//constructor 
	public Producto(String nombre, double precio) {
		this.nombre=nombre;
		this.precio=precio;
	}

	//metodos get  y set
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
		
		if(precio < 0) {
			this.precio = precio*-1;
		}else {
			this.precio = precio;
		}
	}
	
	//metodo calcular precio proomo
	public double calcularPrecioPromo(int porcentajeDescuento) {
		double precioConDescuento=precio-((precio*porcentajeDescuento)/100);
	    return precioConDescuento;
	}

	
	
}
