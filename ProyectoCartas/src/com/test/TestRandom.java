package com.test;

import java.util.Iterator;

import com.entidades.Random;

public class TestRandom {

	public static void main(String[] args) {
		Random random= new Random();
		
		//aqui se valida que arroje el 0 y el 1
		for(int i=0;i<100;i++) {
			System.out.println(random.obtenerPosicion());
		}

	}

}
