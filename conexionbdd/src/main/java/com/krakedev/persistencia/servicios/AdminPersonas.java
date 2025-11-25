package com.krakedev.persistencia.servicios;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.krakedev.persistencia.entidades.EstadoCivil;
import com.krakedev.persistencia.entidades.Persona;
import com.krakedev.persistencia.utils.ConexionBDD;

public class AdminPersonas {
	private static final Logger LOGGER = LogManager.getLogger(AdminPersonas.class);
	//============================METODO ESTATICO INSSERTAR PERSONA EN LA BDD=================================
	public static void insertar(Persona persona) throws Exception {
		Connection con=null;
		PreparedStatement ps=null;	
		LOGGER.trace("PERSONA A INSERTAR>>>>"+persona);
		try {
			// abrir a conexion
			con = ConexionBDD.conectar();
			
			String consutlaSQL ="insert into personas(cedula, nombre, apellido, estatura, cantidad_ahorrada, numero_hijos, estado_civil_codigo, fecha_nacimiento, hora_nacimiento)"
					+"values (?,?,?,?,?,?,?,?,?)";
			
			ps=con.prepareStatement(consutlaSQL);
			//--------lo que vamos a insertar -------------
			ps.setString(1, persona.getCedula());
			ps.setString(2, persona.getNombre());
			ps.setString(3, persona.getApellido());
			ps.setDouble(4, persona.getEstatura());
			ps.setBigDecimal(5, persona.getCantidadAhorrada());
			ps.setInt(6, persona.getNumeroHijos());
			ps.setString(7, persona.getEstadoCivil().getCodigo());
			ps.setDate(8, new java.sql.Date(persona.getFechaNacimiento().getTime()));
			ps.setTime(9,new Time(persona.getHoraNacimiento().getTime()));
			
			// ejecuto lo que prepare para insertar
			ps.executeUpdate();		
			
			//System.out.println("INSERTAR");
		} catch (Exception e) {
			//mostrar el error al usuario el cual devuelvo lo que vino dentro de la excepcion
				//System.out.println(e.getMessage());
				//logear el error
				//e.printStackTrace();en lsugar de esta linea va el LOGGER
				LOGGER.error("ERROR AL INSERTAR",e);
				//propagamos el mensaje de error capturado de a excepcion
				throw new Exception("ERROR AL INSERTAR");
			
		}finally {
			try {
				//cerrar la conexion
				con.close();
				//System.out.println("CONEXION CERRADA");
				LOGGER.trace("CONEXION CERRADA CON EXITO");
			} catch (SQLException e) {
				//e.printStackTrace(); en lsugar de esta linea va el LOGGER
				LOGGER.error("ERROR CON LA BASE DE DATOS (con.close();)",e);
				//System.out.println("ERROR DE INFRAESTRUCTURA");
				//en lugar de imprimir propago la exepcion 
				throw new Exception("ERROR CON LA BASE DE DATOS (con.close();)");
			}
		}

	}
	//=======================FIN METODO ESTATICO INSSERTAR PERSONA EN LA BDD=================================
	
