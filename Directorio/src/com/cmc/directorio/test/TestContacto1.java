package com.cmc.directorio.test;
import com.cmc.directorio.entidades.Contactos;
import com.cmc.directorio.entidades.Telefono;

public class TestContacto1 {

	public static void main(String[] args) {
		Telefono telef=new Telefono("movi","0961918927", 20);
		Contactos c=new Contactos("Daniela","Loor", telef, 55.2);
		
		
		System.out.println(
				"\nNombre      : "+c.getNombre()
				+"\nApellido   : "+c.getApellido()
				+"\nOperadora  : "+c.getTelefono().getOperadora()
				+"\nNumero Telf: "+c.getTelefono().getNumero()
				+"\nPeso       : "+c.getPeso()
				+"\n\n"
				);
		
		
		
		
	}

}
