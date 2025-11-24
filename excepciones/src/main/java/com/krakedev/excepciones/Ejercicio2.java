package com.krakedev.excepciones;

import java.io.File;
import java.io.IOException;

public class Ejercicio2 {
	public void metodo1(){
		String a=null;
		a.substring(0);
		//NPE UNCHECKED
		
	}
	
	public void metodo2(){
		
		File f=new File("archivo.txt");
		try {
			f.createNewFile(); //IOEXCEPCION - CHECKED
		} catch (IOException io) {
			System.out.println("error");
		}
		
	}
	
	public void metodo3()throws IOException{
		
		File f=new File("archivo.txt");
		f.createNewFile(); //IOEXCEPCION - CHECKED
	}
	public void metodo4() throws IOException{
		metodo3();
	}
	
}
