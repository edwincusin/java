package com.cmc.evaluacion.test;

import com.cmc.evaluacion.entidades.Cuota;

public class TestImpresion {

	public static void main(String[] args) {
		Cuota cuota1=new Cuota(1);
		
		cuota1.setCuota(1.000);
		cuota1.setCapital(44.2444);
		cuota1.setInteres(50.0000);
		cuota1.setAbonoCapital(394.24111);
		cuota1.setSaldo(4605.76111111);

		cuota1.mostrarPrestamo();

	}
	
	

}
