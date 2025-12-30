package com.krakedev.evaluacion.entidades;

import java.util.Date;

public class HistorialMovimiento {
	private int idHistorialMovimientos;
	private Producto producto;
	private int cantidad;
	private Date fechaMovimiento;
	
	//CONSTRUCTOR VACIO
	public HistorialMovimiento() {
		super();
	}
	//CONSTRUCTOR CON PARAMETROS
	public HistorialMovimiento(int idHistorialMovimientos, Producto producto, int cantidad, Date fechaMovimiento) {
		super();
		this.idHistorialMovimientos = idHistorialMovimientos;
		this.producto = producto;
		this.cantidad = cantidad;
		this.fechaMovimiento = fechaMovimiento;
	}
	
	//METODOS GET Y SET
	public int getIdHistorialMovimientos() {
		return idHistorialMovimientos;
	}
	public void setIdHistorialMovimientos(int idHistorialMovimientos) {
		this.idHistorialMovimientos = idHistorialMovimientos;
	}
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public Date getFechaMovimiento() {
		return fechaMovimiento;
	}
	public void setFechaMovimiento(Date fechaMovimiento) {
		this.fechaMovimiento = fechaMovimiento;
	}
	
	// METODO TO STRING
	@Override
	public String toString() {
		return "HistorialMovimiento [idHistorialMovimientos=" + idHistorialMovimientos + ", producto=" + producto
				+ ", cantidad=" + cantidad + ", fechaMovimiento=" + fechaMovimiento + "]";
	}	
}
