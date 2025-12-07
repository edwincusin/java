package com.krakedev.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.krakedev.entidades.Cliente;
import com.krakedev.excepciones.KrakDevException;
import com.krakedev.utils.ConexionBDD;

public class ClientesBDD {
	
	//METODO INSERTAR CLIENTE
	public void insertar(Cliente cliente) throws KrakDevException {
		Connection con= null; 
		PreparedStatement ps=null;
		try {
			con=ConexionBDD.obtenerConexion();
			String consultaSQL="INSERT INTO public.clientes("
					+ "	cedula, nombre, numerohijos)"
					+ "	VALUES (?, ?, ?);";
			ps=con.prepareStatement(consultaSQL);
			
			ps.setString(1, cliente.getCedula());
			ps.setString(2, cliente.getNombre());
			ps.setInt(3, cliente.getNumeroHijos());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new KrakDevException("ERROR AL INSERTAR EL CLIENTE . DELTALLE: "+e.getMessage());
		} catch (KrakDevException e) {
			e.printStackTrace();
			throw e; //relanzo la excepcion
		}finally {

				if(con != null) {
					try {
						con.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
		}				
	}
	
	//METODO ACTUALIZAR CLIENTE
	public void actualizar(Cliente cliente) throws KrakDevException {
		Connection con= null; 
		PreparedStatement ps=null;
		try {
			con=ConexionBDD.obtenerConexion();
			String consultaSQL="UPDATE public.clientes"
					+ "	SET nombre=?, numerohijos=?"
					+ "	WHERE cedula=?;";
			ps=con.prepareStatement(consultaSQL);
			
			
			ps.setString(1, cliente.getNombre());
			ps.setInt(2, cliente.getNumeroHijos());
			ps.setString(3, cliente.getCedula());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new KrakDevException("ERROR AL ACTUALIZAR CLIENTE. DELTALLE: "+e.getMessage());
		} catch (KrakDevException e) {
			e.printStackTrace();
			throw e; //relanzo la excepcion
		}finally {

			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
		}
	}
	
	//METODO CONSULTAR TODOS LOS CLIENTES 
	public ArrayList<Cliente> recuperarTodos() throws KrakDevException{
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			con=ConexionBDD.obtenerConexion();
			String consultaSQL="SELECT cedula, nombre, numerohijos"
					+ "	FROM public.clientes;";
			ps=con.prepareStatement(consultaSQL);
			rs=ps.executeQuery();
			
			while(rs.next()) {
				String cedula=rs.getString("cedula");
				String nombre=rs.getString("nombre");
				int numeroHijos=rs.getInt("numerohijos");
				Cliente cliente=new Cliente(cedula, nombre,numeroHijos);
				clientes.add(cliente);				
			}
			
		} catch (KrakDevException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new KrakDevException("ERROR AL CONSULTAR CLIENTES. DETALLE : "+e.getMessage());
		}
		
		return clientes;
	}
	
	
	//METODO CONSULTAR CLIENTE POR CEDULA  
	public Cliente bucarPorPK(String cedulaBusqueda) throws KrakDevException{
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Cliente cliente=null;
		try {
			con=ConexionBDD.obtenerConexion();
			String consultaSQL="SELECT cedula, nombre, numerohijos"
					+ "	FROM public.clientes"
					+ " WHERE cedula=?;";
			ps=con.prepareStatement(consultaSQL);
			
			ps.setString(1, cedulaBusqueda);
			
			rs=ps.executeQuery();
			
			if(rs.next()) {
				System.out.println("exsite el cliente>>>>>>>>");
				String cedula=rs.getString("cedula");
				String nombre=rs.getString("nombre");
				int numeroHijos=rs.getInt("numerohijos");
				cliente=new Cliente(cedula, nombre,numeroHijos);			
			}else {
				System.out.println("cliente no existe");
			}
			
		} catch (KrakDevException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new KrakDevException("ERROR AL CONSULTAR CLIENTE POR NUMERO DE CEDULA. DETALLE : "+e.getMessage());
		}
		
		return cliente;
	}
	
	//METODO CONSULTAR CLIENTE POR NUMERO DE HIJOS
	public ArrayList<Cliente> buscarPorNumeroHijos(int numeroHijosBuscar) throws KrakDevException{
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		try {
			con=ConexionBDD.obtenerConexion();
			String consultaSQL="SELECT cedula, nombre, numerohijos"
					+ "	FROM public.clientes"
					+ " WHERE numerohijos>=?;";
			ps=con.prepareStatement(consultaSQL);
			
			ps.setInt(1, numeroHijosBuscar);
			
			rs=ps.executeQuery();
			
			while(rs.next()) {
				String cedula=rs.getString("cedula");
				String nombre=rs.getString("nombre");
				int numeroHijos=rs.getInt("numerohijos");
				Cliente cliente=new Cliente(cedula, nombre,numeroHijos);
				
				clientes.add(cliente);
			}
			
		} catch (KrakDevException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new KrakDevException("ERROR AL CONSULTAR CLIENTES POR NUMERO HIJOS. DETALLE : "+e.getMessage());
		}
		
		return clientes;
	}
	
	
	
	
	
}



















