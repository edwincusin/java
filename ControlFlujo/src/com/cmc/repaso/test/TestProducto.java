package com.cmc.repaso.test;
import com.cmc.repaso.entidades.Producto;

public class TestProducto {

	public static void main(String[] args) {
		Producto producto=new Producto("ZAPATOS PUMA",150.00);
		
		producto.setPrecio(-100);
		
		System.out.println(
				"\nNombre      : "+producto.getNombre()
				+"\nPrecio     : "+producto.getPrecio()
				+"\nPrecio con descuento : "+producto.calcularPrecioPromo(20)//agregar porcentaje en numeros enteros
				);
	}

}
