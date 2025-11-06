package com.cmc.directorio.entidades;

public class AdminTelefono {
	
	//metodo acctivar mensajeria
	public void activarMensajeria(Telefono telefono) {
		if(telefono.getOperadora()=="movi") {
			telefono.setTieneWsp(true);
		}
	}
	
	//metodo contarmovi
	public int contarMovi(Telefono telf1, Telefono telf2, Telefono telf3) {
		int con=0;
		
		if(telf1.getOperadora()=="movi") {
			con+=1;
		}
		if(telf2.getOperadora()=="movi") {
			con+=1;
		}
		if(telf3.getOperadora()=="movi") {
			con+=1;
		}
		
		return con;
	}
	
	//metodo contarlaro
	public int contarClaro(Telefono telf1, Telefono telf2, Telefono telf3,Telefono telf4 ) {
		int con=0;
		
		if(telf1.getOperadora()=="claro") {
			con+=1;
		}
		if(telf2.getOperadora()=="claro") {
			con+=1;
		}
		if(telf3.getOperadora()=="claro") {
			con+=1;
		}
		if(telf4.getOperadora()=="claro") {
			con+=1;
		}
		
		
		return con;
	}
	
}