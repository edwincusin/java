package com.krakedev.demo.test;
import com.krakedev.demo.Producto;

public class TestProducto {

	public static void main(String[] args) {
		Producto pro1= new Producto(1,"ARROZ");
		
		pro1.setDescripcion("OSITO");
		pro1.setPeso(2.3);
		
		System.out.println(
				"\nCODIGO       : "+pro1.getCodigo()
				+"\nNOMBRE      : "+pro1.getNombre()
				+"\nDESCRIPCION : "+pro1.getDescripcion()
				+"\nPESO        : "+pro1.getPeso()
				);
	}

}
