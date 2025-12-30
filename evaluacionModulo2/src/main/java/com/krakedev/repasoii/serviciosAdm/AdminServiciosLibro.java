package com.krakedev.repasoii.serviciosAdm;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.krakedev.repasoii.entidades.Autor;
import com.krakedev.repasoii.entidades.Genero;
import com.krakedev.repasoii.entidades.Libro;
import com.krakedev.repasoii.entidades.Prestamo;
import com.krakedev.repasoii.repasofinal.excepciones.KrakeDevException;
import com.krakedev.repasoii.utils.ConexionBDD;

public class AdminServiciosLibro {
	
	private static final Logger LOGGER= LogManager.getLogger(ConexionBDD.class);
	
	//METODO MOSTRAR LIBROS
	public static ArrayList<Libro> mostrarLibros() throws KrakeDevException{
		ArrayList<Libro> libros=new ArrayList<Libro>();
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		try {
			con=ConexionBDD.conectarDS();
			String consultaSQL="SELECT id_libro, titulo, autor_id, genero_id, anio_publicacion, estado_disponibilidad, genero.nombre as gn, autores.nombre as an\r\n"
					+ "	FROM libros, genero, autores\r\n"
					+ "	WHERE libros.autor_id = autores.id_autor\r\n"
					+ "	AND libros.genero_id = genero.id_genero";
			ps=con.prepareStatement(consultaSQL);
			rs=ps.executeQuery();
			
			while(rs.next()){
				int libroID = rs.getInt("id_libro");
				String titulo = rs.getString("titulo");
				int autorID =rs.getInt("autor_id");
				String nombreAutor= rs.getString("an");
				int generoID= rs.getInt("genero_id");		
				String nombreGenero= rs.getString("gn");	
				int anioPublicacion=rs.getInt("anio_publicacion");
				boolean estadoDisponibilidad=rs.getBoolean("estado_disponibilidad");
				
				
				Autor autor=new Autor();
				autor.setIdAutor(autorID);
				autor.setNombre(nombreAutor);
				Genero genero=new Genero();
				genero.setIdGenero(generoID);
				genero.setNombre(nombreGenero);
				
				Libro libro = new Libro(libroID,titulo,autor,genero,anioPublicacion,estadoDisponibilidad);
				
				libros.add(libro);		
			}
			
			LOGGER.trace("RETORNO CON EXITO mostrarLibros : "+libros);
		} catch (KrakeDevException e) {
			throw e;
		} catch (SQLException e) {
			LOGGER.trace("ERROR AL REALIZAR LA CONSULTA SQL mostrarLibros");
			throw new KrakeDevException("ERROR AL REALIZAR LA CONSULTA SQL mostrarLibros "+e);
		}finally {
			try {
				con.close();
				LOGGER.trace("BDD CERRADO EXITOSAMENTE");
			} catch (SQLException e) {
				throw new KrakeDevException("ERROR AL REALZIAR CIERRE DE BDD"+e);
			}
		}
		return libros;
	}
	

	//METODO MOSTRAR LISTA DE  PRESTAMOS POR ID Y ORDENAR ASCENDETEMENTE
	public  ArrayList<Prestamo> mostrarPrestamosID(int libroIDBuscar) throws KrakeDevException{
		ArrayList<Prestamo> prestamos=new ArrayList<Prestamo>();
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		try {
			con=ConexionBDD.conectar();
			String consultaSQL="SELECT id_prestamo, libro_id, usuario, fecha_prestamo, fecha_devolucion, libros.titulo as tituloLibro"
					+ " FROM prestamos, libros"
					+ " WHERE prestamos.libro_id = libros.id_libro"
					+ " and libros.id_libro=?"
					+ " order by prestamos.fecha_prestamo desc";
			ps=con.prepareStatement(consultaSQL);
			ps.setInt(1, libroIDBuscar);
			rs=ps.executeQuery();
			
			while(rs.next()){
				int prestamoID = rs.getInt("id_prestamo");
				int libroID = rs.getInt("libro_id");
				String tituloLibro=rs.getString("tituloLibro");
				String usuario=rs.getString("usuario");
				Date fechaPrestamo = rs.getDate("fecha_prestamo");
				Date fechaDevolucion = rs.getDate("fecha_devolucion");
				
				Libro libro = new Libro();
				libro.setIdlibro(libroID);
				libro.setTitulo(tituloLibro);
				
				Prestamo prestamo=new Prestamo(prestamoID,libro,usuario,fechaPrestamo,fechaDevolucion);
				
				prestamos.add(prestamo);		
			}
			
			LOGGER.trace("RETORNO CON EXITO mostrarPrestamos "+prestamos);
		} catch (KrakeDevException e) {
			throw e;
		} catch (SQLException e) {
			LOGGER.trace("ERROR AL REALIZAR LA CONSULTA SQL mostrarPrestamos");
			throw new KrakeDevException("ERROR AL REALIZAR LA CONSULTA SQL mostrarPrestamos "+e);
		}finally {
			try {
				con.close();
				LOGGER.trace("BDD CERRADO EXITOSAMENTE");
			} catch (SQLException e) {
				throw new KrakeDevException("ERROR AL REALZIAR CIERRE DE BDD"+e);
			}
		}
		return prestamos;
	}
	
