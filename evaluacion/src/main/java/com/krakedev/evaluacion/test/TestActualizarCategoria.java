package com.krakedev.evaluacion.test;

import com.krakedev.evaluacion.entidades.Categoria;
import com.krakedev.evaluacion.excepciones.KrakeException;
import com.krakedev.evaluacion.servicios.ServiciosCategoria;

public class TestActualizarCategoria {

	public static void main(String[] args) {
		//TEST ACTUALIZAR CATEGORIA EN BASE A LA ID
		
		Categoria cat=new Categoria("C001","CARNES");
		
		try {
			ServiciosCategoria.actualizar(cat);
		} catch (KrakeException e) {
			System.out.println("ERROR DEL SISTEMA: "+e.getMessage());
		}
	}
}
