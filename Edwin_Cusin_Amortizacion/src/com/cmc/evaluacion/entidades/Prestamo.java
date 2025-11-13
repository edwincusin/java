package com.cmc.evaluacion.entidades;

import java.util.ArrayList;

public class Prestamo {

	private double monto;
	private double interes;
	private int plazo;
	private ArrayList<Cuota> cuotas;
	
	//CONSTRUCTOR CON PARAMETROS 
	public Prestamo(double monto, double interes, int plazo) {
		cuotas=new ArrayList<Cuota>(); //INICIALIZAMOS EL ARRAY
		this.monto = monto;
		this.interes = interes;
		this.plazo = plazo;
	}

	//METODOS GET Y SET DE TODOS LOS ATRIBUTOS
	public double getMonto() {
		return monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}

	public double getInteres() {
		return interes;
	}

	public void setInteres(double interes) {
		this.interes = interes;
	}

	public int getPlazo() {
		return plazo;
	}

	public void setPlazo(int plazo) {
		this.plazo = plazo;
	}

	public ArrayList<Cuota> getCuotas() {
		return cuotas;
	}
	
	
	
	
}
