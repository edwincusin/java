package clearminds.cuentas.test;

import clearminds.cuentas.Cuentas;

public class TestCuentas {

	public static void main(String[] args) {
		// CREO OBJETO Y REFERENCIO CON CUENTA1
		Cuentas cuenta1 = new Cuentas("03476");
		
		//COLOCO UN VALOR DE SALDO EN LA CUENTA1
		cuenta1.setSaldo(675);
		
		
		
		//CREO EL OBJETO CUENTA Y LO REFERENCIO CON CUENTA2
		Cuentas cuenta2=new Cuentas("034,76","C",98);
		
		
		
		//CREO EL OBJETO CUENTA Y LO REFERENCIO CON CUENTA3
		Cuentas cuenta3 = new Cuentas("03476");
		
		//MODIFICO EL TIPO DE CUENTA EN CUENTA3
		cuenta3.setTipo("C");
		
		
		
		//IMPRIMO CUENTA 1.2.3
		System.out.println("---------VALORES INICIALES---------------");
		cuenta1.imprimir();
		cuenta2.imprimir();
		cuenta3.imprimir();
		
		
		System.out.println("---------VALORES MODIFICADOS---------------");
		cuenta1.setSaldo(400);
		cuenta3.setSaldo(567);
		cuenta2.setTipo("D");
		
		cuenta1.imprimir();
		cuenta2.imprimir();
		cuenta3.imprimir();
		
		
		
		//CREAR UNA CUENTA4 UTLIZANDO EL CONSTRUCTOR QUE RECIBE LA ID DE CUENTA 
		//Y MODIFICAR LOS ATRIBUTOS DE SER NESARIO
		Cuentas cuenta4=new Cuentas("0987");
		cuenta4.setSaldo(10);
		
		//CREAR UNA CUENTA4 UTLIZANDO EL CONSTRUCTOR QUE RECIBE LOS 3 PARAMETROS
		//Y MODIFICAR LOS ATRIBUTOS DE SER NESARIO
		Cuentas cuenta5 = new Cuentas("0557","C",10);
		
		//CREAR UNA CUENTA4 UTLIZANDO CUALESQUIER CONSTRUCTOR
		//Y MODIFICAR LOS ATRIBUTOS DE SER NESARIO
		//ADICIONAL USAR LA MENR CANTIDAD DE CODIGO
		Cuentas cuenta6=new Cuentas("1753","A",0);
		
		// IMPRIMIR LOS VALORES DE LA CUENTA 4.5.6 CON EL METODO IMPRIMIR CONMIESTILO
		System.out.println("---------IMPRESION CON MI ESTILO---------------\n");
		cuenta4.imprimirConMiEstilo();
		cuenta5.imprimirConMiEstilo();
		cuenta6.imprimirConMiEstilo();
	}

}
