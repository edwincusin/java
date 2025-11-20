package com.krakedev.estaticos;

public class Calculos {
	
	//FINAL HACE QUE EL VALOR NO SE PUEDA CAMBIAR, ES DECRI QYE SE CONVIERTE EN UNA VARIABLE CONSTANTE
	private final double IVA=12;
	
	public double calcularIva(double monto) {
		//iva=14;
		return monto*IVA/100;
	}
}
