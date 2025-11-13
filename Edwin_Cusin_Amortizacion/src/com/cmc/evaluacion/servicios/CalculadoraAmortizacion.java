package com.cmc.evaluacion.servicios;

import com.cmc.evaluacion.entidades.Cuota;
import com.cmc.evaluacion.entidades.Prestamo;
import com.cmc.evaluacion.entidades.Utilitario;

public class CalculadoraAmortizacion {
	//METODO CALCULAR CUOTA
	public static double calcularCuota(Prestamo prestamo) {

		double valorCuota=0;                           //donde se almacena la cuotaMensual
		double cO=prestamo.getMonto(); 					//capital prestado
		double interesAnual=prestamo.getInteres(); 		//interes anual
		double i=(interesAnual/12)/100;					//interes periodo (mes)
		double n=prestamo.getPlazo();					//plazo / numero periodos cuotas (meses)
		
		valorCuota=(cO*i)/(1-(Math.pow((1+i), -n)));
				
		return valorCuota;
	}
	
	
	//MTODO GENERAR TABLA 
	public  static void  generarTabla(Prestamo prestamo) {
		double  valorCuotaMes=calcularCuota(prestamo);
		
		for(int i=0;i<prestamo.getPlazo();i++) {
			Cuota cuota=new Cuota(i+1);
			cuota.setCuota(valorCuotaMes);
			prestamo.getCuotas().add(cuota);			
		}
		
		//inicializo  valor inicio del perdiodo 
		prestamo.getCuotas().get(0).setInicio(prestamo.getMonto());
		
		//calcular valores de c ada cuota invocando el metodo calcular 
		
		for(int i=0; i<prestamo.getCuotas().size();i++) {
			
			Cuota cuotaActual=prestamo.getCuotas().get(i);
			Cuota cuotaSiguiente=null;
			
			if(i<prestamo.getCuotas().size()-1) {
				cuotaSiguiente=prestamo.getCuotas().get(i+1);
			}
			calcularValoresCuota(prestamo.getInteres(), cuotaActual, cuotaSiguiente);
		}
		
		
		// caso especial para retirar valor de la ultima celda
		Cuota ultimaCuota = prestamo.getCuotas().get(prestamo.getCuotas().size()-1);
		
		if(ultimaCuota.getSaldo()>0.0) {
			ultimaCuota.setCuota((ultimaCuota.getCuota())+(ultimaCuota.getSaldo()));
			ultimaCuota.setSaldo(0.0);
		}
		
	}
	
	//METODO MOSTRAR TABLA 
	public static void mostrarTabla(Prestamo prestamo) {
		System.out.println(
				"N"
				+"  |  Cuota"
				+"  |  Inicio"
				+"  |  Interes"
				+"  |  Abono"
				+"  |  Saldo"
				+"\n--------------------------------------------------------"
				);
		for(int i=0; i<prestamo.getCuotas().size();i++) {
			prestamo.getCuotas().get(i).mostrarPrestamo();
		}
	}
	

	//METODO CALCULAR VALORES CUOTA 
	public static void calcularValoresCuota(double interesPrestamo, Cuota cuotaActual, Cuota cuotaSiguiente) {
				
		double valorInteres=((cuotaActual.getInicio())*(0.01));
		double abonoCapital=cuotaActual.getCuota()-valorInteres;
		double saldo=cuotaActual.getInicio()-abonoCapital;
		
		cuotaActual.setInteres(valorInteres);
		cuotaActual.setAbonoCapital(abonoCapital);
		cuotaActual.setSaldo(saldo);
		
		if(cuotaSiguiente!=null) {
			cuotaSiguiente.setInicio(saldo);
		}
		
	}
}
