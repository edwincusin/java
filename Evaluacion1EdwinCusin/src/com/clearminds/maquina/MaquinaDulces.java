package com.clearminds.maquina;
import java.util.ArrayList;
import com.clearminds.componentes.Celda;

public class MaquinaDulces {
	private ArrayList<Celda> celdas;
	private double saldo;
	
	
	//CONSTRUCTOR PARA EVITAR QUE EL OBJETO ESTE EN NULL
	public MaquinaDulces() {
		celdas=new ArrayList<Celda>(); // inicializacion siempre para evitar error null
	}

	//METODO AGREGAR CELDA
	public void agregarCelda(Celda celda) {
		celdas.add(celda);		
	}
	

	//METODO MOSTRAR CONFIGURACION
	public void mostrarConfiguracion() {
		Celda elementoCelda;
		for(int i=0;i<celdas.size();i++) {
			elementoCelda=celdas.get(i);
			System.out.println("Celda "+(i+1)+" : "+elementoCelda.getCodigo());
		}
	}
	
	//METODO BUSCAR CELDA
	public Celda buscarCelda(String codigoCelda) {
		Celda elementoCelda;
		Celda celdaEncontrada=null;
		for(int i=0;i<celdas.size();i++) {
			elementoCelda=celdas.get(i);
			if(elementoCelda.getCodigo().equals(codigoCelda)) {
				celdaEncontrada=elementoCelda;
			}
		}		
		return celdaEncontrada;
	}
	
	//MEOTODO GET Y SET
	public ArrayList<Celda> getCeldas() {
		return celdas;
	}
	public void setCeldas(ArrayList<Celda> celdas) {
		this.celdas = celdas;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	
}
