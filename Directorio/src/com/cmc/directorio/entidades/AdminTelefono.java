package com.cmc.directorio.entidades;

public class AdminTelefono {
	
	//metodo acctivar mensajeria
	public void activarMensajeria(Telefono telefono) {
		if(telefono.getOperadora()=="movi") {
			telefono.setTieneWsp(true);
		}
	}
	
}
