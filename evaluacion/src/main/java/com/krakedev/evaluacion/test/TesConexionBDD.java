package com.krakedev.evaluacion.test;

import java.sql.Connection;

import com.krakedev.evaluacion.excepciones.KrakeException;
import com.krakedev.evaluacion.utils.ConexionBDD;

public class TesConexionBDD {

	public static void main(String[] args) {
		Connection	con=null;
		try {
			con=ConexionBDD.conectar();
			
		} catch (KrakeException e) {
			System.out.println(e);
		}
	}

}
