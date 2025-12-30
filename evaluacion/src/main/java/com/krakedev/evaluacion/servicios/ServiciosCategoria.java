package com.krakedev.evaluacion.servicios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.krakedev.evaluacion.entidades.Categoria;
import com.krakedev.evaluacion.excepciones.KrakeException;
import com.krakedev.evaluacion.utils.ConexionBDD;

public class ServiciosCategoria {
	private static final Logger LOGGER = LogManager.getLogger(ConexionBDD.class);
	
	//METODO INSERTAR EN LA BDD
	public static void insertar(Categoria categoria) throws KrakeException {
		 Connection con = null;
		 PreparedStatement ps=null;
		 LOGGER.trace("INSERTANDO CATEGORIA>>>>>>>>>>> "+categoria);
		 try {
			con=ConexionBDD.conectar();
			String consultaSQL="INSERT INTO public.categorias(id, nombre)"
					+ "	VALUES (?, ?);";
			ps=con.prepareStatement(consultaSQL);
			
			ps.setString(1, categoria.getIdCategoria());
			ps.setString(2, categoria.getNombre());
			
			ps.executeUpdate();
			
			LOGGER.trace("CATEGORIA INSERTADA CON EXITO>>>>>>>>>>>|| OK : "+categoria);
		} catch (KrakeException e) {
			throw e;
		} catch (SQLException e) {
			LOGGER.trace("ERROR AL INSERTAR CATEGORIA ",e);
			throw new KrakeException("ERROR AL INSERTAR CATEGORIA : ");
		}finally {
			//cerrar conexion
			if(con!=null) {
				try {
					con.close();
					LOGGER.trace("CONEXION CERRADA SIN NOVEDAD || OK ");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
					LOGGER.trace("ERROR CERRAR LA BASE DE DATOS");
					throw new KrakeException("ERROR AL CERRAR  LA BASE DE DATOS "+e);
				}
			}else {
				LOGGER.trace("CONEXION NULL");
			}

		}
	}
	
	//METODO ACTUALIZAR
	public static void actualizar(Categoria categoria) throws KrakeException {
		 Connection con = null;
		 PreparedStatement ps=null;
		 LOGGER.trace("ACTUALZIANDO.. CATEGORIA>>>>>>>>>>> "+categoria);
		 try {
			con=ConexionBDD.conectar();
			String consultaSQL="UPDATE public.categorias"
					+ "	SET nombre=?"
					+ "	WHERE id=?;";
			ps=con.prepareStatement(consultaSQL);
			
			ps.setString(1, categoria.getNombre());
			ps.setString(2, categoria.getIdCategoria());
			
			ps.executeUpdate();
			
			LOGGER.trace("CATEGORIA ACTUALIZADA CON EXITO>>>>>>>>>>>|| OK : "+categoria);
		} catch (KrakeException e) {
			throw e;
		} catch (SQLException e) {
			LOGGER.trace("ERROR AL ACTUALIZAR CATEGORIA ",e);
			throw new KrakeException("ERROR AL INSERTAR CATEGORIA : ");
		}finally {
			//cerrar conexion
			if(con!=null) {
				try {
					con.close();
					LOGGER.trace("CONEXION CERRADA SIN NOVEDAD || OK ");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
					LOGGER.trace("ERROR CERRAR LA BASE DE DATOS"+e);
					throw new KrakeException("ERROR AL CERRAR  LA BASE DE DATOS "+e);
				}
			}else {
				LOGGER.trace("CONEXION NULL");
			}

		}
	}
	
	//METODO BUSCAR POR ID
	public  static Categoria buscarPorId(String idCategoriaBuscar) throws KrakeException {
		 Connection con = null;
		 PreparedStatement ps=null;
		 ResultSet rs=null;
		 Categoria categoriaEncontrada= null;
		 LOGGER.trace("BUSCANDO CATEGORIA CON ID >>>>>>>>>>> "+idCategoriaBuscar);
		 try {
			con=ConexionBDD.conectar();

			
			String consultaSQL="SELECT id, nombre"
					+ "	FROM public.categorias"
					+ " WHERE id=? ;";
			ps=con.prepareStatement(consultaSQL);
			
			ps.setString(1, idCategoriaBuscar);
			rs=ps.executeQuery();
			
			if(rs.next()) {
				categoriaEncontrada=new Categoria();
				String idCategoria=rs.getString("id");
				String nombreCategoria=rs.getString("nombre");
				categoriaEncontrada.setIdCategoria(idCategoria);
				categoriaEncontrada.setNombre(nombreCategoria);
			}
						
			LOGGER.trace("CATEGORIA ENCONTRADA CON EXITO>>>>>>>>>>>|| OK : "+categoriaEncontrada);
		} catch (KrakeException e) {
			throw e;
		} catch (SQLException e) {
			LOGGER.trace("ERROR AL CONSULTAR CATEGORIA ",e);
			throw new KrakeException("ERROR AL CONSUTLAR CATEGORIA : ");
		}finally {
			//cerrar conexion
			if(con!=null) {
				try {
					con.close();
					LOGGER.trace("CONEXION CERRADA SIN NOVEDAD || OK ");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
					LOGGER.trace("ERROR CERRAR LA BASE DE DATOS"+e);
					throw new KrakeException("ERROR AL CERRAR  LA BASE DE DATOS "+e);
				}
			}else {
				LOGGER.trace("CONEXION NULL");
			}

		}
		 return categoriaEncontrada;
	}
	
	//METODO RECUPERAR TODOS
	public  static ArrayList<Categoria> recuperarTodos() throws KrakeException {
		 Connection con = null;
		 PreparedStatement ps=null;
		 ResultSet rs=null;
		 ArrayList<Categoria> categorias= new ArrayList<Categoria>();
		 LOGGER.trace("TRAYENDO TODAS LAS CATEGORIAS  >>>>>>>>>>> ");
		 try {
			con=ConexionBDD.conectar();

			
			String consultaSQL="SELECT id, nombre"
					+ "	FROM public.categorias;";
			ps=con.prepareStatement(consultaSQL);
			
			rs=ps.executeQuery();
			
			while(rs.next()) {
				Categoria categoria=new Categoria();
				
				String idCategoria=rs.getString("id");
				String nombreCategoria=rs.getString("nombre");
				categoria.setIdCategoria(idCategoria);
				categoria.setNombre(nombreCategoria);
				
				categorias.add(categoria);
			}
						
			LOGGER.trace("CATEGORIA EXTRAIDAS CON EXITO>>>>>>>>>>>|| OK : ");
		} catch (KrakeException e) {
			throw e;
		} catch (SQLException e) {
			LOGGER.trace("ERROR AL CONSULTAR CATEGORIAS ",e);
			throw new KrakeException("ERROR AL CONSUTLAR CATEGORIAS : ");
		}finally {
			//cerrar conexion
			if(con!=null) {
				try {
					con.close();
					LOGGER.trace("CONEXION CERRADA SIN NOVEDAD || OK ");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
					LOGGER.trace("ERROR CERRAR LA BASE DE DATOS"+e);
					throw new KrakeException("ERROR AL CERRAR  LA BASE DE DATOS "+e);
				}
			}else {
				LOGGER.trace("CONEXION NULL");
			}

		}
		 return categorias;
	}
	
}
