package com.entidades;

import java.util.ArrayList;

public class Naipe {
	private ArrayList<Numero> numerosPosibles;
	private ArrayList<Carta> cartas;
	
	
	
	public Naipe() {
		numerosPosibles=new ArrayList<Numero>();
		cartas=new  ArrayList<Carta> ();
		
		numerosPosibles.add(new Numero("A", 11));
		for(int i=2;i<=10;i++) {
			numerosPosibles.add(new Numero(Integer.toString(i), i));
		}
		numerosPosibles.add(new Numero("J", 10));
		numerosPosibles.add(new Numero("Q", 10));
		numerosPosibles.add(new Numero("K", 10));
		
		Palos palos =new Palos();
		for(int i=0;i<numerosPosibles.size();i++) {
			cartas.add(new Carta(numerosPosibles.get(i),palos.getCorazonNegro()));
			cartas.add(new Carta(numerosPosibles.get(i),palos.getCorazonRojo()));
			cartas.add(new Carta(numerosPosibles.get(i),palos.getDiamante()));
			cartas.add(new Carta(numerosPosibles.get(i),palos.getTrebol()));
		}
		
	}

	//METODO BARAJAR
	public ArrayList<Carta> barajar(){
		ArrayList<Carta> auxiliar=new ArrayList<Carta>();
		int posicionObenida;
		for(int i=1;i<=100;i++) {
			posicionObenida=Random.obtenerPosicion();
			if (cartas.get(posicionObenida).getEstado().equals("N")) {
				auxiliar.add(cartas.get(posicionObenida));
				cartas.get(posicionObenida).setEstado("C");
			}
		}
		
		Carta elementoCarta;
		//CARTAS EN ESTADO N PARA VOLVER A BARRER
		for (int i=0; i<cartas.size();i++) {
			elementoCarta=cartas.get(i);
			if (auxiliar.size()==52) {
				break;
			}
			if(auxiliar.size()<=52 && elementoCarta.getEstado().equals("N")) {
				auxiliar.add(elementoCarta);
				elementoCarta.setEstado("C");
			}
		}
		
		return auxiliar;
	}


	//METODO GET
	public ArrayList<Carta> getCartas() {
		return cartas;
	}
	
	
}
