package com.cmc.evaluacion.test;

import com.cmc.evaluacion.entidades.Prestamo;
import com.cmc.evaluacion.servicios.CalculadoraAmortizacion;

public class TestPruebasGeneral {

	public static void main(String[] args) {
		CalculadoraAmortizacion cA= new CalculadoraAmortizacion();
		System.out.printf("%.2f%n",cA.calcularCuota(new Prestamo(5000, 12, 12)));

	}

}
