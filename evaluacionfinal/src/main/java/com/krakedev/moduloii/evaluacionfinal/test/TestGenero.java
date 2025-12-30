package com.krakedev.moduloii.evaluacionfinal.test;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.krakedev.moduloii.evaluacionfinal.entidades.Genero;
import com.krakedev.moduloii.evaluacionfinal.excepciones.KrakeDevException;
import com.krakedev.moduloii.evaluacionfinal.servicios.ServicioGenero;

@Path("generos")
public class TestGenero {
	// METODO POST
	@Path("insertar")
	@POST
	// FORMATO EN EL QUE VA A LLEGAR EL OBJETO
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insertar(Genero genero) {
		System.out.println("Genero Agregado: " + genero);
		ServicioGenero serv = new ServicioGenero();
		try {
			serv.insertar(genero);
			// DEVOLVER EXITOSO
			return Response.ok().build();
		} catch (KrakeDevException e) {
			e.printStackTrace();
			// DEVOLVER ERROR 500
			return Response.serverError().build();
		}
	}

	// METODO PUT
	@Path("act")
	@PUT
	// FORMATO EN EL QUE VA A LLEGAR EL OBJETO
	@Consumes(MediaType.APPLICATION_JSON)
	public Response actualizar(Genero genero) {
		System.out.println("Genero Actualizado: " + genero);
		ServicioGenero serv = new ServicioGenero();
		try {
			serv.actualizar(genero);
			// DEVOLVER EXITOSO
			return Response.ok().build();
		} catch (KrakeDevException e) {
			e.printStackTrace();
			// DEVOLVER ERROR 500
			return Response.serverError().build();
		}
	}

	@Path("all")
	@GET
	// ESPECIFICACION DE RETORNO DEL METODO DEL TIPO DESEADO (JSON)
	@Produces(MediaType.APPLICATION_JSON)
	// METODO PARA CONSULTAR EN LA BASE DE DATOS
	public Response obtenerGeneros() {
		ServicioGenero serv = new ServicioGenero();
		ArrayList<Genero> generos = new ArrayList<Genero>();
		try {
			generos = serv.recuperarTodos();
			// DEVOLVER LOS ENOCNTRADOS
			return Response.ok(generos).build();
		} catch (KrakeDevException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
	}

	// METODO DELETE
	@Path("delete/{id}")
	@DELETE
	public Response eliminar(@PathParam("id") int id) {
		System.out.println("GENERO a eliminar: ID = " + id);
		ServicioGenero serv = new ServicioGenero();
		try {
			serv.eliminar(id);
			return Response.ok().build();
		} catch (KrakeDevException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
	}
	
	// METODO DELETE SEGURO
	@Path("delete-seguro/{id}")
	@DELETE
	public Response eliminarSeguro(@PathParam("id") int id) {
		System.out.println("GENERO a eliminar (SEGURO): ID = " + id);
		ServicioGenero serv = new ServicioGenero();
		try {
			serv.eliminarGeneroSeguro(id);
			return Response.ok().build();
		} catch (KrakeDevException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
	}

}
