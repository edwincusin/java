package com.krakedev;

public class Mensajeria {
	//metodo que no retorna
	public void saludar() {
		System.out.println("HOLA HUMANOS");
	}
	//metodo que no retorna pero si recibe
	public void saludarAmigo(String nombre, String apellido) {
		System.out.println("HOLA "+nombre+" "+apellido);
	}
}