	//METODO MOSTRAR PRESTAMOS
	public  ArrayList<Prestamo> mostrarPrestamos() throws KrakeDevException{
		ArrayList<Prestamo> prestamos=new ArrayList<Prestamo>();
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		try {
			con=ConexionBDD.conectarDS();
			String consultaSQL="SELECT id_prestamo, libro_id, usuario, fecha_prestamo, fecha_devolucion, libros.titulo as tituloLibro\r\n"
					+ "	FROM prestamos, libros\r\n"
					+ "	WHERE prestamos.libro_id = libros.id_libro;";
			ps=con.prepareStatement(consultaSQL);
			rs=ps.executeQuery();
			
			while(rs.next()){
				int prestamoID = rs.getInt("id_prestamo");
				int libroID = rs.getInt("libro_id");
				String tituloLibro=rs.getString("tituloLibro");
				String usuario=rs.getString("usuario");
				Date fechaPrestamo = rs.getDate("fecha_prestamo");
				Date fechaDevolucion = rs.getDate("fecha_devolucion");
				
				Libro libro = new Libro();
				libro.setIdlibro(libroID);
				libro.setTitulo(tituloLibro);
				
				Prestamo prestamo=new Prestamo(prestamoID,libro,usuario,fechaPrestamo,fechaDevolucion);
				
				prestamos.add(prestamo);		
			}
			
			LOGGER.trace("RETORNO CON EXITO mostrarPrestamos "+prestamos);
		} catch (KrakeDevException e) {
			throw e;
		} catch (SQLException e) {
			LOGGER.trace("ERROR AL REALIZAR LA CONSULTA SQL mostrarPrestamos");
			throw new KrakeDevException("ERROR AL REALIZAR LA CONSULTA SQL mostrarPrestamos "+e);
		}finally {
			try {
				con.close();
				LOGGER.trace("BDD CERRADO EXITOSAMENTE");
			} catch (SQLException e) {
				throw new KrakeDevException("ERROR AL REALZIAR CIERRE DE BDD"+e);
			}
		}
		return prestamos;
	}
	
