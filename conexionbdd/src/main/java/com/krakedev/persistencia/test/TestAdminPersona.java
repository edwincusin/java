package com.krakedev.persistencia.test;

import java.math.BigDecimal;
import java.util.Date;

import com.krakedev.persistencia.entidades.EstadoCivil;
import com.krakedev.persistencia.entidades.Persona;
import com.krakedev.persistencia.servicios.AdminPersonas;
import com.krakedev.persistencia.utils.Convertidor;

public class TestAdminPersona {

	public static void main(String[] args) {
		EstadoCivil ec=new EstadoCivil("U","UNION LIBRE");
		Persona p= new Persona("0053081211", "DIANA","DUQUE",1.80,new BigDecimal(500.08),1,ec);
		try {
			Date fechaNac=Convertidor.convertirFecha("2015/10/05");
			Date horanac=Convertidor.convertirHora("18:25");
			p.setFechaNacimiento(fechaNac);
			p.setHoraNacimiento(horanac);
			AdminPersonas.insertar(p);
			
		} catch (Exception e) {
			//e.printStackTrace(); //NO SE LOGEA
			System.out.println("error en el sistema: "+e.getMessage());
		}	
	}

}
