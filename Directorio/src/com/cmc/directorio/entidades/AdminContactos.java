package com.cmc.directorio.entidades;

public class AdminContactos {
	
	public Contactos buscarMasPesado(Contactos contacto1,Contactos contacto2) {
		
		if(contacto1.getPeso() > contacto2.getPeso()) {
			return contacto1;
		}else if (contacto1.getPeso() < contacto2.getPeso()) {
			return contacto2;
		}else {
			return null;
		}

	}
	
	
	public boolean compararOperadoras(Contactos contacto1,Contactos contacto2) {
		if(contacto1.getTelefono().getOperadora().equals(contacto2.getTelefono().getOperadora())) {
			return true;
		}else {
			return false;
		}
	}
	
	
	public void activarUsuario(Contactos contacto) {
		if(contacto.getTelefono().isTieneWsp()==true) {
			contacto.setActivo(false);
		}
	}
	
}
