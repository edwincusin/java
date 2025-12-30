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

import com.krakedev.moduloii.evaluacionfinal.entidades.Prestamo;
import com.krakedev.moduloii.evaluacionfinal.excepciones.KrakeDevException;
import com.krakedev.moduloii.evaluacionfinal.servicios.ServicioPrestamo;

@Path("prestamos")
public class TestPrestamo {
	// METODO POST
	@Path("insertar")
	@POST
	// FORMATO EN EL QUE VA A LLEGAR EL OBJETO
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insertar(Prestamo prestamo) {
		System.out.println("Prestamo Agregado: " + prestamo);
		ServicioPrestamo serv = new ServicioPrestamo();
		try {
			serv.insertar(prestamo);
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
	public Response actualizar(Prestamo prestamo) {
		System.out.println("Prestamo Actualizado: " + prestamo);
		ServicioPrestamo serv = new ServicioPrestamo();
		try {
			serv.actualizar(prestamo);
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
	public Response obtenerPrestamos() {
		ServicioPrestamo serv = new ServicioPrestamo();
		ArrayList<Prestamo> prestamos = new ArrayList<Prestamo>();
		try {
			prestamos = serv.recuperarTodos();
			// DEVOLVER LOS ENOCNTRADOS
			return Response.ok(prestamos).build();
		} catch (KrakeDevException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
	}

	// METODO CONSULTA POR ID
	@Path("libro/{id}")
	@GET
	// ESPECIFICACION DE RETORNO DEL METODO DEL TIPO DESEADO (JSON)
	@Produces(MediaType.APPLICATION_JSON)
	// METODO PARA CONSULTAR EN LA BASE DE DATOS
	public Response prestamosPorID(@PathParam("id") int id) {
		System.out.println("Consultas por: ID = " + id);
		ServicioPrestamo serv = new ServicioPrestamo();
		ArrayList<Prestamo> prestamos = new ArrayList<Prestamo>();
		try {
			prestamos = serv.consultarPrestamos(id);
			// SI NO SE ECNOTRARON
			if (prestamos.isEmpty()) {
				return Response.status(Response.Status.NOT_FOUND)
						.entity("No se encontraron préstamos para el libro con ID: " + id)
						.build();
			}
			// DEVOLVER LOS ENCONTRADOS
			return Response.ok(prestamos).build();
		} catch (KrakeDevException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
	}

}
