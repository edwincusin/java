package com.krakedev.herencia;

public class Perro extends Animal{
	
	
	
	
	public Perro() {
		super();
		System.out.println("ejecuta constructor de perro");
	}

	public void ladrar() {
		System.out.println("PERRO LADRANDO");
		
	}
	
	@Override
	public void dormir() {
		super.dormir();
		System.out.println("perro durmiendo");
	}
}
