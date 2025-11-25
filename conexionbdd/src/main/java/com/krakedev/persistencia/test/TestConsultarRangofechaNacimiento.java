package com.krakedev.persistencia.test;

import java.util.ArrayList;
import java.util.Date;

import com.krakedev.persistencia.entidades.Persona;
import com.krakedev.persistencia.servicios.AdminPersonas;
import com.krakedev.persistencia.utils.Convertidor;

public class TestConsultarRangofechaNacimiento {

	public static void main(String[] args) {
		
		
		try {
			ArrayList<Persona> coleccionPersonas = new ArrayList<Persona>();
			Date fechaInicio=Convertidor.convertirFecha("2000/01/01");
			Date fechaFin=Convertidor.convertirFecha("2015/01/01");
			coleccionPersonas=AdminPersonas.buscarRangoFechaNacimiento(fechaInicio,fechaFin);
			System.out.println(coleccionPersonas);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
