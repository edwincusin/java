package com.cmc.evaluacion.entidades;

import java.util.ArrayList;

public class Cliente {
	private String cedula;
	private String nombre;
	private String apellido;
	private ArrayList<Prestamo> prestamos;

	//CONSTRUCTOR CON PARAMETROS
	public Cliente(String cedula, String nombre, String apellido) {
		prestamos=new ArrayList<Prestamo>();
		this.cedula = cedula;
		this.nombre = nombre;
		this.apellido = apellido;
	}
	
	//METODO MOSTRAR CLIENTES
	public void mostrarCliente() {
		System.out.println(
				" "+getNombre()+" "+getApellido()
				+" ["
				+"CEDULA : "+getCedula()
				+", NOMBRE: "+getNombre()
				+",  APELLIDO : "+getApellido()
				+"]"
				);
		System.out.println();
	}

//METODOS GET Y SET 
	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public ArrayList<Prestamo> getPrestamos() {
		return prestamos;
	}



}
