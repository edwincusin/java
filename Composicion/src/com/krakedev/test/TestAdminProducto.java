package com.krakedev.test;
import com.krakedev.composicion.AdminProducto;
import com.krakedev.composicion.Producto;

public class TestAdminProducto {

	public static void main(String[] args) {
		
		Producto mc;
		AdminProducto admin=new AdminProducto();
		Producto productoA=new Producto ("DORITOS", 0.50);
		Producto productoB=new Producto ("PAPITAS", 0.50);
		
		mc=admin.buscarMasCaro(productoA, productoB);
		
		if(mc == null) {
			System.out.println("son precios iguales");
		}else {			
			System.out.println("EL MAS CARO ES : "+mc.getNombre());
		}
	}

}
