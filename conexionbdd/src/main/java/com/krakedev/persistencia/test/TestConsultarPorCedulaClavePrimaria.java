package com.krakedev.persistencia.test;

import com.krakedev.persistencia.entidades.Persona;
import com.krakedev.persistencia.servicios.AdminPersonas;

public class TestConsultarPorCedulaClavePrimaria {

	public static void main(String[] args) {

		try {
			Persona persona = AdminPersonas.buscarPorCedula("1753081052");
			if (persona != null) {
				System.out.println(persona);	
			}else {
				System.out.println("NUMERO CEDULA NO ENCONTRADO");
				System.out.println(persona);	
			}		
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
