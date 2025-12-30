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

import com.krakedev.moduloii.evaluacionfinal.entidades.Autor;
import com.krakedev.moduloii.evaluacionfinal.excepciones.KrakeDevException;
import com.krakedev.moduloii.evaluacionfinal.servicios.ServicioAutor;

@Path("autores")
public class TestAutor {
	// METODO POST
	@Path("insertar")
	@POST
	// FORMATO EN EL QUE VA A LLEGAR EL OBJETO
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insertar(Autor autor) {
		System.out.println("Autor Agregado: " + autor);
		ServicioAutor serv = new ServicioAutor();
		try {
			serv.insertar(autor);
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
	public Response actualizar(Autor autor) {
		System.out.println("Autor Actualizado: " + autor);
		ServicioAutor serv = new ServicioAutor();
		try {
			serv.actualizar(autor);
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
	public Response obtenerAutores() {
		ServicioAutor serv = new ServicioAutor();
		ArrayList<Autor> autores = new ArrayList<Autor>();
		try {
			autores = serv.recuperarTodos();
			// DEVOLVER LOS ENOCNTRADOS
			return Response.ok(autores).build();
		} catch (KrakeDevException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
	}

	// METODO DELETE
	@Path("delete/{id}")
	@DELETE
	public Response eliminar(@PathParam("id") int id) {
		System.out.println("Autor a eliminar: ID = " + id);
		ServicioAutor serv = new ServicioAutor();
		try {
			serv.eliminar(id);
			return Response.ok().build();
		} catch (KrakeDevException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
	}
}
