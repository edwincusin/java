package clearminds.cuentas;

public class Cuentas {
	private String id;
	private String tipo="A";
	private double saldo;

	//CONSTRUCTOR CON PARAMETRO CON SET DE LA ID--------------------------------------------------
	public Cuentas(String id) {
		this.id=id;
	}
	//CONSTRUCTOR CON PARAMETRO CON SET DE TODOS LOS ATRIBUTOS------------------------------------
	public Cuentas(String id, String tipo,double saldo) {
		this.id=id;
		this.saldo = saldo;
		this.tipo = tipo;
	}
	
	// METODOS GET Y SET
	public String getId() {
		return id;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	
	//METODOS---------------------------------------------------------------------------------------
	//imprimir
	public void imprimir() {
		System.out.println(
				 "\n******************************************"
				+"\nCUENTA"
				+"\nNumero de cuenta: "+getId()
				+"\nTipo: "+getTipo() 
				+"\nSaldo: "+getSaldo()
				+"\n******************************************"
				);
	}
	//imprimirConMiEstilo
	public void imprimirConMiEstilo() {
		System.out.println(
				 "\n------------------------------------------"
				+"\n________________CUENTA____________________"
				+"\nNumero de cuenta: "+getId()
				+"\nTipo            : "+getTipo() 
				+"\nSaldo           : "+getSaldo()
				+"\n__________________________________________"
				+"\n------------------------------------------"
				);
		
		
	}


}
