package com.cmc.repaso.test;

import com.cmc.repaso.entidades.Item;

public class TestItem {

	public static void main(String[] args) {
		Item item1=new Item();
		
		item1.setNombre("Atun");
		item1.setProductosActuales(20);
		
		item1.vender(5);
		item1.devolver(3);
		
		item1.imprimir();
		
		// otro prueba 
		item1.vender(5);
		item1.devolver(1);
		item1.imprimir();
		
	}

}
