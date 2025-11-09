package com.krakedev.evaluacion;

public class Telefono {
	private String numero;
	private String tipo;
	private String estado;

	
	//CONSTRUCTOR CON PARAMETROS 
	public Telefono(String numero, String tipo) {

		this.numero = numero;
		this.tipo = tipo;
		
		//C:SI ES CORRECTO Y E: SI TIENE ERROR
		if ((numero !=null )&&( tipo!=null)) {
			if (tipo.equalsIgnoreCase("Movil") || tipo.equalsIgnoreCase("Convencional")) {
				
				if (tipo.equalsIgnoreCase("Movil") && numero.length()==10) {
					this.estado="C";
				}else if (tipo.equalsIgnoreCase("Convencional") && numero.length()==7) {
					this.estado="C";
					}else {
				//	System.out.println("LA LONGITUD PARA CONVENCIONAL ES DE 7 DIGITOS");
					this.estado="E";
				}
			}else {
				//System.out.println("LOS TIPOS PERMITIDOS ES :MOVIL O CONVECIONAL");
				this.estado="E";
			}
		}else {
			//System.out.println("VALORES DE PARAMETROS DEBEN SER DIFERENTES ");
			this.estado="E";
		}
	}

	//METODOS GET / NO AGREGAR SET
	public String getNumero() {
		return numero;

	}

	public String getTipo() {
		return tipo;
	}

	public String getEstado() {
		return estado;
	}

	
}
