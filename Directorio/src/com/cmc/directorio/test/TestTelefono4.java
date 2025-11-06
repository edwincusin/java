package com.cmc.directorio.test;

import com.cmc.directorio.entidades.AdminTelefono;
import com.cmc.directorio.entidades.Telefono;

public class TestTelefono4 {

	public static void main(String[] args) {
		Telefono telf1=new Telefono("movi","098234234", 20);
		Telefono telf2=new Telefono("claro","098234234", 5);
		Telefono telf3=new Telefono("claro","098234234", 10);
		Telefono telf4=new Telefono("claro","098234234", 10);
		
		AdminTelefono at=new AdminTelefono();
		int contarClaro=at.contarClaro(telf1, telf2, telf3,telf4);
		
		System.out.println("Existen operadoras claro : "+contarClaro);
		

	}

}
