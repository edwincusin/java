package com.krakedev.colecciones;
import java.util.ArrayList;

public class AdminPersonas {
	private ArrayList<Persona> personas;
	
	
	//CONSTRUCTOR 	
	public AdminPersonas() {
		personas=new ArrayList<Persona>();
	}
	//METODO AGREGAR
	public void agregar(Persona persona) {
		personas.add(persona);
	}
	
	//IMPRIMIR 
	public void imprimir() {
		Persona elementoPersona;
		for(int i=0; i<personas.size();i++) {
			elementoPersona=personas.get(i);
		    System.out.println(elementoPersona.getNombre()+" "+elementoPersona.getApellido()+" "+elementoPersona.getEdad());	
		}
	}
	
	//METODO BUSCAR SOLO UNA PERSONA
	public Persona buscarPorNombre(String nombre) {
		Persona elementoPersona=null;
		Persona personaEncontrada=null;
			for(int i=0;i<personas.size();i++) {
				elementoPersona=personas.get(i);
						if(elementoPersona.getNombre().equals(nombre)) {
							personaEncontrada=elementoPersona;
						}
			}
		
		return personaEncontrada;
	}
	
	//METODO BUSCAR VARIAS PERSONAS
	public ArrayList<Persona> buscarMayores(int edad){
		ArrayList<Persona> mayores=new ArrayList<Persona>();
		Persona elementoPersona=null;
		for(int i=0; i<personas.size();i++) {
			elementoPersona=personas.get(i);
			if(elementoPersona.getEdad() > edad) {
				mayores.add(elementoPersona);
			}
		}
		
		return mayores;
	}
	
	
	
}
