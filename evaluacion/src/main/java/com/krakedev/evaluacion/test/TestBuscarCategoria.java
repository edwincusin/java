package com.krakedev.evaluacion.test;

import com.krakedev.evaluacion.entidades.Categoria;
import com.krakedev.evaluacion.excepciones.KrakeException;
import com.krakedev.evaluacion.servicios.ServiciosCategoria;

public class TestBuscarCategoria {

	public static void main(String[] args) {
		//TES BUSCAR CATEGORIA EN FUNCION DE LA ID
		
		try {
			
			Categoria categoria = ServiciosCategoria.buscarPorId("C0012");
			if(categoria != null) {
				System.out.println(categoria);
			}else {
				System.out.println("CATEGORIA NO ENCONTRADA/NOEXISTE");
			}
			
		} catch (KrakeException e) {
			System.out.println("ERROR DEL SISTEMA : "+e.getMessage());
		}
	}

}
