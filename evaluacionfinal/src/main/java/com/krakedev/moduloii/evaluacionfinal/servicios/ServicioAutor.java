package com.krakedev.moduloii.evaluacionfinal.servicios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.krakedev.moduloii.evaluacionfinal.entidades.Autor;
import com.krakedev.moduloii.evaluacionfinal.excepciones.KrakeDevException;
import com.krakedev.moduloii.evaluacionfinal.utils.ConexionBDD;

public class ServicioAutor {
	// CREAR EL LOGGER PARA LOS ERRORES
	private static final Logger LOGGER = LogManager.getLogger(ServicioAutor.class);

	// METODO PARA INSERTAR
	public void insertar(Autor autor) throws KrakeDevException {
		// CONECTARSE A LA BDD
		Connection con = null;
		LOGGER.trace("AUTOR A INSERTAR: " + autor);
		try {
			// CONEXION CON LA BDD
			con = ConexionBDD.obtenerConexion();
			// PREPARAR LA SENTENCIA
			PreparedStatement ps = con
					.prepareStatement("insert into autores(nombre, fecha_nacimiento, nacionalidad)" + "values(?,?,?)");
			ps.setString(1, autor.getNombre());
			ps.setDate(2, new java.sql.Date(autor.getFecha_nacimiento().getTime()));
			ps.setString(3, autor.getNacionalidad());

			// EJECUTAR EL INSERT
			ps.executeUpdate();
		} catch (SQLException e) {
			// MENSAJE DE EXCEPCION
			e.printStackTrace();
			LOGGER.error("ERROR AL INSERTAR", e);
			throw new KrakeDevException("ERROR AL INSERTAR EL AUTOR: " + e.getMessage());
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
	public void actualizar(Autor autor) throws KrakeDevException {
		// CONECTARSE A LA BDD
		Connection con = null;
		try {
			// CONEXION CON LA BDD
			con = ConexionBDD.obtenerConexion();
			// PREPARAR LA SENTENCIA
			PreparedStatement ps = con
					.prepareStatement("update autores set nombre=?, fecha_nacimiento=?, nacionalidad=? where id=?");
			ps.setString(1, autor.getNombre());
			ps.setDate(2, new java.sql.Date(autor.getFecha_nacimiento().getTime()));
			ps.setString(1, autor.getNacionalidad());
			ps.setInt(4, autor.getId());

			// EJECUTAR EL INSERT
			ps.executeUpdate();
		} catch (SQLException e) {
			// MENSAJE DE EXCEPCION
			e.printStackTrace();
			LOGGER.error("ERROR AL ACTUALIZAR", e);
			throw new KrakeDevException("ERROR AL ACTUALIZAR EL AUTOR: " + e.getMessage());
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
	public ArrayList<Autor> recuperarTodos() throws KrakeDevException {
		ArrayList<Autor> autores = new ArrayList<Autor>();
		// CONECTARSE A LA BDD
		Connection con = null;
		// OBTENER EL RESULTADO RESULTSET
		ResultSet rs = null;
		// CREAR EL OBJETO
		Autor autor = null;
		try {
			// CONEXION CON LA BDD
			con = ConexionBDD.obtenerConexion();
			// PREPARAR LA SENTENCIA
			PreparedStatement ps = con
					.prepareStatement("select id, nombre, fecha_nacimiento, nacionalidad from autores");
			// EJECUTAR LA BUSQUEDA Y GUARDAR EN EL RESULTSET
			rs = ps.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				String nombre = rs.getString("nombre");
				Date fecha_nacimiento = rs.getDate("fecha_nacimiento");
				String nacionalidad = rs.getString("nacionalidad");

				// DAR LOS VALORES AL OBJETO
				autor = new Autor(id, nombre, fecha_nacimiento, nacionalidad);
				// AGREGAR EL CLIENTE AL ARRAY LIST
				autores.add(autor);
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
		return autores;
	}

	// METODO PARA ELIMINAR
	public void eliminar(int id) throws KrakeDevException {
		Connection con = null;
		LOGGER.trace("ID A ELIMINAR: " + id);
		try {
			// CONEXION CON LA BDD
			con = ConexionBDD.obtenerConexion();
			// PREPARAR LA SENTENCIA
			PreparedStatement ps = con.prepareStatement("delete from autores where id=?");
			ps.setInt(1, id);
			
			// EJECUTAR EL DELETE
			int filas = ps.executeUpdate();

			if (filas == 0) {
				LOGGER.warn("NO SE ENCONTRO EL REGISTRO CON ID: " + id);
				throw new KrakeDevException("NO EXISTE EL REGISTRO CON ID: " + id);
			}

			LOGGER.debug("ELIMINACION REALIZADA CORRECTAMENTE");

		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("ERROR AL ELIMINAR", e);
			throw new KrakeDevException("ERROR AL ELIMINAR: " + e.getMessage());
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
					LOGGER.error("ERROR EN LA BASE DE DATOS", e);
				}
			}
		}
	}

}
