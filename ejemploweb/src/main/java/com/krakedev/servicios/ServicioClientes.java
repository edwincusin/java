package com.krakedev.servicios;
import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.krakedev.entidades.Cliente;
import com.krakedev.excepciones.KrakDevException;
import com.krakedev.persistencia.ClientesBDD;

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
		Cliente cliente=new Cliente("1753081056","Geovanny",28);
		return cliente;
	}
	
	//METODO INSERTAR CLIENTE
	@Path("minsertar")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	//EN LUGAR DE VOID SE PONDE RESPONSE -- ARMA EL OBJETO DE REPUESTA
	public Response insertar(Cliente cliente) {
		System.out.println(">>>>>"+cliente);
		ClientesBDD cli=new ClientesBDD();
		
		try {
			cli.insertar(cliente);
			return Response.ok().build(); //devuelve un estatus 200 
		} catch (KrakDevException e) {
			e.printStackTrace();
			return Response.serverError().build(); // si algo falla devuelve 500
		}
	}
	
	//METODO ACTUALIZAR CLIENTE
	@Path("mact")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response actualizar(Cliente cliente) {
		System.out.println("ACTUALIZANDO>>>"+cliente);
		ClientesBDD cli= new ClientesBDD();
		try {
			cli.actualizar(cliente);
			return Response.ok().build();
		} catch (KrakDevException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
	}
	
	
	//METODO PARA RETORNAR ARRAY LIST CLIENTE DE TODOS LOS LCIENTES DE LA BDD
	@Path("all")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response obtenerClientes(){
		ClientesBDD cli= new ClientesBDD();
		ArrayList<Cliente> clientes= null;
		try {
			clientes= cli.recuperarTodos();
			return Response.ok(clientes).build();
		} catch (KrakDevException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
	}
	
	
	//METDOO BUSCAR CLIENTE CON NUMERO DE CEDULA
	@Path("buscarPorCedula/{cedulaParam}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscarPorCedula(@PathParam("cedulaParam") String cedula){
		ClientesBDD cli= new ClientesBDD();
		Cliente clientes= null;
		System.out.println("ingresa>>>>>>>>"+cedula);
		try {
			clientes= cli.bucarPorPK(cedula);
			return Response.ok(clientes).build();
		} catch (KrakDevException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
	}
	
	
	//METODO PARA RETORNAR ARRAY LIST CLIENTE POR NUMERO DE HIJOS 
	@Path("buscarPorNumeroHijos/{numeroHijosParam}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscarPorNumeroHijos( @PathParam("numeroHijosParam") int numerohijos){
		ClientesBDD cli= new ClientesBDD();
		ArrayList<Cliente> clientes= null;
		System.out.println("ingresa>>>>>>>>"+numerohijos);
		try {
			clientes= cli.buscarPorNumeroHijos(numerohijos);
			return Response.ok(clientes).build();
		} catch (KrakDevException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
	}
	
		
}

































