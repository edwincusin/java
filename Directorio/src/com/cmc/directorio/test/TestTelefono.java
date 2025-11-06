package com.cmc.directorio.test;
import com.cmc.directorio.entidades.Telefono;

public class TestTelefono {

	public static void main(String[] args) {
		Telefono telf=new Telefono("movi","09941234123", 10);
		
		System.out.println(
			"\nOperadora  : "+telf.getOperadora()
				+"\nNumero    : "+telf.getNumero()
				+"\nCodigo    : "+telf.getCodigo()
				+"\nTieneWsp  : "+telf.isTieneWsp()
				+"\n\n\n"
				);

	}

}
