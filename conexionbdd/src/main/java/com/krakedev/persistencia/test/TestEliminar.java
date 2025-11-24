package com.krakedev.persistencia.test;

import java.math.BigDecimal;
import java.util.Date;

import com.krakedev.persistencia.entidades.EstadoCivil;
import com.krakedev.persistencia.entidades.Persona;
import com.krakedev.persistencia.servicios.AdminPersonas;
import com.krakedev.persistencia.utils.Convertidor;

public class TestEliminar {

	public static void main(String[] args) {
		Persona p= new Persona();
		
		
		try {
			p.setCedula("0953081211");
			AdminPersonas.eliminar(p);
			
		} catch (Exception e) {
			//e.printStackTrace(); //NO SE LOGEA
			System.out.println("ERROR EN EL SISTEMA: "+e.getMessage());
		}	

	}

}