	//METODO CONSULTAR POR NOMBRE DE LIBRO 
	public static Libro consultarLibroXnombre(String tituloLibro) throws KrakeDevException {
		Libro libroEncontrado = null;
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		LOGGER.trace("INICIANDO CONCULTA LIBRO X NOMBRE.......>>>>>>>>");
		try {
			LOGGER.trace("CONSULTANDOOO.......>>>>>>>>");
			con=ConexionBDD.conectar();
			String consultaSQL="SELECT id_libro, titulo, autor_id, genero_id, anio_publicacion, estado_disponibilidad"
					+ "	FROM public.libros"
					+ "	WHERE titulo iLIKE ?;";
			ps=con.prepareStatement(consultaSQL);
			ps.setString(1, tituloLibro);
			
			rs=ps.executeQuery();
			if (rs.next()) {
				int libroID=rs.getInt("id_libro");
				String titulo=rs.getString("titulo");
				libroEncontrado=new Libro();
				libroEncontrado.setIdlibro(libroID);
				libroEncontrado.setTitulo(titulo);
				
				//System.out.println("LIBRO ENCONTRADO");
				LOGGER.trace("LIBRO ENCONTRADO.......>>>>>>>>"+libroEncontrado);
			}else {
				//System.out.println("no existe libro");
				LOGGER.trace("LIBRO CONULTADO NO EXSITE.......>>>>>>>>");
			}
			LOGGER.trace("FIN CONSULTA ");
		} catch (KrakeDevException e) {
			throw e;
			
		} catch (SQLException e) {
			throw new KrakeDevException("ERROR AL REALIZAR SQL POR TITULO DE LIBRO"+e);
		}finally {
			try {
				con.close();
				LOGGER.trace("BDD CERRADO EXITOSAMENTE");
			} catch (SQLException e) {
				throw new KrakeDevException("ERROR AL REALZIAR CIERRE DE BDD"+e);
			}
		}
		
		return libroEncontrado;
	}
	
	
	//METODO INSERTAR LIBRO
	public void insertarLibro(Libro libro) throws KrakeDevException{
		Connection con=null;
		PreparedStatement ps=null;
		LOGGER.trace("INICIANDO INSERCION LIBRO .......>>>>>>>>");
		try {
			LOGGER.trace("INSERTANDO LIBRO .. >>>>>>>>>>>>>>>>>>");
			con=ConexionBDD.conectarDS();
			String consultaSQL="INSERT INTO public.libros("
					+ "	titulo, autor_id, genero_id, anio_publicacion, estado_disponibilidad)"
					+ "	VALUES (?, ?, ?, ?, ?);";
			ps=con.prepareStatement(consultaSQL);
			
			ps.setString(1, libro.getTitulo());
			ps.setInt(2, libro.getAutor().getIdAutor());
			ps.setInt(3,libro.getGenero().getIdGenero());
			ps.setInt(4, libro.getAnioPublicacion());
			ps.setBoolean(5, libro.isEstadoDisponibilidad());
			
			ps.executeUpdate();			
			LOGGER.trace("INSERCION LIBRO CON EXITO"+libro);
		} catch (KrakeDevException e) {
			throw e;
		} catch (SQLException e) {
			LOGGER.trace("ERROR AL REALIZAR LA CONSULTA SQL - - INSERT LIBRO"+e);
			throw new KrakeDevException("ERROR AL REALIZAR LA CONSULTA SQL - INSERT LIBRO "+e);
		}finally {
			try {
				con.close();
				LOGGER.trace("BDD CERRADO EXITOSAMENTE");
			} catch (SQLException e) {
				throw new KrakeDevException("ERROR AL REALZIAR CIERRE DE BDD"+e);
			}
		}		
	}
	
