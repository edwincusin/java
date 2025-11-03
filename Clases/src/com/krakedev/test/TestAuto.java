package com.krakedev.test;

import com.krakedev.Auto;

public class TestAuto {

	public static void main(String[] args) {
		//INSTANCIO Y REFERENCIO
		//CONSTRUCOTRES POR DEFECTO
//		Auto auto1;
//		auto1 = new Auto();
//		Auto auto2;
//		auto2 = new Auto();
		
		//MODIFICO LOS VALORES AUTO1
//		auto1.setMarca("BMW");
//		auto1.setAnio(2024);
//		auto1.setPrecio(30000);
				
		//MODIFICO LOS VALORES AUTO1
//		auto2.setMarca("AUDI");
//		auto2.setAnio(2022);
//		auto2.setPrecio(50000);

		//CONSTRUCTORES CON PARAMETROS Y SET 
		Auto auto1;
		auto1 = new Auto("BMW",2024,30000);
		Auto auto2;
		auto2 = new Auto("AUDI",2022,50000);
		
		//MOSTRAR EN CONSOLA LOS ATRIBUTOS DE CADA OBJETO
		System.out.println("--------AUTO1-----------");
		System.out.println("Marca  : "+auto1.getMarca());
		System.out.println("Año    : "+auto1.getAnio());
		System.out.println("Precio : "+auto1.getPrecio());
		
		System.out.println("\n--------AUTO2-----------");
		System.out.println("Marca  : "+auto2.getMarca());
		System.out.println("Año    : "+auto2.getAnio());
		System.out.println("Precio : "+auto2.getPrecio());
		
		
		
	}

}
