package com.krakedev.repasoii.test;

import java.util.ArrayList;
import java.util.Date;

import com.krakedev.repasoii.entidades.Autor;
import com.krakedev.repasoii.entidades.Genero;
import com.krakedev.repasoii.entidades.Libro;
import com.krakedev.repasoii.entidades.Prestamo;
import com.krakedev.repasoii.repasofinal.excepciones.KrakeDevException;
import com.krakedev.repasoii.serviciosAdm.AdminServicios;
import com.krakedev.repasoii.utils.Convertidor;

public class Pruebas {

	public static void main(String[] args) {
		
		//LIBRO PARA INSERTAR
		Genero genero=new Genero();
		genero.setIdGenero(2);
		
		Autor autor=new Autor();
		autor.setIdAutor(2);			
		Libro libro = new Libro();
		libro.setTitulo("lA MONTAÑA");
		libro.setAutor(autor);
		libro.setGenero(genero);
		libro.setAnioPublicacion(1888);
		libro.setEstadoDisponibilidad(true);
		
		//PRESTAMOS PARA INSERTAR
		Libro libro1= new Libro();
		libro1.setIdlibro(5);
		Prestamo prestamo= new Prestamo();
		prestamo.setLibro(libro1);
		prestamo.setUsuario("DAVICHO FARINANGO");
		
		
		//LIBROS PARA ACTUALIZAR
		Genero generoAct=new Genero();
		generoAct.setIdGenero(5);
		
		Autor autorAct=new Autor();
		autorAct.setIdAutor(3);	
		
		Libro libroAct = new Libro();
		libroAct.setIdlibro(15);
		libroAct.setAutor(autorAct);
		libroAct.setGenero(generoAct);
		libroAct.setTitulo("DON QUIJOTE DE LA MANCHA");
		libroAct.setAnioPublicacion(5555);
		libroAct.setEstadoDisponibilidad(false);
		
		
		//PRESTAMOS PARA ACTUALIZAR
		Libro libro2= new Libro();
		libro2.setIdlibro(1);
		Prestamo prestamoAct= new Prestamo();
		prestamoAct.setIdPrestamo(3); // marlon
		prestamoAct.setLibro(libro1);
		prestamoAct.setUsuario("JAIME TACO");

		try {
						
			System.out.println("INSERTAR LIBRO>>>>>>>>>>>>>>>>>>>>>>>>>");
			AdminServicios.insertarLibro(libro);
			
			System.out.println("");
			System.out.println("");
			
			
			System.out.println("INSERTAR PRESTAMOS>>>>>>>>>>>>>>>>>>>>>>>>>");
			Date fechaPrestamo=Convertidor.convertirFecha("2025/05/05");
			prestamo.setFechaPrestamo(fechaPrestamo);
			
			Date fechaDevolucion=Convertidor.convertirFecha("2025/06/06");
			prestamo.setFechaDevolucion(fechaDevolucion);
			
			AdminServicios.insertarPrestamo(prestamo);
			
			System.out.println("ACTUALIZACION LIBRO>>>>>>>>>>>>>>>>>>>>>>>>>");
			AdminServicios.actualizarLibro(libroAct);
			
			System.out.println("");
			System.out.println("");
			
			
			System.out.println("ACTUALIZACION PRESTAMO>>>>>>>>>>>>>>>>>>>>>>>>>");
			fechaPrestamo=Convertidor.convertirFecha("2025/05/05");
			prestamoAct.setFechaPrestamo(fechaPrestamo);
			
			fechaDevolucion=Convertidor.convertirFecha("2025/06/06");
			prestamoAct.setFechaDevolucion(fechaDevolucion);
			
			AdminServicios.actualizarPrestamo(prestamoAct);
			
			System.out.println("");
			System.out.println("");
			
			System.out.println("IMPRESION LISTA DE LIBROS>>>>>>>>>>>>>>>>>>>>>>>>>");
			System.out.println("");
			ArrayList<Libro> libros= AdminServicios.mostrarLibros();
			System.out.println(libros);
			
			System.out.println("");
			System.out.println("");
			
			System.out.println("IMPRESION LISTA DE PRESTAMOS>>>>>>>>>>>>>>>>>>>>>>>>>");
			ArrayList<Prestamo> prestamos= AdminServicios.mostrarPrestamos();
			System.out.println(prestamos);
						
		} catch (KrakeDevException e) {
			System.out.println(e.getMessage());
		}

	}

}
