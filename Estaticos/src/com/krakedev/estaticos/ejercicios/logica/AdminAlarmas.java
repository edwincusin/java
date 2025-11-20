package com.krakedev.estaticos.ejercicios.logica;
import java.util.ArrayList;
import com.krakedev.estaticos.ejercicios.entidades.Alarma;

public class AdminAlarmas {
	private ArrayList<Alarma> alarmas;
	
	public AdminAlarmas() {
		super();
		alarmas=new ArrayList<Alarma>(); // inicializo el array
	}

	//METODO AGREGAR ALARMA A LA LISTA
	public void agregarAlarma(Alarma alarma) {
		alarmas.add(alarma);
	}

	// METODO GET ALARMAS
	public ArrayList<Alarma> getAlarmas() {
		return alarmas;
	}
	
}
