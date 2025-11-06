package com.krakedev.composicion;

public class AdminProducto {

	//recibe 2 prodcutos
	
	// retorna el prodcucto de mayor precio
	
	//si tienen el mismo precio retorna null
	
	public Producto buscarMasCaro(Producto p1, Producto p2 ) {
		if(p1.getPrecio() > p2.getPrecio()) {
			return p1;
		}else if(p1.getPrecio() < p2.getPrecio()) {
			return p2;
		}else {
			return null;
		}
			
	}
	
}
