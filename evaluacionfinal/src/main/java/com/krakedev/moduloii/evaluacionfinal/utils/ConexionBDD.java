package com.krakedev.moduloii.evaluacionfinal.utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.krakedev.moduloii.evaluacionfinal.excepciones.KrakeDevException;

public class ConexionBDD {
	
	private static final Logger LOGGER = LogManager.getLogger(ConexionBDD.class);
	
	public static Connection obtenerConexion() throws KrakeDevException {
		Context ctx = null;
		DataSource ds = null;
		Connection con = null;
		try {
			ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/PgDB");
			con = ds.getConnection();
			LOGGER.debug("Obteniendo Conexion");
		} catch (NamingException | SQLException e) {
			e.printStackTrace();
			// RELANZO LA EXCEPCION CON UN MENSAJE DE USUARIO
			throw new KrakeDevException("ERROR DE CONEXION");
		} 
	return con;
	}
}
