package com.entidades;

import java.util.ArrayList;

import com.servicios.Juego;

public class Jugadores {
	private ArrayList<String> nombresJugadores;
	
	
	
	
	
	//CONSTRUCTOR POR DEFECTO 
	public Jugadores() {
		nombresJugadores= new ArrayList<String>();
	}
	
	public void jugar() {
		nombresJugadores.add("JUGADOR 1");
		nombresJugadores.add("JUGADOR 2");
		nombresJugadores.add("JUGADOR 3");
		
		Juego juego=new Juego(nombresJugadores);
		juego.entregarCartas(5);
		
		int sumaGanador=0;
		int idGanador=0;
		
		for(int i=0;i<nombresJugadores.size();i++) {
			int total=0;
			ArrayList<Carta> cartas = juego.getCartasJugador().get(i);
			
			for(Carta carta:cartas) {
				total+=carta.getNumero().getValor();
			}
			System.out.println("jugador "+nombresJugadores.get(i)+" total : "+total);  
			
			if(total>sumaGanador) {
				sumaGanador=total;
				idGanador=i;
			}
		}
		
		System.out.println("Ganador es: "+getNombresJugadores().get(idGanador)+ " con "+ sumaGanador);
		
		
	}

	//METODOS GET Y SET
	public ArrayList<String> getNombresJugadores() {
		return nombresJugadores;
	}

	public void setNombresJugadores(ArrayList<String> nombresJugadores) {
		this.nombresJugadores = nombresJugadores;
	}

	
	
}
