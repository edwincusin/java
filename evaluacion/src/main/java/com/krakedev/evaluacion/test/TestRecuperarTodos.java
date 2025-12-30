package com.krakedev.evaluacion.test;

import java.util.ArrayList;

import com.krakedev.evaluacion.entidades.Categoria;
import com.krakedev.evaluacion.excepciones.KrakeException;
import com.krakedev.evaluacion.servicios.ServiciosCategoria;

public class TestRecuperarTodos {

	public static void main(String[] args) {
		//TEST DE RECUPERAR TODAS CATEGORIAS
		
		try {
			ArrayList<Categoria> categorias =ServiciosCategoria.recuperarTodos();
			
			if(categorias.size()!=0 || categorias != null) {
				System.out.println(categorias);
			}
		} catch (KrakeException e) {
			System.out.println("ERROR EN EL SISTEMA : "+e.getMessage());
		}
	}
}
