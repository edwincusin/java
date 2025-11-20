package com.krakedev.estaticos.ejercicios.utils;

public class Util {
	
	//METODO ESTATICO FORMATEAR HORA
	public static String formatearHora(int numero) {
		if(numero >=0 && numero<10) {
			return "0"+numero;
		}else {
			return numero+"";
		}
	}	
	
	//METODO ESTATICO FORMATEAR DIA	
	public static String formatearDia(int numero) {

		if(numero==0) return "Lunes";
		if(numero==1) return "Martes";
		if(numero==2) return "Miercoles";
		if(numero==3) return "Jueves";
		if(numero==4) return "Viernes";
		if(numero==5) return "Sabado";
		if(numero==6) return "Domingo";
		
		//arrojar error en caso no ingrese a un if
		return "ERROR DIA";
	}
	
}

