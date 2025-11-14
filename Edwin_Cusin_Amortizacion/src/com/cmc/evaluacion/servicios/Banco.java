package com.cmc.evaluacion.servicios;
import java.util.ArrayList;
import java.util.Iterator;

import com.cmc.evaluacion.entidades.Cliente;
import com.cmc.evaluacion.entidades.Prestamo;

public class Banco {
	//ArrayList<Prestamo> prestamos;
	private ArrayList<Cliente> clientes;
	
	

	//CONSTRUCTOR POR DEFECTO PARA INICIALIZAR LOS ARRAYS
	public Banco() {
		//prestamos=new ArrayList<Prestamo>();
		clientes=new ArrayList<Cliente>();
	}
	
	//METODO BUSCAR CLIENTE
	public Cliente buscarCliente(String cedulaCliente) {
		
		for(Cliente elementoCliente : clientes) {
			if (elementoCliente.getCedula().equals(cedulaCliente)) {
				return elementoCliente;
			}
		}
		return null;
	}
	
	//METODO REGISTRAR CLIENTE
	public void registrarCliente(Cliente cliente) {
		
		if(buscarCliente(cliente.getCedula())==null) {
			System.out.print("CLIENTE REGISTRADO: ");
			clientes.add(cliente);
		}else {
			System.err.println("Cliente Ya existe intenta nuevamente");
		}
	}
	
	//METODO ASIGNAR PRESTAMO AL CLIENTE 
	public void asignarPrestamo(String cedulaCliente, Prestamo prestamo) {
		Cliente clienteRecuperado=buscarCliente(cedulaCliente);
		if(clienteRecuperado!=null &&
				prestamo!=null) {
			clienteRecuperado.getPrestamos().add(prestamo);
			 CalculadoraAmortizacion.generarTabla(prestamo);
		}else {
			System.err.println("NO ES CLIENTE DEL BANCO || Prestamo es null");
		}
	}
	
	//METODO BUSCAR PRESTAMOS
	public ArrayList<Prestamo> buscarPrestamos(String cedulaCliente){
		ArrayList<Prestamo> prestamosCliente=new ArrayList<Prestamo>();
		Cliente clienteRecuperado=buscarCliente(cedulaCliente);
		if(clienteRecuperado.getPrestamos()!=null) {
			prestamosCliente=clienteRecuperado.getPrestamos();
			return prestamosCliente;
		}else {
			System.err.println("cliente no tiene prestamos");
			return null;
		}
		
		
	}
	
	
	
	
	
	
	//METODOS GET Y SET


	public ArrayList<Cliente> getClientes() {
		return clientes;
	}
	
	
	
	
	
	
	
}
