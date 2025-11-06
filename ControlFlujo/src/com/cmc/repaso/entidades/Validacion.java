package com.cmc.repaso.entidades;

public class Validacion {
	//METODO VALIDAR MONTO
	public boolean validarMonto(int monto){
		if(monto > 0) {
			return true;
		}else {
			return false;
		}
	}
}
