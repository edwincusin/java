package com.krakedev.evaluacion;

public class Contacto {
	private String cedula;
	private String nombre;
	private String apellido;
	private Direccion direccion;
	
	//CONSTRUCTOR CON PARAMETROS
	public Contacto(String cedula, String nombre, String apellido) {
		this.cedula = cedula;
		this.nombre = nombre;
		this.apellido = apellido;
	}
	
	//METODO PARA IMPRIMIR INFORMACION DE LOS CLIENTES
	public void imprimir() {
		System.out.println(
				"Cedula: "+getCedula()
				+"\nNombre: "+getNombre()
				+"\nApellido: "+getApellido()
				+"\nDireccion: "
				+"\n Calle Principal: "+getDireccion().getCallePrincipal()
				+"\n calle Secundaria: "+getDireccion().getCalleSecundaria()
				+"\n"
				);
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

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}
	
	

}