	//METODO INSERTAR PRESTAMO
		public static void insertarPrestamo(Prestamo prestamo) throws KrakeDevException{
			Connection con=null;
			PreparedStatement ps=null;
			LOGGER.trace("INICIANDO INSERCION PRESTAMO .......>>>>>>>>");
			try {
				LOGGER.trace("INSERTANDO PRESTAMO.. >>>>>>>>>>>>>>>>>>");
				con=ConexionBDD.conectarDS();
				String consultaSQL="INSERT INTO public.prestamos(\r\n"
						+ "	libro_id, usuario, fecha_prestamo, fecha_devolucion)\r\n"
						+ "	VALUES (?, ?, ?, ?);";
				ps=con.prepareStatement(consultaSQL);
				
				ps.setInt(1, prestamo.getLibro().getIdlibro());
				ps.setString(2, prestamo.getUsuario());
				ps.setDate(3, new java.sql.Date(prestamo.getFechaPrestamo().getTime()));
				ps.setDate(4, new java.sql.Date(prestamo.getFechaDevolucion().getTime()));
				
				ps.executeUpdate();			
				LOGGER.trace("INSERCION CON EXITO"+prestamo);
			} catch (KrakeDevException e) {
				throw e;
			} catch (SQLException e) {
				LOGGER.trace("ERROR AL REALIZAR LA CONSULTA SQL - - INSERT PRESTAMO"+e);
				throw new KrakeDevException("ERROR AL REALIZAR LA CONSULTA SQL - INSERT PRESTAMO "+e);
			}finally {
				try {
					con.close();
					LOGGER.trace("BDD CERRADO EXITOSAMENTE");
				} catch (SQLException e) {
					throw new KrakeDevException("ERROR AL REALIZAR CIERRE DE BDD"+e);
				}
			}			
		}
	
	
		//METODO ACTUALIZAR LIBRO
		public static void actualizarLibro(Libro libro) throws KrakeDevException{
			Connection con=null;
			PreparedStatement ps=null;
			LOGGER.trace("INICIANDO ACTUALIZACION LIBRO .......>>>>>>>>");
			try {
				LOGGER.trace("INSERTANDO ACTUALIZACION .. >>>>>>>>>>>>>>>>>>");
				con=ConexionBDD.conectarDS();
				String consultaSQL="UPDATE public.libros\r\n"
						+ "	SET  titulo=?, autor_id=?, genero_id=?, anio_publicacion=?, estado_disponibilidad=?\r\n"
						+ "	WHERE id_libro=?;";
				ps=con.prepareStatement(consultaSQL);
				
				ps.setString(1, libro.getTitulo());
				ps.setInt(2, libro.getAutor().getIdAutor());
				ps.setInt(3,libro.getGenero().getIdGenero());
				ps.setInt(4, libro.getAnioPublicacion());
				ps.setBoolean(5, libro.isEstadoDisponibilidad());
				ps.setInt(6, libro.getIdlibro());
				
				ps.executeUpdate();			
				LOGGER.trace("ACTUALZIACION CON EXITO"+libro);
				
			} catch (KrakeDevException e) {
				throw e;
			} catch (SQLException e) {
				LOGGER.trace("ERROR AL REALIZAR LA CONSULTA SQL - - ACTUALZIACION"+e);
				throw new KrakeDevException("ERROR AL REALIZAR LA CONSULTA SQL - ACTUALZIACION "+e);
			}finally {
				try {
					con.close();
					LOGGER.trace("BDD CERRADO EXITOSAMENTE");
				} catch (SQLException e) {
					throw new KrakeDevException("ERROR AL REALZIAR CIERRE DE BDD"+e);
				}
			}
		}
	
		
		//METODO ACTUALIZAR PRESTAMO
		public static void actualizarPrestamo(Prestamo prestamo) throws KrakeDevException{
			Connection con=null;
			PreparedStatement ps=null;
			LOGGER.trace("INICIANDO ACTUALIZAR PRESTAMO .......>>>>>>>>");
			try {
				LOGGER.trace("ACTUALIZAR PRESTAMO.. >>>>>>>>>>>>>>>>>>");
				con=ConexionBDD.conectarDS();
				String consultaSQL="UPDATE public.prestamos\r\n"
						+ "	SET libro_id=?, usuario=?, fecha_prestamo=?, fecha_devolucion=?\r\n"
						+ "	WHERE id_prestamo=?;";
				ps=con.prepareStatement(consultaSQL);
				
				ps.setInt(1, prestamo.getLibro().getIdlibro());
				ps.setString(2, prestamo.getUsuario());
				ps.setDate(3, new java.sql.Date(prestamo.getFechaPrestamo().getTime()));
				ps.setDate(4, new java.sql.Date(prestamo.getFechaDevolucion().getTime()));
				ps.setInt(5, prestamo.getIdPrestamo());
				
				ps.executeUpdate();			
				LOGGER.trace("INSERCION CON EXITO ACTUALIZAR "+prestamo);
			} catch (KrakeDevException e) {
				throw e;
			} catch (SQLException e) {
				LOGGER.trace("ERROR AL REALIZAR LA CONSULTA SQL - - ACTUALIZAR PRESTAMO"+e);
				throw new KrakeDevException("ERROR AL REALIZAR LA CONSULTA SQL - ACTUALIZAR PRESTAMO "+e);
			}finally {
				try {
					con.close();
					LOGGER.trace("BDD CERRADO EXITOSAMENTE");
				} catch (SQLException e) {
					throw new KrakeDevException("ERROR AL REALIZAR CIERRE DE BDD"+e);
				}
			}			
		}
	
	
	
	
}
