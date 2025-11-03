package com.krakedev.test;

import com.krakedev.Rectangulo;

public class TestRectangulo {

	public static void main(String[] args) {
		// instanciar clase rectangulo y referencio con la variable r1 el objeto
		Rectangulo r1 = new Rectangulo();
		Rectangulo r2=new Rectangulo();
		Rectangulo r3=new Rectangulo(); // objeto para para perimetro
		int areaR1, areaR2, perimetro1;;
		
		r1.setBase(10);
		r1.setAltura(5);
		
		r2.setBase(8);
		r2.setAltura(3);
		
		r3.setBase(4);
		r3.setAltura(2);
		
		areaR1=r1.calcularArea();
		areaR2=r2.calcularArea();
		perimetro1=r3.calcularPerimetro();
		System.out.println(""
				+ "Area de r1      :  "+areaR1
				+ "\nArea de r2    :  "+areaR2
				+"\nPerimetro de r3:  "+perimetro1
				);		
		
	}

}
