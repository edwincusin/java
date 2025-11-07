package com.cmc.directorio.test;
import com.cmc.directorio.entidades.AdminContactos;
import com.cmc.directorio.entidades.Contactos;
import com.cmc.directorio.entidades.Telefono;

public class TestActivos {

	public static void main(String[] args) {
		Telefono telf1=new Telefono("claro", "0961918927",21,false);
		Contactos contacto1=new Contactos("Daniel", "Csn", telf1,72.4);
		
		System.out.println(
				"\n**************INFORMACION CONTACTO****************"
				+"\nNombre       :  "+contacto1.getNombre()
				+"\nApellido     :  "+contacto1.getApellido()
				+"\nOperadora    :  "+contacto1.getTelefono().getOperadora()
				+"\n#Telefono    :  "+contacto1.getTelefono().getNumero()
				+"\nTiene WSP    :  "+contacto1.getTelefono().isTieneWsp()
				+"\nActivo       :  "+contacto1.isActivo()
				+"\nPeso         :  "+contacto1.getPeso()
				+"\n\n"
				);

		
		telf1.setTieneWsp(true);
		AdminContactos ac=new AdminContactos();
		ac.activarUsuario(contacto1);

		
		System.out.println(
				"\n**************INFORMACION CONTACTO****************"
				+"\nNombre       :  "+contacto1.getNombre()
				+"\nApellido     :  "+contacto1.getApellido()
				+"\nOperadora    :  "+contacto1.getTelefono().getOperadora()
				+"\n#Telefono    :  "+contacto1.getTelefono().getNumero()
				+"\nTiene WSP    :  "+contacto1.getTelefono().isTieneWsp()
				+"\nActivo       :  "+contacto1.isActivo()
				+"\nPeso         :  "+contacto1.getPeso()
				+"\n\n"
				);
	}

}
