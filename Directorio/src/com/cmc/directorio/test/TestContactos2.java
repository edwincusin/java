package com.cmc.directorio.test;

import com.cmc.directorio.entidades.AdminContactos;
import com.cmc.directorio.entidades.Contactos;
import com.cmc.directorio.entidades.Telefono;

public class TestContactos2 {

	public static void main(String[] args) {
		Telefono telf1=new Telefono("claro", "0961918927",21,true);
		Contactos contacto1=new Contactos("Daniel", "Csn", telf1,72.4);
		
		Telefono telf2=new Telefono("movi", "0961918927",21,true);
		Contactos contacto2=new Contactos("Amelia", "Taco", telf2,42.4);
		
		AdminContactos ac=new AdminContactos();
		
		Contactos masPesado=ac.buscarMasPesado(contacto1, contacto2);
		
		boolean resultadoCompararOperadora=ac.compararOperadoras(contacto1, contacto2);
		
		System.out.println(
				"\n**************CONTACTO CON MAS PESO****************"
				+"\nNombre       :  "+masPesado.getNombre()
				+"\nApellido     :  "+masPesado.getApellido()
				+"\nOperadora    :  "+masPesado.getTelefono().getOperadora()
				+"\n#Telefono    :  "+masPesado.getTelefono().getNumero()
				+"\nPeso         :  "+masPesado.getPeso()
				+"\n\n"
				);
		
		System.out.println(
				"\n**************COMPARACION DE OPERADORAS****************"
				+"\nSON DE LA MISMA OPERADORA: "+resultadoCompararOperadora
				+"\n"
				);
	}

}
