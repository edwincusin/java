package com.krakedev.repasoii.servicioLibro;



import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.krakedev.repasoii.entidades.Libro;
import com.krakedev.repasoii.entidades.Prestamo;
import com.krakedev.repasoii.repasofinal.excepciones.KrakeDevException;
import com.krakedev.repasoii.serviciosAdm.AdminServiciosLibro;

@Path("Servicioslibro")
public class ServiciosLibro {
	
	
	@Path("saludar")
	@GET
	public String saludar() {
		return "Hola Edwin Cusin";
	}
	
	
	//SERVICIO METODO INSERTAR LIBRO
	@Path("insertarLibro")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insertarLibro(Libro libroInsertar) {
		System.out.println("Insertando >>>>"+libroInsertar);
		AdminServiciosLibro libro= new AdminServiciosLibro();
		Libro libroExiste= new Libro();	
		
		try {
			libroExiste=AdminServiciosLibro.consultarLibroXnombre(libroInsertar.getTitulo());
			if (libroExiste ==null) {
				libro.insertarLibro(libroInsertar);
				System.out.println("LIBRO INSERTADO CON EXITO");
			}else {
				System.out.println("IMPOSIBLE INSERTAR, YA EXISTE OTRO LIBRO CON EL MISMO NOMBRE, INTENTA NUEVAMENTE");
			}			
			return Response.ok().build();  //devuelve un estatus 200 
		} catch (KrakeDevException e) {
			e.printStackTrace();
			return Response.serverError().build();  // si algo falla devuelve 500
		}		
	}
	
	private static final String USUARIO="edwin";
	private static final String CONTRASENA="cusin";
	
	
	//SERVICIO METODO CONSULTAR PRESTAMOD POR ID
	@Path("consultarPrestamos/{usuario}/{contrasena}/{libroID}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response consultarPrestamosIDDeLibro(@PathParam("usuario") String usuario,@PathParam("contrasena") String contrasena, @PathParam("libroID")  int libroIDBuscar) {
		
		if (USUARIO.equals(usuario) && CONTRASENA.equals(contrasena)) {
			System.out.println("CONSULTANDO LIBROS CON LA ID >>>>"+libroIDBuscar);		
			AdminServiciosLibro admServicios= new AdminServiciosLibro();
			
			try {
					ArrayList<Prestamo> prestamos= admServicios.mostrarPrestamosID(libroIDBuscar);
					if(prestamos.size()!=0) {
						return Response.ok(prestamos).build();  //devuelve un estatus 200 
					}else {
						return Response.ok("NO SE ENCOTRARON PRESTAMOS").build();  //devuelve un estatus 200
					}				
				
			} catch (KrakeDevException e) {
				e.printStackTrace();
				return Response.serverError().build();  // si algo falla devuelve 500
			}		
		}else {
			System.out.println("USUARIO O CONTRASEÑA ERRROR");		
		
			return Response.ok("USUARIO O CONTRASEÑA ERRROR").build();  //devuelve un estatus 200
				
		}
		

		
		
		
	}
	
	
	
	
	//SERVICIO METODO CONSULTAR TODOS LOS PRESTAMOS
	@Path("allPrestamos")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response allprestamos() {
		System.out.println("CONSULTANDO TODOS PRESTAMOS>>>>");
		AdminServiciosLibro admServicios= new AdminServiciosLibro();
		ArrayList<Prestamo> prestamos =new ArrayList<Prestamo>();
		
		try {
				prestamos = admServicios.mostrarPrestamos();

					return Response.ok(prestamos).build();  //devuelve un estatus 200 
			
			
		} catch (KrakeDevException e) {
			e.printStackTrace();
			return Response.serverError().build();  // si algo falla devuelve 500
		}		
	}
	
	
	
	
	
}
