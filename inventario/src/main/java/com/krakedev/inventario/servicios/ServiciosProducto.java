package com.krakedev.inventario.servicios;

import javax.ws.rs.core.MediaType;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.krakedev.inventario.entidades.Categoria;
import com.krakedev.inventario.entidades.Producto;

@Path("producto")
public class ServiciosProducto {

	//METODO INSERTAR
	@Path("insertar")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void insertar(Producto producto) {
		System.out.println("INSERTANDO PRODUCTO..." +producto);
	}
	
	//METODO ACTUALIZAR
	@Path("actualizar")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public void actualizar(Producto producto) {
		System.out.println("ACTUALIZANDO PRODUCTO____..." +producto);
	}
	
	
	//METODO CONSULTAR
	@Path("recuperarTodos")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Producto> recuperarTodos() {
		ArrayList<Producto> productos =new ArrayList<Producto>();
		Categoria cat1=new Categoria(1,"SNACKS");
		Categoria cat2=new Categoria(2,"GASEOSA");
		Categoria cat3=new Categoria(3,"LACTEO");
		
		Producto prod1=new Producto("001","YOGURT",cat3,1.00,12);
		Producto prod2=new Producto("002","GOLPE",cat1,1.20,15);
		Producto prod3=new Producto("003","COCA COLA",cat2,4.50,40);
		
		productos.add(prod1);
		productos.add(prod2);
		productos.add(prod3);
		
		return productos;
	}
	
}

