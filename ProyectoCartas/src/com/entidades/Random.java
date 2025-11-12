package com.entidades;

public class Random {

	public static int obtenerPosicion() {
		double numeroRandom=Math.random();
		int convertidoInt=(int)(numeroRandom*52);
		return convertidoInt;
		
	}
}
