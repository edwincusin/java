package com.krakedev.repasoii.test;

import java.sql.Connection;

import com.krakedev.repasoii.repasofinal.excepciones.KrakeDevException;
import com.krakedev.repasoii.utils.ConexionBDD;

public class TestConexionBDD {

	public static void main(String[] args) {
		
		Connection con=null;
		
		try {
			con=ConexionBDD.conectar();
		} catch (KrakeDevException e) {
			System.out.println(e.getMessage());
		}
	}

}
