package com.krakedev.moduloii.evaluacionfinal.servicios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.krakedev.moduloii.evaluacionfinal.entidades.Prestamo;
import com.krakedev.moduloii.evaluacionfinal.excepciones.KrakeDevException;
import com.krakedev.moduloii.evaluacionfinal.utils.ConexionBDD;

public class ServicioPrestamo {
	// CREAR EL LOGGER PARA LOS ERRORES
	private static final Logger LOGGER = LogManager.getLogger(ServicioPrestamo.class);

	// METODO PARA INSERTAR
	public void insertar(Prestamo prestamo) throws KrakeDevException {
		// CONECTARSE A LA BDD
		Connection con = null;
		LOGGER.trace("PRESTAMO A INSERTAR: " + prestamo);
		try {
			// CONEXION CON LA BDD
			con = ConexionBDD.obtenerConexion();
			// PREPARAR LA SENTENCIA
			PreparedStatement ps = con.prepareStatement(
					"insert into prestamos(id_libro, usuario, fecha_prestamo, fecha_devolucion)" + "values(?,?,?,?)");
			ps.setInt(1, prestamo.getId_libro());
			ps.setString(2, prestamo.getUsuario());
			ps.setDate(3, new java.sql.Date(prestamo.getFecha_prestamo().getTime()));
			ps.setDate(4, new java.sql.Date(prestamo.getFecha_devolucion().getTime()));

			// EJECUTAR EL INSERT
			ps.executeUpdate();
		} catch (SQLException e) {
			// MENSAJE DE EXCEPCION
			e.printStackTrace();
			LOGGER.error("ERROR AL INSERTAR", e);
			throw new KrakeDevException("ERROR AL INSERTAR EL PRESTAMO: " + e.getMessage());
		} catch (KrakeDevException e) {
			throw e;
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					LOGGER.error("ERROR EN LA BASE DE DATOS", e);
				}
			}
		}
	}

	// METODO PARA ACTUALIZAR
	public void actualizar(Prestamo prestamo) throws KrakeDevException {
		// CONECTARSE A LA BDD
		Connection con = null;
		try {
			// CONEXION CON LA BDD
			con = ConexionBDD.obtenerConexion();
			// PREPARAR LA SENTENCIA
			PreparedStatement ps = con.prepareStatement(
					"update prestamos set id_libro=?, usuario=?, fecha_prestamo=?, fecha_devolucion=? where id=?");
			ps.setInt(1, prestamo.getId_libro());
			ps.setString(2, prestamo.getUsuario());
			ps.setDate(3, new java.sql.Date(prestamo.getFecha_prestamo().getTime()));
			ps.setDate(4, new java.sql.Date(prestamo.getFecha_devolucion().getTime()));
			ps.setInt(5, prestamo.getId());

			// EJECUTAR EL INSERT
			ps.executeUpdate();
		} catch (SQLException e) {
			// MENSAJE DE EXCEPCION
			e.printStackTrace();
			LOGGER.error("ERROR AL ACTUALIZAR", e);
			throw new KrakeDevException("ERROR AL ACTUALIZAR EL PRESTAMO: " + e.getMessage());
		} catch (KrakeDevException e) {
			throw e;
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					LOGGER.error("ERROR EN LA BASE DE DATOS", e);
				}
			}
		}
	}

	// METODO PARA RECUPERAR TODOS
	public ArrayList<Prestamo> recuperarTodos() throws KrakeDevException {
		ArrayList<Prestamo> prestamos = new ArrayList<Prestamo>();
		// CONECTARSE A LA BDD
		Connection con = null;
		// OBTENER EL RESULTADO RESULTSET
		ResultSet rs = null;
		// CREAR EL OBJETO
		Prestamo prestamo = null;
		try {
			// CONEXION CON LA BDD
			con = ConexionBDD.obtenerConexion();
			// PREPARAR LA SENTENCIA
			PreparedStatement ps = con
					.prepareStatement("select id, id_libro, usuario, fecha_prestamo, fecha_devolucion from prestamos");
			// EJECUTAR LA BUSQUEDA Y GUARDAR EN EL RESULTSET
			rs = ps.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				int id_libro = rs.getInt("id_libro");
				String usuario = rs.getString("usuario");
				Date fecha_prestamo = rs.getDate("fecha_prestamo");
				Date fecha_devolucion = rs.getDate("fecha_devolucion");

				// DAR LOS VALORES AL OBJETO
				prestamo = new Prestamo(id, id_libro, usuario, fecha_prestamo, fecha_devolucion);
				// AGREGAR EL CLIENTE AL ARRAY LIST
				prestamos.add(prestamo);
			}

		} catch (SQLException e) {
			// MENSAJE DE EXCEPCION
			e.printStackTrace();
			LOGGER.error("ERROR AL CONSULTAR", e);
			throw new KrakeDevException("ERROR AL CONSULTAR: " + e.getMessage());
		} catch (KrakeDevException e) {
			throw e;
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					LOGGER.error("ERROR EN LA BASE DE DATOS", e);
				}
			}
		}
		return prestamos;
	}

	// METODO PARA CONSULTAR POR ID DE LIBRO
	public ArrayList<Prestamo> consultarPrestamos(int idLibro) throws KrakeDevException {
		ArrayList<Prestamo> prestamos = new ArrayList<>();
		// CONECTARSE A LA BASE DE DATOS
		Connection con = null;
		// OBTENER EL REESULTADO EN RESULTSET
		ResultSet rs = null;
		// CREAR EL OBJETO
		Prestamo prestamo = null;
		try {
			// CONEXION CON LA BDD
			con = ConexionBDD.obtenerConexion();
			// SENTENCIA DE CONSULTA
			PreparedStatement ps = con.prepareStatement("select id, id_libro, usuario, fecha_prestamo, fecha_devolucion "
					+ "from prestamos " + "where id_libro = ? " + "order by fecha_prestamo");

			ps.setInt(1, idLibro);
			rs = ps.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				int id_libro = rs.getInt("id_libro");
				String usuario = rs.getString("usuario");
				Date fechaPrestamo = rs.getDate("fecha_prestamo");
				Date fechaDevolucion = rs.getDate("fecha_devolucion");

				prestamo = new Prestamo(id, id_libro, usuario, fechaPrestamo, fechaDevolucion);
				prestamos.add(prestamo);
			}

			// SI NO SE ENCONTRARON
			if (prestamos.isEmpty()) {
				throw new KrakeDevException("No se encontraron prestamos para el libro con ID: " + idLibro);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new KrakeDevException("Error al consultar: " + e.getMessage());
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return prestamos;
	}

}
