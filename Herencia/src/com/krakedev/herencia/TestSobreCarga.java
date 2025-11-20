package com.krakedev.herencia;

public class TestSobreCarga {

	public static void main(String[] args) {
		Gato gato=new Gato();
		System.out.println("-----------------------------");
		//INVOCO AL METODO MAULLAR SIN PASO DE PARAMETROS Y SIN RETORNO
		gato.maullar();
		
		System.out.println();
		//INVOCO AL METODO MAULLAR CON PASO DE PARAMETROS Y SIN RETORNO
		gato.maullar("FUERTE");
	}

}
