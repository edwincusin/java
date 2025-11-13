package com.cmc.evaluacion.entidades;

public class Cuota {
	private int numero;
	private double cuota;
	private double capital;//luego del capital inicial 
	private double inicio;
	private double interes;
	private double abonoCapital;
	private double saldo;
	
	
	//METODO MOSTRAR PRESTAMOS
	public void mostrarPrestamo() {
		System.out.println(
				this.numero
				+"  |  "+Utilitario.redondear(getCuota())
				+"  |  "+Utilitario.redondear(getInicio())
				+"  |  "+Utilitario.redondear(getInteres())
				+"  |  "+Utilitario.redondear(getAbonoCapital())
				+"  |  "+Utilitario.redondear(getSaldo())
				);
	}
	

	
	//CONSTRUCTOR CON UN PARAMETRO NUMERO
	public Cuota(int numero) {
		this.numero = numero;
	}
	
	//METODOS GET Y SET
	public double getCuota() {
		return cuota;
	}
	public void setCuota(double cuota) {
		this.cuota = cuota;
	}
	public double getCapital() {
		return capital;
	}
	public void setCapital(double capital) {
		this.capital = capital;
	}
	public double getInicio() {
		return inicio;
	}
	public void setInicio(double inicio) {
		this.inicio = inicio;
	}
	public double getInteres() {
		return interes;
	}
	public void setInteres(double interes) {
		this.interes = interes;
	}
	public double getAbonoCapital() {
		return abonoCapital;
	}
	public void setAbonoCapital(double abonoCapital) {
		this.abonoCapital = abonoCapital;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	
}
