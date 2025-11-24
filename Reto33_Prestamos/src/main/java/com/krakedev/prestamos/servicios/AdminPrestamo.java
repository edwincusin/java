package com.krakedev.prestamos.servicios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.krakedev.prestamos.entidades.Prestamo;
import com.krakedev.prestamos.util.ConexionBDD;

public class AdminPrestamo {
	private static final Logger LOGGER = LogManager.getLogger(AdminPrestamo.class);
	//==============METODO ESTATICO INSERTAR PRESTAMO EN LA BDD====================
	public static void insertar(Prestamo prestamo) throws Exception {
		Connection con=null;
		PreparedStatement ps=null;	
		LOGGER.trace("PRESTAMO A INSERTAR>>>>"+prestamo);
		try {
			con = ConexionBDD.conectar();
			
			String consutlaSQL ="INSERT INTO prestamo("
					+ "	codigo, cedula, monto, fecha_prestamo, hora_prestamo, garante)"
					+ "	VALUES (?, ?, ?, ?, ?, ?);";
			
			ps=con.prepareStatement(consutlaSQL);
			
			ps.setInt(1, prestamo.getCodigo());
			ps.setString(2, prestamo.getPersona().getCedula());
			ps.setBigDecimal(3, prestamo.getMonto());
			ps.setDate(4, new java.sql.Date(prestamo.getFechaPrestamo().getTime()));
			ps.setTime(5, new Time(prestamo.getHoraPrestamo().getTime()));
			ps.setString(6, prestamo.getGarante());
			
			ps.executeUpdate();	
			LOGGER.trace("PRESTAMO INSERTADO CON EXITO "+prestamo);
		} catch (Exception e) {
				LOGGER.error("ERROR AL INSERTAR",e);
				throw new Exception("ERROR AL INSERTAR");
			
		}finally {
			try {
				con.close();
				LOGGER.trace("CONEXION CERRADA CON EXITO");
			} catch (SQLException e) {
				LOGGER.error("ERROR CON LA BASE DE DATOS (con.close();)",e);
				throw new Exception("ERROR CON LA BASE DE DATOS (con.close();)");
			}
		}

	}
	
	//==============FIN METODO ESTATICO INSERTAR PRESTAMO EN LA BDD====================
	
	
	
	//==============METODO ESTATICO MODIFICAR PRESTAMO EN LA BDD====================
	public static void modificar(Prestamo prestamo) throws Exception {
		Connection con=null;
		PreparedStatement ps=null;	
		LOGGER.trace("PRESTAMO A MODIFICAR>>>>"+prestamo);
		try {
			con = ConexionBDD.conectar();
			
			String consutlaSQL ="UPDATE public.prestamo\r\n"
					+ "	SET monto=?, fecha_prestamo=?, hora_prestamo=?, garante=?\r\n"
					+ "	WHERE codigo=? and cedula=?;";
			
			ps=con.prepareStatement(consutlaSQL);
			
			
			
			ps.setBigDecimal(1, prestamo.getMonto());
			ps.setDate(2, new java.sql.Date(prestamo.getFechaPrestamo().getTime()));
			ps.setTime(3, new Time(prestamo.getHoraPrestamo().getTime()));
			ps.setString(4, prestamo.getGarante());
			ps.setInt(5, prestamo.getCodigo());
			ps.setString(6, prestamo.getPersona().getCedula());
			
			ps.executeUpdate();	
			LOGGER.trace("PRESTAMO MODIFICAR/ACTUALIZAR CON EXITO "+prestamo);
		} catch (Exception e) {
				LOGGER.error("ERROR AL MODIFICAR/ACTUALIZAR",e);
				throw new Exception("ERROR AL INSERTAR");
			
		}finally {
			try {
				con.close();
				LOGGER.trace("CONEXION CERRADA CON EXITO");
			} catch (SQLException e) {
				LOGGER.error("ERROR CON LA BASE DE DATOS (con.close();)",e);
				throw new Exception("ERROR CON LA BASE DE DATOS (con.close();)");
			}
		}
	}	
	//==============FIN METODO ESTATICO MODIFICAR PRESTAMO EN LA BDD====================
	
	
	
	//==============METODO ESTATICO ELIMINAR PRESTAMO EN LA BDD====================
	public static void eliminar(Prestamo prestamo) throws Exception {
		Connection con=null;
		PreparedStatement ps=null;	
		LOGGER.trace("PRESTAMO A ELIMINAR>>>>"+prestamo.getCodigo() +" DE "+prestamo.getPersona().getCedula());
		try {
			con = ConexionBDD.conectar();
			
			String consutlaSQL ="DELETE FROM prestamo"
					+ "	WHERE codigo=? and cedula=?;";
			
			ps=con.prepareStatement(consutlaSQL);
			
			ps.setInt(1, prestamo.getCodigo());
			ps.setString(2, prestamo.getPersona().getCedula());
			
			ps.executeUpdate();	
			LOGGER.trace("PRESTAMO ELIMINADO CON EXITO "+prestamo.getCodigo() +" de "+prestamo.getPersona().getCedula());
		} catch (Exception e) {
				LOGGER.error("ERROR AL ELIMINAR",e);
				throw new Exception("ERROR AL ELIMINAR");
			
		}finally {
			try {
				con.close();
				LOGGER.trace("CONEXION CERRADA CON EXITO");
			} catch (SQLException e) {
				LOGGER.error("ERROR CON LA BASE DE DATOS (con.close();)",e);
				throw new Exception("ERROR CON LA BASE DE DATOS (con.close();)");
			}
		}
	}
	
	//==============FIN METODO ESTATICO ELIMINAR PRESTAMO EN LA BDD====================

}