	//=======================METODO ESTATICO ACTUALIZAR PERSONA EN LA BDD=================================
	public static void actualizar(Persona persona) throws Exception {
		Connection con=null;
		PreparedStatement ps=null;	
		LOGGER.trace("PERSONA A ACTUALIZAR / MODIFICAR>>>>"+persona);
		try {
			con = ConexionBDD.conectar();
			String consutlaSQL ="UPDATE personas"
					+ "	SET nombre=?, apellido=?, estatura=?, cantidad_ahorrada=?, numero_hijos=?, estado_civil_codigo=?, fecha_nacimiento=?, hora_nacimiento=?"
					+ "	WHERE cedula=?;";
			
			ps=con.prepareStatement(consutlaSQL);
			//--------lo que vamos a modificar -------------
			
			ps.setString(1, persona.getNombre());
			ps.setString(2, persona.getApellido());
			ps.setDouble(3, persona.getEstatura());
			ps.setBigDecimal(4, persona.getCantidadAhorrada());
			ps.setInt(5, persona.getNumeroHijos());
			ps.setString(6, persona.getEstadoCivil().getCodigo());
			ps.setDate(7, new java.sql.Date(persona.getFechaNacimiento().getTime()));
			ps.setTime(8,new Time(persona.getHoraNacimiento().getTime()));
			ps.setString(9, persona.getCedula());
			
			ps.executeUpdate();		
			LOGGER.trace("PERSONA ACTUALIZADA CON EXITO: "+persona);
		} catch (Exception e) {
				LOGGER.error("ERROR AL ACTUALIZAR/MODIFICAR",e);
				throw new Exception("ERROR AL ACTUALIZAR/MODIFICAR");
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
	
	//======================= FIN METODO ESTATICO ACTUALIZAR PERSONA EN LA BDD=================================
	
	//=======================  METODO ESTATICO ELIMINAR PERSONA EN LA BDD=================================
	public static void eliminar(Persona persona) throws Exception {
		Connection con=null;
		PreparedStatement ps=null;	
		LOGGER.trace("PERSONA CON CEDULA A ELIMINAR>>>>"+persona.getCedula());
		try {
			con = ConexionBDD.conectar();
			String consutlaSQL ="DELETE FROM personas"
					+ "	WHERE cedula=?;";
			
			ps=con.prepareStatement(consutlaSQL);
			//--------lo que vamos a eliminar -------------

			ps.setString(1, persona.getCedula());
			
			ps.executeUpdate();
			LOGGER.trace("PERSONA ELIMINADA CON EXITO: "+persona.getCedula());
		} catch (Exception e) {
				LOGGER.error("ERROR AL ELIMINAR",e);
				throw new Exception("ERROR AL ELIMINARR");
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
	//=======================  FIN METODO ESTATICO ELIMINAR PERSONA EN LA BDD=================================
	
	//=======================  METODO ESTATICO CONSULTAS PERSONA EN LA BDD=================================
	 public static ArrayList<Persona> buscarPorNombre(String nombreBusqueda) throws Exception{
		ArrayList<Persona> personas = new ArrayList<Persona>();
		Connection con=null;
		PreparedStatement ps=null;	
		ResultSet rs=null;
		
		try {
			con=ConexionBDD.conectar();
			String consultaSQL=" SELECT * FROM personas "
					+ "WHERE nombre ILIKE ?";
			ps=con.prepareStatement(consultaSQL);
			
			ps.setString(1, "%"+nombreBusqueda+"%");
			
			rs=ps.executeQuery();
			//BARRER TODO EL RESULSET
			while (rs.next()) {
				String nombre= rs.getString("nombre");
				String cedula=rs.getString("cedula");
				Persona p=new Persona();
				p.setNombre(nombre);
				p.setCedula(cedula);
				personas.add(p);
			}
			
		} catch (Exception e) {
			LOGGER.error("ERROR AL CONSULTAR POR NOMBRE",e);
			throw new Exception("ERROR AL CONSULTAR POR NOMBRE");
		}finally {
			try {
				con.close();
				LOGGER.trace("CONEXION CERRADA CON EXITO");
			} catch (SQLException e) {
				LOGGER.error("ERROR CON LA BASE DE DATOS (con.close();)",e);
				throw new Exception("ERROR CON LA BASE DE DATOS (con.close();)");
			}
		}			 
		 return personas;
	 }
	
//=======================  FIN METODO ESTATICO CONSULTAS PERSONA EN LA BDD=================================
	 
 //=================== RETO 33 METODO ESTATICO CONSULTAS PERSONA CEDULA CLAVE PRIMARIA EN LA BDD===================

	 public static Persona buscarPorCedula(String cedulaBuscar) throws Exception{
			Persona persona= null;
			Connection con=null;
			PreparedStatement ps=null;	
			ResultSet rs=null;
			LOGGER.trace("BUSCAR PERSONA CON CEDULA>>>>"+cedulaBuscar);
			try {
				con=ConexionBDD.conectar();
				String consultaSQL="SELECT cedula, nombre, apellido, estatura, fecha_nacimiento, hora_nacimiento, CAST(cantidad_ahorrada as decimal) as cantidad_ahorrada, numero_hijos, estado_civil_codigo"
						+ "	FROM public.personas "
						+ "	where cedula= ?;";				
				ps=con.prepareStatement(consultaSQL);
				
				ps.setString(1, cedulaBuscar);
				
				rs=ps.executeQuery();
				
				if (rs.next()) {
					persona= new Persona();
					
					String cedula=rs.getString("cedula");
					persona.setCedula(cedula);
					
					String nombre=rs.getString("nombre");
					persona.setNombre(nombre);
					
					String apellido=rs.getString("apellido");
					persona.setApellido(apellido);
					
					double estatura=rs.getDouble("estatura");
					persona.setEstatura(estatura);
					
					Date fechaNacimiento=rs.getDate("fecha_nacimiento");
					persona.setFechaNacimiento(fechaNacimiento);
					
					Date horaNacimiento=rs.getTime("hora_nacimiento");
					persona.setHoraNacimiento(horaNacimiento);
					
					BigDecimal cantidadAhorrada =rs.getBigDecimal("cantidad_ahorrada"); // convertir en la cosulta a decimal o numeric
					persona.setCantidadAhorrada(cantidadAhorrada);
					
					int numeroHijos =rs.getInt("numero_hijos");
					persona.setNumeroHijos(numeroHijos);
					
					
					String codigoEstadoCivil=rs.getString("estado_civil_codigo");
					EstadoCivil ec=new EstadoCivil(codigoEstadoCivil,codigoEstadoCivil);
					persona.setEstadoCivil(ec);

				}
				LOGGER.trace("REGISTRO ENCONTRADO" +persona);
			} catch (Exception e) {
				LOGGER.error("ERROR AL CONSULTAR POR CEDULA",e);
				throw new Exception("ERROR AL CONSULTAR POR CEDULA");
			}finally {
				try {
					con.close();
					LOGGER.trace("CONEXION CERRADA CON EXITO");
				} catch (SQLException e) {
					LOGGER.error("ERROR CON LA BASE DE DATOS (con.close();)",e);
					throw new Exception("ERROR CON LA BASE DE DATOS (con.close();)");
				}
			}			 
			 return persona;
		 }
	
	//=================== FIN METODO ESTATICO CONSULTAS PERSONA CEDULA CLAVE PRIMARIA EN LA BDD===================

	//=================== RETO 33 METODO ESTATICO CONSULTAS VARIOS REGISTROS EN LA BDD===================
	// POR RANGO EN FECHA NACIMIENTO
	 public static ArrayList<Persona> buscarRangoFechaNacimiento(Date fechaInicio, Date fechaFin) throws Exception{
		ArrayList<Persona> personas = new ArrayList<Persona>();
		Connection con=null;
		PreparedStatement ps=null;	
		ResultSet rs=null;
		LOGGER.trace("BUSCAR PERSONA CON RANGO FECHA NACIMIENTO >>>>"+ fechaInicio +" -- " +fechaFin );
		try {
			con=ConexionBDD.conectar();
			String consultaSQL=" SELECT cedula, nombre, apellido, estatura, fecha_nacimiento, hora_nacimiento, CAST(cantidad_ahorrada as decimal) as cantidad_ahorrada, numero_hijos, estado_civil_codigo"
					+ "	FROM public.personas "
					+ "	WHERE fecha_nacimiento "
					+ "	BETWEEN ? AND ?;";
			ps=con.prepareStatement(consultaSQL);
			
			ps.setDate(1,new java.sql.Date(fechaInicio.getTime()));
			ps.setDate(2, new java.sql.Date(fechaFin.getTime()));
			
			rs=ps.executeQuery();
			while (rs.next()) {
				Persona persona= new Persona();
				
				String cedula=rs.getString("cedula");
				persona.setCedula(cedula);
				
				String nombre=rs.getString("nombre");
				persona.setNombre(nombre);
				
				String apellido=rs.getString("apellido");
				persona.setApellido(apellido);
				
				double estatura=rs.getDouble("estatura");
				persona.setEstatura(estatura);
				
				Date fechaNacimiento=rs.getDate("fecha_nacimiento");
				persona.setFechaNacimiento(fechaNacimiento);
				
				Date horaNacimiento=rs.getTime("hora_nacimiento");
				persona.setHoraNacimiento(horaNacimiento);
				
				BigDecimal cantidadAhorrada =rs.getBigDecimal("cantidad_ahorrada"); // convertir en la cosulta a decimal o numeric
				persona.setCantidadAhorrada(cantidadAhorrada);
				
				
				int numeroHijos =rs.getInt("numero_hijos");
				persona.setNumeroHijos(numeroHijos);
				
				
				String codigoEstadoCivil=rs.getString("estado_civil_codigo");
				EstadoCivil ec=new EstadoCivil(codigoEstadoCivil,codigoEstadoCivil);
				persona.setEstadoCivil(ec);
				
				personas.add(persona);
			}
			
			LOGGER.trace("RESGISTROS ENCONTRADOS "+personas);
		} catch (Exception e) {
			LOGGER.error("ERROR AL CONSULTAR POR RANGO FECHA NAC",e);
			throw new Exception("ERROR AL CONSULTAR POR RANGO FECHA ");
		}finally {
			try {
				con.close();
				LOGGER.trace("CONEXION CERRADA CON EXITO");
			} catch (SQLException e) {
				LOGGER.error("ERROR CON LA BASE DE DATOS (con.close();)",e);
				throw new Exception("ERROR CON LA BASE DE DATOS (con.close();)");
			}
		}			 
		 return personas;
		 
	 }
	 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
