package com.krakedev.moduloii.evaluacionfinal.servicios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.krakedev.moduloii.evaluacionfinal.entidades.Genero;
import com.krakedev.moduloii.evaluacionfinal.excepciones.KrakeDevException;
import com.krakedev.moduloii.evaluacionfinal.utils.ConexionBDD;

public class ServicioGenero {
	// CREAR EL LOGGER PARA LOS ERRORES
	private static final Logger LOGGER = LogManager.getLogger(ServicioGenero.class);

	// METODO PARA INSERTAR
	public void insertar(Genero genero) throws KrakeDevException {
		// CONECTARSE A LA BDD
		Connection con = null;
		LOGGER.trace("GENERO A INSERTAR: " + genero);
		try {
			// CONEXION CON LA BDD
			con = ConexionBDD.obtenerConexion();
			// PREPARAR LA SENTENCIA
			PreparedStatement ps = con.prepareStatement("insert into generos(nombre)" + "values(?)");
			ps.setString(1, genero.getNombre());

			// EJECUTAR EL INSERT
			ps.executeUpdate();
		} catch (SQLException e) {
			// MENSAJE DE EXCEPCION
			e.printStackTrace();
			LOGGER.error("ERROR AL INSERTAR", e);
			throw new KrakeDevException("ERROR AL INSERTAR EL GENERO: " + e.getMessage());
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
	public void actualizar(Genero genero) throws KrakeDevException {
		// CONECTARSE A LA BDD
		Connection con = null;
		try {
			// CONEXION CON LA BDD
			con = ConexionBDD.obtenerConexion();
			// PREPARAR LA SENTENCIA
			PreparedStatement ps = con.prepareStatement("update generos set nombre=? where id=?");
			ps.setString(1, genero.getNombre());
			ps.setInt(2, genero.getId());

			// EJECUTAR EL INSERT
			ps.executeUpdate();
		} catch (SQLException e) {
			// MENSAJE DE EXCEPCION
			e.printStackTrace();
			LOGGER.error("ERROR AL ACTUALIZAR", e);
			throw new KrakeDevException("ERROR AL ACTUALIZAR EL GENERO: " + e.getMessage());
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
	public ArrayList<Genero> recuperarTodos() throws KrakeDevException {
		ArrayList<Genero> generos = new ArrayList<Genero>();
		// CONECTARSE A LA BDD
		Connection con = null;
		// OBTENER EL RESULTADO RESULTSET
		ResultSet rs = null;
		// CREAR EL OBJETO
		Genero genero = null;
		try {
			// CONEXION CON LA BDD
			con = ConexionBDD.obtenerConexion();
			// PREPARAR LA SENTENCIA
			PreparedStatement ps = con.prepareStatement("select id, nombre from generos");
			// EJECUTAR LA BUSQUEDA Y GUARDAR EN EL RESULTSET
			rs = ps.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				String nombre = rs.getString("nombre");

				// DAR LOS VALORES AL OBJETO
				genero = new Genero(id, nombre);
				// AGREGAR EL CLIENTE AL ARRAY LIST
				generos.add(genero);
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
		return generos;
	}

	// METODO PARA ELIMINAR
	public void eliminar(int id) throws KrakeDevException {
		Connection con = null;
		LOGGER.trace("ID A ELIMINAR: " + id);
		try {
			// CONEXION CON LA BDD
			con = ConexionBDD.obtenerConexion();
			// PREPARAR LA SENTENCIA
			PreparedStatement ps = con.prepareStatement("delete from generos where id=?");
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
	
	// METODO PARA ELIMINAR GENERO (SEGURO)
	public void eliminarGeneroSeguro(int id) throws KrakeDevException {
		Connection con = null;
		LOGGER.trace("GENERO A ELIMINAR (SEGURO): " + id);

		try {
			// CONEXION CON LA BDD
			con = ConexionBDD.obtenerConexion();

			// 1️ ACTUALIZAR LIBROS QUE USAN ESTE GENERO
			PreparedStatement psUpdate = con.prepareStatement(
					"update libros set id_genero = 1 where id_genero = ?");
			psUpdate.setInt(1, id);
			psUpdate.executeUpdate();

			// 2️ ELIMINAR EL GENERO
			PreparedStatement psDelete = con.prepareStatement(
					"delete from generos where id = ?");
			psDelete.setInt(1, id);

			int filas = psDelete.executeUpdate();

			if (filas == 0) {
				throw new KrakeDevException("NO EXISTE EL GENERO CON ID: " + id);
			}

			LOGGER.debug("GENERO ELIMINADO CORRECTAMENTE (SEGURO)");

		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("ERROR AL ELIMINAR GENERO", e);
			throw new KrakeDevException("ERROR AL ELIMINAR GENERO: " + e.getMessage());
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
