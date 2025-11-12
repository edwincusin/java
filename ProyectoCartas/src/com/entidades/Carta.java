package com.entidades;

public class Carta {
	private Numero numero;
	private String palo;
	private String estado="N";
	
	
	//CONSTRUCTOR CON PARAMETROS 
	public Carta(Numero numero, String palo) {
		this.numero = numero;
		this.palo = palo;
	}
	
	//METODO MOSTRAR INFORMACION CARTA
	public void mostrarInformacionCarta() {
		System.out.println(getNumero().getNumeroCarta()+"-"+getPalo());
	}

	
	//METODOS GET Y SET 
	public Numero getNumero() {
		return numero;
	}

	public void setNumero(Numero numero) {
		this.numero = numero;
	}

	public String getPalo() {
		return palo;
	}

	public void setPalo(String palo) {
		this.palo = palo;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
	


}
