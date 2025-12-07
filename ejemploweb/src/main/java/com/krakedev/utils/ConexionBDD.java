package com.krakedev.utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.krakedev.excepciones.KrakDevException;

public class ConexionBDD {
	//METODO PARA OBTENER CONEXION
	public static Connection obtenerConexion() throws KrakDevException {
		Context ctx = null;
		DataSource ds = null;
		Connection con = null;
		try {
			ctx = new InitialContext();
			// JDNI--> ES PARA PODER ELEMENTOS DENTRO DEL SERVIDOR
			ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/ConexionPG");
			con = ds.getConnection();
		} catch (NamingException | SQLException e) {
			e.printStackTrace();
			throw new KrakDevException("ERROR DE CONEXION");
		}
		return con;
	}
}
