package com.krakedev.evaluacion.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.krakedev.evaluacion.excepciones.KrakeException;

public class Convertidor {
	private static final Logger LOGGER = LogManager.getLogger(ConexionBDD.class);
	
	private static final String FORMATO_FECHA="yyyy/MM/dd";
	private static final String FORMATO_HORA="hh:mm";
	
	//METODO CONVERTIR FECHA
	public static Date convertirFecha(String fechaStr) throws KrakeException {
		
		SimpleDateFormat sdf= new SimpleDateFormat(FORMATO_FECHA);
		Date fechaDate=null;
		try {
			LOGGER.trace("CONVIRTIENDO FECHA"+fechaStr);
			fechaDate = sdf.parse(fechaStr);
			LOGGER.trace("FECHA CONVERTIDA"+fechaStr);
		} catch (ParseException e) {
			//e.printStackTrace();
			LOGGER.error("LA FECHA NO TIENE FORMATO CORRECTO " +fechaStr,e);
			//propagamos el error 
			throw new KrakeException("LA FECHA NO TIENE FORMATO CORRECTO " +fechaStr);
		}
		
		return fechaDate;		
	}
	//METODO CONVERTIR HORA
	public static Date convertirHora(String horaStr) throws KrakeException {
		
		SimpleDateFormat sdf= new SimpleDateFormat(FORMATO_HORA);
		Date horaDate=null;
		try {
			horaDate = sdf.parse(horaStr);
			//System.out.println("convierte la hora : "+horaStr);
		} catch (ParseException e) {
			//e.printStackTrace();
			LOGGER.error("LA HORA NO TIENE FORMATO CORRECTO"+horaStr,e);
			//propagamos el error 
			throw new KrakeException("LA HORA NO TIENE FORMATO CORRECTO"+horaStr);
		}
		
		return horaDate;		
	}
}
