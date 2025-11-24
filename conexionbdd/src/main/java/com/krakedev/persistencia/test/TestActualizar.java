package com.krakedev.persistencia.test;

import java.math.BigDecimal;
import java.util.Date;

import com.krakedev.persistencia.entidades.EstadoCivil;
import com.krakedev.persistencia.entidades.Persona;
import com.krakedev.persistencia.servicios.AdminPersonas;
import com.krakedev.persistencia.utils.Convertidor;

public class TestActualizar {

	public static void main(String[] args) {
		
		EstadoCivil ec=new EstadoCivil("C","CASADO");
		Persona p= new Persona("8888888888", "PAPA","NOEL",1.90,new BigDecimal(1500.08),0,ec);
		
		try {
			Date fechaNac=Convertidor.convertirFecha("1900/12/25");
			Date horanac=Convertidor.convertirHora("01:12");
			p.setFechaNacimiento(fechaNac);
			p.setHoraNacimiento(horanac);
			AdminPersonas.actualizar(p);
			
		} catch (Exception e) {
			//e.printStackTrace(); //NO SE LOGEA
			System.out.println("ERROR EN EL SISTEMA: "+e.getMessage());
		}	

	}

}
