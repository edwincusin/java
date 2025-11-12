package com.servicios;

import java.util.ArrayList;
import com.entidades.Carta;
import com.entidades.Naipe;

public class Juego {
	private Naipe naipe;
	private ArrayList<ArrayList<Carta>> cartasJugador;
	private ArrayList<Carta> naipebarajado;

	// CONSTRUCTOR SI NPARAMETROS
	public Juego() {

		naipe = new Naipe();
		naipebarajado=new ArrayList<Carta>();
		this.naipebarajado = (naipe.barajar());

	}

	// CONSTRUCTOR CON PARAMETROS
	public Juego(ArrayList<String> idsJugadores) {

		naipe = new Naipe();
		naipebarajado=new ArrayList<Carta>();
		this.naipebarajado = (naipe.barajar());
		cartasJugador = new ArrayList<ArrayList<Carta>>();

		for (int i = 0; i < idsJugadores.size(); i++) {
			ArrayList<Carta> jugador = new ArrayList<Carta>();
			cartasJugador.add(jugador);
		}
	}

	public void entregarCartas(int cartasPorJugador) {
		int indexCartasbarajadas=0;
		for (int i = 0; i < cartasPorJugador; i++) {
			for (int j = 0; j < cartasJugador.size(); j++) {
				if (indexCartasbarajadas < naipebarajado.size()) {
					Carta elementoCartaActual = naipebarajado.get(indexCartasbarajadas);
					cartasJugador.get(j).add(elementoCartaActual);
					indexCartasbarajadas++;
				}
			}
		}
	}
	

	// METODO GET
	public ArrayList<ArrayList<Carta>> getCartasJugador() {
		return cartasJugador;
	}

}
