package com.krakedev.evaluacion;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class Directorio {
	private ArrayList<Contacto> contactos;
	private Date fechaModificacion;
	private ArrayList<Contacto> correctos;
	private ArrayList<Contacto> incorrectos;
	
	//CONTRUCTOR POR DEFECTO 
	public Directorio() {
		contactos=new ArrayList<Contacto>();
		correctos=new ArrayList<Contacto>();
		incorrectos=new ArrayList<Contacto>();
		fechaModificacion=new Date();
	}
	
	//DEPURAR 
	public void depurar(){
		Contacto elementoContacto;
		for(int i=0;i<contactos.size();i++) {
			elementoContacto=contactos.get(i);
			if (elementoContacto.getDireccion()==null) {
				incorrectos.add(elementoContacto);
			}else {
				correctos.add(elementoContacto);
			}				
		}	
		contactos.clear();
	}
	
	
	//METODO AGREGAR CONTACTO 
	public boolean agregarContacto(Contacto contacto){
		Contacto contactoEncotrado=buscarPorCedula(contacto.getCedula());
		if(contactoEncotrado==null) {
			contactos.add(contacto);
			fechaModificacion=new Date();
			return true;
		}else {
			return false;
		}

	}
	
	//METODO CONSULTAR ULTIMA MODIFICACION
	public String consultarUltimaModificacion() {
		SimpleDateFormat formato= new SimpleDateFormat("yy/MM/dd HH:mm:ss");
		return formato.format(fechaModificacion);
	}
	
	//METODO BUSCAR POR CEDULA 
	public Contacto buscarPorCedula(String cedulaContacto) {
		Contacto elementoContacto=null;
		Contacto contactoEncontrado=null;
		for(int i=0; i<contactos.size();i++) {
			elementoContacto=contactos.get(i);
			if(elementoContacto.getCedula().equals(cedulaContacto)) {
				contactoEncontrado=elementoContacto;
				break;
			}
		}		
		return contactoEncontrado;
	}
	
	//METODO CONTAR PERDIDOS / SIN DIRECCION 
	public int contarPerdidos(){
		Contacto elementoContacto;
		int contador=0;
		for(int i=0;i<contactos.size();i++) {
			elementoContacto=contactos.get(i);
			if (elementoContacto.getDireccion()==null) {
				contador+=1;
			}
		}		
		
		return contador;
	}

	//METODO CONTAR FIJOS Y ESTEN EN ESTADO C 
	public int contarFijos(){
		Contacto elementoContacto;
		Telefono elementoTelefono;
		int contador=0;
		for(int i=0;i<contactos.size();i++) {
			elementoContacto=contactos.get(i);
			for(int j=0;j<elementoContacto.getTelefonos().size();j++) {
				elementoTelefono=elementoContacto.getTelefonos().get(j);
				if(elementoTelefono.getTipo().equalsIgnoreCase("Convencional") &&
						elementoTelefono.getEstado().equals("C")) {
					contador+=1;
				}
			}
		}		
		
		return contador;
	}
	
	//METODOS GET Y SET

	public ArrayList<Contacto> getContactos() {
		return contactos;
	}

	public void setContactos(ArrayList<Contacto> contactos) {
		this.contactos = contactos;
	}

	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public ArrayList<Contacto> getCorrectos() {
		return correctos;
	}

	public void setCorrectos(ArrayList<Contacto> correctos) {
		this.correctos = correctos;
	}

	public ArrayList<Contacto> getIncorrectos() {
		return incorrectos;
	}

	public void setIncorrectos(ArrayList<Contacto> incorrectos) {
		this.incorrectos = incorrectos;
	}
	
	
	
	
}
