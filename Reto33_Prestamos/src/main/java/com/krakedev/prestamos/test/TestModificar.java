package com.krakedev.prestamos.test;

import java.util.Date;

import com.krakedev.prestamos.entidades.Persona;
import com.krakedev.prestamos.entidades.Prestamo;
import com.krakedev.prestamos.servicios.AdminPrestamo;
import com.krakedev.prestamos.util.Convertidor;

public class TestModificar {

	public static void main(String[] args) {
		//CEDULAS 1753081056 / 1753081054 / 1753081056

		Persona p=new Persona();
		p.setCedula("1753081056");
		
		Prestamo prestamo=new Prestamo();
		prestamo.setPersona(p);
		prestamo.setCodigo(1);
		
		try {
			Date fechaPrestamo=Convertidor.convertirFecha("2020/12/12");
			Date horaPrestamo=Convertidor.convertirHora("17:50");
			prestamo.setFechaPrestamo(fechaPrestamo);
			prestamo.setHoraPrestamo(horaPrestamo);
			
			AdminPrestamo.eliminar(prestamo);
		} catch (Exception e) {
			//e.printStackTrace(); //NO SE LOGEA
			System.out.println("error en el sistema: "+e.getMessage());
		}
	}

}
