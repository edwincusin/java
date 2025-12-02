package com.krakedev.servicios;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.krakedev.entidades.Cliente;

@Path("clientes")
public class ServicioClientes {
	
	@Path("metodo1")
	@GET
	public String saludar() {
		return "Hola Edwin Cusin";
	}
	
	@Path("mbuscar")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Cliente buscar() {
		Cliente cliente=new Cliente("1753081056","Geovanny");
		return cliente;
	}
	
	//METODO INSERTAR CLIENTE
	@Path("minsertar")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void insertar(Cliente cliente) {
		System.out.println(">>>>>"+cliente);
	}
	
	//METODO ACTUALIZAR CLIENTE
	@Path("mact")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public void actualizar(Cliente cliente) {
		System.out.println("ACTUALIZANDO>>>"+cliente);
	}
		
}
