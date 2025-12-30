package com.krakedev.moduloii.evaluacionfinal.test;

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

import com.krakedev.moduloii.evaluacionfinal.entidades.Libro;
import com.krakedev.moduloii.evaluacionfinal.excepciones.KrakeDevException;
import com.krakedev.moduloii.evaluacionfinal.servicios.ServicioLibro;

@Path("libros")
public class TestLibro {
	// METODO POST
	@Path("insertar")
	@POST
	// FORMATO EN EL QUE VA A LLEGAR EL OBJETO
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insertar(Libro libro) {
		System.out.println("Libro Agregado: " + libro);
		ServicioLibro serv = new ServicioLibro();
		try {
			serv.insertar(libro);
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
	public Response actualizar(Libro libro) {
		System.out.println("Libro Actualizado: " + libro);
		ServicioLibro serv = new ServicioLibro();
		try {
			serv.actualizar(libro);
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
	public Response obtenerLibros() {
		ServicioLibro serv = new ServicioLibro();
		ArrayList<Libro> libros = new ArrayList<Libro>();
		try {
			libros = serv.recuperarTodos();
			// DEVOLVER LOS ENOCNTRADOS
			return Response.ok(libros).build();
		} catch (KrakeDevException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
	}

	// CONTAR LIBROS POR GENERO
	@Path("count/{idGenero}")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public Response contarLibrosPorGenero(@PathParam("idGenero") int idGenero) {
		ServicioLibro serv = new ServicioLibro();
		try {
			int total = serv.contarLibrosPorGenero(idGenero);
			return Response.ok("Total de libros: " + total).build();
		} catch (KrakeDevException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
	}

}
