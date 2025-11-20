package com.krakedev.estaticos.ejercicios.test;

import java.util.ArrayList;
import java.util.Iterator;

import com.krakedev.estaticos.ejercicios.entidades.Alarma;
import com.krakedev.estaticos.ejercicios.logica.AdminAlarmas;
import com.krakedev.estaticos.ejercicios.utils.DiasSemana;

public class TestAlarmas {

	public static void main(String[] args) {
		Alarma alarma1 = new Alarma(DiasSemana.LUNES, 5, 1);
		Alarma alarma2 = new Alarma(DiasSemana.MARTES, 6, 10);
		Alarma alarma3 = new Alarma(DiasSemana.MIERCOLES, 7, 15);
		Alarma alarma4 = new Alarma(DiasSemana.JUEVES, 8, 50);
		Alarma alarma5 = new Alarma(DiasSemana.VIERNES, 14, 4);
		Alarma alarma6 = new Alarma(DiasSemana.SABADO, 15, 13);
		Alarma alarma7 = new Alarma(DiasSemana.DOMINGO, 17, 0);
		
		AdminAlarmas ad=new AdminAlarmas();
		
		Alarma[] alarmas= {alarma1,alarma2,alarma3,alarma4,alarma5,alarma6,alarma7};
		
		for(int i=0; i<alarmas.length;i++) {
			ad.agregarAlarma(alarmas[i]);
		}
		
		ArrayList<Alarma> alarmasActuales =ad.getAlarmas();
		
		System.out.println(alarmasActuales);
		

	}

}
