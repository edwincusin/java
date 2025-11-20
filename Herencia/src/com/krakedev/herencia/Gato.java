package com.krakedev.herencia;

public class Gato extends Animal{
	
	//METODO MAULLAR SIN RETORNO Y SIN PARAMETROS
	public void maullar() {
		System.out.println("Soy el gato que maulla en el techo");
	}
	
	//METODO MAULLAR SIN RETORNO Y CON PASO DE PARAMETROS
	public void maullar(String adjetivo) {
		System.out.println("Gato maullando : "+ adjetivo);
	}
	
	
	
	
	
	@Override
	public void dormir() {
		System.out.println("El gato duerme roncando");
	}
}
