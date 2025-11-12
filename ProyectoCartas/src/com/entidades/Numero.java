package com.entidades;

public class Numero {
	private String numeroCarta;
	private int valor;
	
	//CONTRUCTOR CON PARAMETROS 
	public Numero(String numeroCarta, int valor) {
		this.numeroCarta = numeroCarta;
		this.valor = valor;
	}

	//METODO MOSTRAR INFORMACION FORMATO numeroCarta-valor
	public void mostrarInformacionNumero(){
		System.out.println(getNumeroCarta()+"-"+getValor());
		System.out.println();
	}
	
	
	
	// METODOS GET Y SET
	public String getNumeroCarta() {
		return numeroCarta;
	}

	public void setNumeroCarta(String numeroCarta) {
		this.numeroCarta = numeroCarta;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

}
