package com.cmc.repaso.test;

import com.cmc.repaso.entidades.Estudiante;

public class TestEstudiante {

	public static void main(String[] args) {
		Estudiante estudiante1=new Estudiante("Edwin");
		Estudiante estudiante2=new Estudiante("Edwin");
		
		estudiante1.calificar(5);
		estudiante2.calificar(10);
		
		System.out.println(
				"\n--------------ESTUDIANTE 1------------"
				+"\nNOMBRE         : "+estudiante1.getNombre()
				+"\nNOTA           : "+estudiante1.getNota()
				+"\nRESULTADO      : "+estudiante1.getResultado()
				+"\n_______________________________________"
				);
		
		System.out.println(
				"\n--------------ESTUDIANTE 2------------"
				+"\nNOMBRE         : "+estudiante2.getNombre()
				+"\nNOTA           : "+estudiante2.getNota()
				+"\nRESULTADO      : "+estudiante2.getResultado()
				+"\n_______________________________________"
				);
	}

}
