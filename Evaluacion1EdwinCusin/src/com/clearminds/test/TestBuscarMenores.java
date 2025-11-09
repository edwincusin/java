package com.clearminds.test;
import java.util.ArrayList;

import com.clearminds.componentes.Celda;
import com.clearminds.componentes.Producto;
import com.clearminds.maquina.MaquinaDulces;

public class TestBuscarMenores {

	public static void main(String[] args) {
		MaquinaDulces maquina=new MaquinaDulces();
		maquina.agregarCelda(new Celda("A1"));
		maquina.agregarCelda(new Celda("A2"));
		maquina.agregarCelda(new Celda("B1"));
		maquina.agregarCelda(new Celda("B2"));
		maquina.agregarCelda(new Celda("C1"));
		maquina.agregarCelda(new Celda("C2"));
		
		Producto producto1 = new Producto("PAPITAS", "CSN11", 0.85);
		maquina.cargarProducto(producto1, "A1", 2);
		
		Producto producto2 = new Producto("DORITOS", "CSN12", 0.5);
		maquina.cargarProducto(producto2, "A2", 2);
		
		Producto producto3 = new Producto("JET", "CSN13", 0.25);
		maquina.cargarProducto(producto3, "B1", 2);
		
		Producto producto4 = new Producto("DE TODITO", "CSN14", 0.60);
		maquina.cargarProducto(producto4, "B2", 2);
		
		Producto producto5 = new Producto("CHETOOS", "CSN15", 6);
		maquina.cargarProducto(producto5, "C1", 2);
		
		Producto producto6 = new Producto("GELATINA", "CSN16", 7);
		maquina.cargarProducto(producto6, "C2", 2);
		
		ArrayList<Producto>productosMenores=maquina.buscarMenores(4);
		System.out.println("---PRODCTOS MENORES A "+productosMenores.size()+"-------");
		maquina.imprimirMenores(productosMenores);

	}

}
