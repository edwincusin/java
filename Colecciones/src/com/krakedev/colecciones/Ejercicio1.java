package com.krakedev.colecciones;
import java.util.ArrayList;

public class Ejercicio1 {

	public static void main(String[] args) {
		ArrayList<String> cadenas;
		String valorRecuperado1;
		String valorRecuperado2;
		cadenas = new ArrayList<String>();
		System.out.println(cadenas.size());
		
		//PARA AGREGAR ELEMENTOS AL ARRAY
		cadenas.add("uno"); // index0
		cadenas.add("dos"); // index1
		System.out.println(cadenas.size());
		valorRecuperado1=cadenas.get(1);
		System.out.println(valorRecuperado1);
		valorRecuperado2=cadenas.get(0);
		System.out.println(valorRecuperado2);
		
		String cadena;
		for(int i=0;i<cadenas.size();i++) {
			cadena=cadenas.get(i);
			System.out.println("cadena : "+cadena);
		}
	}

}
