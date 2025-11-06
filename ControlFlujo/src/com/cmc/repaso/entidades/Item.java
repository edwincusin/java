package com.cmc.repaso.entidades;

public class Item {
	String nombre;
	private int productosActuales;
	private int productosDevueltos;
	private int productosVendidos;
	
	//metodo imprimir
	public void imprimir() {
		System.out.println(
				"\n-----------VALORES----------"
				+"\nNOMBRE              : "+nombre
				+"\nPRODUCTOS ACTUALES  : "+productosActuales
				+"\nPRODUCTOS DEVUELTOS : "+productosDevueltos
				+"\nPRODCUTOS VENDIDOS  : "+productosVendidos
				);
	}
	
	
	//metodo vender 
	public void vender(int productosVendidos) {
		this.productosVendidos+=productosVendidos;
		productosActuales-=productosVendidos;
	}
	
	//metodo devolver
	public void devolver(int productosVendidos) {
		productosActuales+=productosVendidos;
		this.productosVendidos-=productosVendidos;
		productosDevueltos+=productosVendidos;
	}	
	

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getProductosActuales() {
		return productosActuales;
	}

	public void setProductosActuales(int productosActuales) {
		this.productosActuales = productosActuales;
	}

	public int getProductosDevueltos() {
		return productosDevueltos;
	}

	public void setProductosDevueltos(int productosDevueltos) {
		this.productosDevueltos = productosDevueltos;
	}

	public int getProductosVendidos() {
		return productosVendidos;
	}

	public void setProductosVendidos(int productosVendidos) {
		this.productosVendidos = productosVendidos;
	}
	
	
	
	
	
	
	
	
}
