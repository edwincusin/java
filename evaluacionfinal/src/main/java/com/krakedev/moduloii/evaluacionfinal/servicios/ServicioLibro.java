package com.krakedev.moduloii.evaluacionfinal.servicios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.krakedev.moduloii.evaluacionfinal.entidades.Libro;
import com.krakedev.moduloii.evaluacionfinal.excepciones.KrakeDevException;
import com.krakedev.moduloii.evaluacionfinal.utils.ConexionBDD;

public class ServicioLibro {
	// CREAR EL LOGGER PARA LOS ERRORES
	private static final Logger LOGGER = LogManager.getLogger(ServicioLibro.class);

	// METODO PARA INSERTAR
	public void insertar(Libro libro) throws KrakeDevException {
		// CONECTARSE A LA BDD
		Connection con = null;
		LOGGER.trace("LIBRO A INSERTAR: " + libro);
		try {
			// CONEXION CON LA BDD
			con = ConexionBDD.obtenerConexion();
			// PREPARAR LA SENTENCIA
			PreparedStatement ps = con.prepareStatement(
					"insert into libros(titulo, id_autor, id_genero, anio_publicacion, estado_disponible)"
							+ "values(?,?,?,?,?)");
			ps.setString(1, libro.getTitulo());
			ps.setInt(2, libro.getId_autor());
			ps.setInt(3, libro.getId_genero());
			ps.setInt(4, libro.getAnio_publicacion());
			ps.setBoolean(5, libro.isEstado_disponible());

			// EJECUTAR EL INSERT
			ps.executeUpdate();
		} catch (SQLException e) {
			// MENSAJE DE EXCEPCION
			e.printStackTrace();
			LOGGER.error("ERROR AL INSERTAR", e);
			throw new KrakeDevException("ERROR AL INSERTAR EL LIBRO: " + e.getMessage());
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
	public void actualizar(Libro libro) throws KrakeDevException {
		// CONECTARSE A LA BDD
		Connection con = null;
		try {
			// CONEXION CON LA BDD
			con = ConexionBDD.obtenerConexion();
			// PREPARAR LA SENTENCIA
			PreparedStatement ps = con.prepareStatement(
					"update libros set titulo=?, id_autor=?, id_genero=?, anio_publicacion=?, estado_disponible=? where id=?");
			ps.setString(1, libro.getTitulo());
			ps.setInt(2, libro.getId_autor());
			ps.setInt(3, libro.getId_genero());
			ps.setInt(4, libro.getAnio_publicacion());
			ps.setBoolean(5, libro.isEstado_disponible());
			ps.setInt(6, libro.getId());

			// EJECUTAR EL INSERT
			ps.executeUpdate();
		} catch (SQLException e) {
			// MENSAJE DE EXCEPCION
			e.printStackTrace();
			LOGGER.error("ERROR AL ACTUALIZAR", e);
			throw new KrakeDevException("ERROR AL ACTUALIZAR EL LIBRO: " + e.getMessage());
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
	public ArrayList<Libro> recuperarTodos() throws KrakeDevException {
		ArrayList<Libro> libros = new ArrayList<Libro>();
		// CONECTARSE A LA BDD
		Connection con = null;
		// OBTENER EL RESULTADO RESULTSET
		ResultSet rs = null;
		// CREAR EL OBJETO
		Libro libro = null;
		try {
			// CONEXION CON LA BDD
			con = ConexionBDD.obtenerConexion();
			// PREPARAR LA SENTENCIA
			PreparedStatement ps = con.prepareStatement(
					"select id, titulo, id_autor, id_genero, anio_publicacion, estado_disponible from libros");
			// EJECUTAR LA BUSQUEDA Y GUARDAR EN EL RESULTSET
			rs = ps.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				String titulo = rs.getString("titulo");
				int id_autor = rs.getInt("id_autor");
				int id_genero = rs.getInt("id_genero");
				int anio_publicacion = rs.getInt("anio_publicacion");
				boolean estado_disponible = rs.getBoolean("estado_disponible");

				// DAR LOS VALORES AL OBJETO
				libro = new Libro(id, titulo, id_autor, id_genero, anio_publicacion, estado_disponible);
				// AGREGAR EL CLIENTE AL ARRAY LIST
				libros.add(libro);
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
		return libros;
	}

	// METODO PARA CONTAR LIBROS POR GENERO
	public int contarLibrosPorGenero(int idGenero) throws KrakeDevException {
		Connection con = null;
		ResultSet rs = null;
		int total = 0;

		try {
			con = ConexionBDD.obtenerConexion();

			PreparedStatement ps = con.prepareStatement("select count(*) as total from libros where id_genero = ?");
			ps.setInt(1, idGenero);

			rs = ps.executeQuery();

			if (rs.next()) {
				total = rs.getInt("total");
			}

		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("ERROR AL CONTAR LIBROS", e);
			throw new KrakeDevException("ERROR AL CONTAR LIBROS DEL GENERO");
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return total;
	}

}
