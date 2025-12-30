package com.krakedev.evaluacion.entidades;

import java.math.BigDecimal;

public class Producto {
	private String idProducto;  
	private String nombre;
	private BigDecimal precioVenta ;
	private BigDecimal precioCompra;
	private Categoria categoria;
	
	//CONSTRUCTOR VACIO
	public Producto() {
		super();
	}
	//CONSTRUCTOR CON PARAMETROS
	public Producto(String idProducto, String nombre, BigDecimal precioVenta, BigDecimal precioCompra,
			Categoria categoria) {
		super();
		this.idProducto = idProducto;
		this.nombre = nombre;
		this.precioVenta = precioVenta;
		this.precioCompra = precioCompra;
		this.categoria = categoria;
	}
	
	//METODOS GET Y SET
	public String getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(String idProducto) {
		this.idProducto = idProducto;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public BigDecimal getPrecioVenta() {
		return precioVenta;
	}
	public void setPrecioVenta(BigDecimal precioVenta) {
		this.precioVenta = precioVenta;
	}
	public BigDecimal getPrecioCompra() {
		return precioCompra;
	}
	public void setPrecioCompra(BigDecimal precioCompra) {
		this.precioCompra = precioCompra;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	//METODO TO STRING 
	@Override
	public String toString() {
		return "Producto [idProducto=" + idProducto + ", nombre=" + nombre + ", precioVenta=" + precioVenta
				+ ", precioCompra=" + precioCompra + ", categoria=" + categoria + "]";
	}
	
}
