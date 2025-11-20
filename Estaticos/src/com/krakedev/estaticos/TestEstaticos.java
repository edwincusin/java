package com.krakedev.estaticos;

public class TestEstaticos {

	public static void main(String[] args) {
		
		//PARA INVOCAR METODOS ESTATICOS SE LO HACE DISRECTAMENTE DESDE LA CLASE, 
		// NO SE INSTANCIA
		double numero = StrictMath.random();
		System.out.println(numero);
	}

}
