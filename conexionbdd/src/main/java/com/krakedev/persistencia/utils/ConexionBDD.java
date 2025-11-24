package com.krakedev.persistencia.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConexionBDD {
	private static final Logger LOGGER = LogManager.getLogger(ConexionBDD.class);
	
	private static final String DRIVER="org.postgresql.Driver";
	private static final String URL="jdbc:postgresql://localhost:5432/postgres";
	private static final String USUARIO="postgres";
	private static final String CLAVE="pgadmin4";
	
	public static Connection conectar() throws Exception{ // agreagr en la friam el trw
		Connection con=null;
		try {
			Class.forName(DRIVER);
			con=DriverManager.getConnection(URL,USUARIO,CLAVE);
			LOGGER.debug("CONEXION EXITOSA A LA BASE DE DATOS:"+URL);
		} catch (ClassNotFoundException e) {
			//e.printStackTrace();
			LOGGER.error("ERROR EN LA INFRAESTRUCTURA - CONEXION",e);
			// RELANZA UNA EXCEPECION PARA EL CLIENTE
			throw new Exception("ERROR EN LA INFRAESTRUCTURA"); 
		} catch (SQLException e) {
			//e.printStackTrace();
			LOGGER.error("ERROR LA CONECTARSE REVISE USR Y PSW DE LA BDD",e);
			throw new Exception("ERROR LA CONECTARSE REVISE USR Y PSW DE LA BDD"); 
		} 
		
		return con;
	}
	

}
