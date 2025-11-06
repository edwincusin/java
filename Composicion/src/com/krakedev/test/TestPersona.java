package com.krakedev.test;

import com.krakedev.composicion.Direccion;
import com.krakedev.composicion.Persona;

public class TestPersona {

	public static void main(String[] args) {
		Persona p1 = new Persona();
		//SETEAR 
		p1.setNombre("EDWIN");
		p1.setApellido("CUSIN");
		
		Direccion dir=new Direccion();
		dir.setCallePrincipal("AV. MARIANA JESUS");
		dir.setCalleSecundaria("San Vicente");
		dir.setNumero("O6-32");		
		p1.setDireccion(dir);
				
		
		String nombre = p1.getNombre();
		Direccion d1=p1.getDireccion();
		
		System.out.println(nombre);
		System.out.println(d1.getCallePrincipal());
		
		p1.imprimir();
		
		Persona p2 = new Persona();
		Direccion d2=new Direccion("AV CALLUMA", "CALLE RICARDO DES", "OE125");
		p2.setNombre("GEOVANY");
		p2.setApellido("ANT");
		p2.setDireccion(d2);
		p2.imprimir();
		
		
		Persona p3 = new Persona();
		p3.setDireccion(new Direccion("las casas", "MERCEDES", "OE1111"));
		p3.imprimir();
		
	}

}
