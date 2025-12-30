package com.krakedev.evaluacion.test;

import org.postgresql.translation.messages_bg;

import com.krakedev.evaluacion.entidades.Categoria;
import com.krakedev.evaluacion.excepciones.KrakeException;
import com.krakedev.evaluacion.servicios.ServiciosCategoria;

public class TestInsertarCategoria {
	
	
	public static void main(String[] args) {
		//PRUEBAS DE INSERCION
		Categoria cat1=new Categoria("C005","FRUTAS");
		
		try {
			ServiciosCategoria.insertar(cat1);
		} catch (KrakeException e) {
			System.out.println("ERROR EN EL SISTEMA : "+e.getMessage());
		}
	}
	
	
	

}
