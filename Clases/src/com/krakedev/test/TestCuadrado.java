package com.krakedev.test;

import com.krakedev.Cuadrado;

public class TestCuadrado {

	public static void main(String[] args) {
		// instancio y referencio en una variable el objeto
		//constructor por defecto 
//		Cuadrado c1 = new Cuadrado(); 
//		Cuadrado c2 = new Cuadrado(); 
//		Cuadrado c3 = new Cuadrado(); 
		
		//instanciar constructor con parametros set
		Cuadrado c1 = new Cuadrado(4); 
		Cuadrado c2 = new Cuadrado(3); 
		Cuadrado c3 = new Cuadrado(8); 
		
		double area1, area2, area3, perimetro1, perimetro2, perimetro3;
		
//		c1.setLado(4);
//		c2.setLado(3);
//		c3.setLado(8);
		
		area1=c1.calcularArea();
		perimetro1=c2.calcularPerimetro();
		
		area2=c2.calcularArea();
		perimetro2=c2.calcularPerimetro();
		
		area3=c3.calcularArea();
		perimetro3=c3.calcularPerimetro();
		
		System.out.println(
			"---------AREA Y ERIMETRO DE UN CUADRADO-------------"
			+"\n   *** CUADRADO 1 ***"		
			+"\nEl area es       : "+area1
			+"\nEl perimetro es  : "+perimetro1
			
			+ "\n   *** CUADRADO 2 ***"	
			+"\nEl area es       : "+area2
			+"\nEl perimetro es  : "+perimetro2
			
			+ "\n   *** CUADRADO 3 ***"	
			+"\nEl area es       : "+area3
			+"\nEl perimetro es  : "+perimetro3
		);
	}

}
