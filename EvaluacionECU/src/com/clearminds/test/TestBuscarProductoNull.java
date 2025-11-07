package com.clearminds.test;

import com.clearminds.componentes.Producto;
import com.clearminds.maquina.MaquinaDulces;

public class TestBuscarProductoNull {
	public static void main(String[] args) {
		MaquinaDulces maquina=new MaquinaDulces();
		maquina.configurarMaquina("A1", "A2", "B1", "B2");
		
		Producto producto=new Producto("KE34","Papitas",0.85);
		maquina.cargarProducto(producto, "B1", 4);
		
		Producto prod=maquina.buscarProductoEnCelda("A1");
		System.out.println("Producto encontrado:"+prod.getNombre());
		//SALTA EL ERROR EN LA LINEA 15, LA VARIABLE DE TIPO PRODUCTO PROD, YA QUE SE REQUIERE
		//IMPRIMIR EL NOMBRE DEL PRODUCTO EL CUAL NO HA SIDO ASIGNADO SE ECUNTRA CON LOS VALORES POR DEFECTO NULL
		
		
		
	}
}
