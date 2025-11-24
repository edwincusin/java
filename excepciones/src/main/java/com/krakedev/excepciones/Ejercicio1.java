package com.krakedev.excepciones;

public class Ejercicio1 {

	public static void main(String[] args) {
		System.out.println("INICIO");
		String a=null;
		try {
			System.out.println("ABRE LA CN BDD");
			a.substring(3);
			System.out.println("FIN");

		}catch (Exception ex) { // se ejecuta si en try tiene errores 
			System.out.println("entro al catch");
		}finally { // siempre se ejecuta
			System.out.println("ingresal al finally");
			System.out.println("CIERRA CONXION");
		}
		
		System.out.println("fuera del cathc");
	}

}
