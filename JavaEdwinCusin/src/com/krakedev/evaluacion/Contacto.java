package com.krakedev.evaluacion;

import java.util.ArrayList;

public class Contacto {
	private String cedula;
	private String nombre;
	private String apellido;
	private Direccion direccion;
	private ArrayList<Telefono> telefonos;
	
	//CONSTRUCTOR CON PARAMETROS
	public Contacto(String cedula, String nombre, String apellido) {
		telefonos=new ArrayList<Telefono>();
		this.cedula = cedula;
		this.nombre = nombre;
		this.apellido = apellido;
	}
	
	//METODO AGREGAR TELEFONO RECIBE UN TELEFONO Y LO AGREGA A LA LISTA DE TELEFONOS
	public void agregarTelefono(Telefono telefono){
		telefonos.add(telefono);
	}
	
	//METODO MOSTRAR TELEFONOS 
	public void mostrarTelefonos(){
		Telefono elementoTelefono;
		
		System.out.println("Telefonos con estados 'C' :");
		for(int i=0; i<telefonos.size();i++) {
			elementoTelefono=telefonos.get(i);
			if (elementoTelefono.getEstado().equals("C")) {
				System.out.println(
						"Numero: "+elementoTelefono.getNumero()
						+", Tipo: "+elementoTelefono.getTipo()
						);
				
			}
		}
		
	}
	
	//METODO MOSTRAR TELEFONOS INCORRECTOS 
	public ArrayList<Telefono> recuperarIncorrectos(){
		Telefono elementoTelefono;
		ArrayList<Telefono> coleccionTelefonosIncorrectos = new ArrayList<Telefono>();
		for(int i=0; i<telefonos.size();i++) {
			elementoTelefono=telefonos.get(i);
			if (elementoTelefono.getEstado().equals("E")) {
				coleccionTelefonosIncorrectos.add(elementoTelefono);
			}
		}
		return coleccionTelefonosIncorrectos;	
	}
	
	//METODO PARA IMPRIMIR INFORMACION DE LOS CLIENTES
	public void imprimir() {
        System.out.println("Informacion del Contacto:");
		if(getDireccion()!=null) {
			System.out.println(
					"Cedula: "+getCedula()
					+"\nNombre: "+getNombre()
					+"\nApellido: "+getApellido()
					+"\nDireccion: "
					+"\n Calle Principal: "+getDireccion().getCallePrincipal()
					+"\n calle Secundaria: "+getDireccion().getCalleSecundaria()
					+"\n"
					);			
		}else {
			System.out.println(
					"Cedula: "+getCedula()
					+"\nNombre: "+getNombre()
					+"\nApellido: "+getApellido()
					+"\nDireccion: NO TIENE ASOCIADA UNA DIRECCION"
					//+"\n Calle Principal: "+getDireccion().getCallePrincipal()
					//+"\n calle Secundaria: "+getDireccion().getCalleSecundaria()
					+"\n"
					);			
		}

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

	public ArrayList<Telefono> getTelefonos() {
		return telefonos;
	}

	public void setTelefonos(ArrayList<Telefono> telefonos) {
		this.telefonos = telefonos;
	}
	
	

}
