package com.krakedev.repasoii.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.krakedev.repasoii.repasofinal.excepciones.KrakeDevException;

public class ConexionBDD {
	private static final Logger LOGGER = LogManager.getLogger(ConexionBDD.class);
	
	private static final String DRIVER="org.postgresql.Driver";
	private static final String URL="jdbc:postgresql://localhost:5432/repasofinal";
	private static final String USUARIO="postgres";
	private static final String CLAVE="pgadmin4";
	
	public static Connection conectar() throws KrakeDevException{ // agreagr en la friam el trw
		Connection con=null;
		try {
			LOGGER.debug("OBTENIENDO CONEXION.....");
			Class.forName(DRIVER);
			con=DriverManager.getConnection(URL,USUARIO,CLAVE);
			LOGGER.debug("CONEXION EXITOSA A LA BASE DE DATOS:"+URL);
		} catch (ClassNotFoundException e) {
			//e.printStackTrace();
			LOGGER.error("ERROR EN LA INFRAESTRUCTURA - CONEXION",e);
			// RELANZA UNA EXCEPECION PARA EL CLIENTE
			throw new KrakeDevException("ERROR EN LA INFRAESTRUCTURA"); 
		} catch (SQLException e) {
			//e.printStackTrace();
			LOGGER.error("ERROR LA CONECTARSE REVISE USR Y PSW DE LA BDD",e);
			throw new KrakeDevException("ERROR AL CONECTARSE REVISE USR Y PSW DE LA BDD"); 
		} 		
		return con;
	}
	

}
