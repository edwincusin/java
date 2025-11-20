package com.krakedev.estaticos.ejercicios.entidades;

import com.krakedev.estaticos.ejercicios.utils.Util;

public class Alarma {
	private int dia;
	private int hora;
	private int minuto;
	
	//CONSTRUCTOR CON PARAMETROS
	public Alarma(int dia, int hora, int minuto) {
		super();
		this.dia = dia;
		this.hora = hora;
		this.minuto = minuto;
	}
	
	
	//METODOS SOBREESCRITO HEREDADO DE LA CLASE PADRE OBJECT
	@Override
	public String toString() {
		//FORMATO AUTOMATICO DEL TO STRING
		//return "Alarma [dia=" + dia + ", hora=" + hora + ", minuto=" + minuto + "]";
		
		//FORMATO CON METODOS ESTATICOS CREADOS
		return "\n"+Util.formatearDia(dia)+", "+Util.formatearHora(hora)+":"+Util.formatearHora(minuto);
	}

	//METODOS GET Y SET
	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public int getHora() {
		return hora;
	}

	public void setHora(int hora) {
		this.hora = hora;
	}

	public int getMinuto() {
		return minuto;
	}

	public void setMinuto(int minuto) {
		this.minuto = minuto;
	}
	
}
