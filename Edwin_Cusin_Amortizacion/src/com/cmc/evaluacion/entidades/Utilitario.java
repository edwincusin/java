package com.cmc.evaluacion.entidades;

public class Utilitario {

	public static double redondear(double numero) {
		double numeroDosDecimales = Math.round(numero * 100.0) / 100.0;
		return numeroDosDecimales;
	}

}
