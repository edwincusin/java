package com.clearminds.maquina;
import com.clearminds.componentes.Celda;
import com.clearminds.componentes.Producto;

public class MaquinaDulces {
	private Celda celda1;
	private Celda celda2;
	private Celda celda3;
	private Celda celda4;
	private double saldo;
	
	//METODO CONFIGURAR MAQUINA
	public void configurarMaquina(String codigo1, String codigo2, String codigo3, String codigo4) {
		this.celda1 = new Celda(codigo1);
		this.celda2 = new Celda(codigo2);
		this.celda3 = new Celda(codigo3);
		this.celda4 = new Celda(codigo4);
	}
	
	//METODO MOSTRAR CONFIGURACION
	public void mostrarConfiguracion() {
		System.out.println(
				"\n-----------IMPRESION DE CODIGOS DE CELDAS--------------"
				+"\nCod Celda1  : "+celda1.getCodigo()
				+"\nCod Celda2  : "+celda2.getCodigo()
				+"\nCod Celda3  : "+celda3.getCodigo()
				+"\nCod Celda4  : "+celda4.getCodigo()
				);
	}
	
	//METODO BUSCAR CELDA
	public Celda buscarCelda(String codigoCelda) {
			if(celda1.getCodigo().equals(codigoCelda)) {
				return celda1;
			}else if(celda2.getCodigo().equals(codigoCelda)) {
				return celda2;
			}else if(celda3.getCodigo().equals(codigoCelda)){
				return celda3;
			}else if(celda4.getCodigo().equals(codigoCelda)) {
				return celda4;
			}else {
				return null;
			}
	}
	
	//METODO CARGAR PRODUCTO 
	public void cargarProducto(Producto producto, String codigoCelda, int stock) {
		Celda celdaRecupaerada=buscarCelda(codigoCelda);
		celdaRecupaerada.ingresarProducto(producto, stock);
	}
	
	//METODO MOSTRARPRODUCTOS
	public void mostrarProductos() {
		System.out.println(
				"\n-----------IMPRESION INFORMACION CELDA 1--------------"
				+"\nCodigo          : "+celda1.getCodigo()
				+"\nStock Actual    : "+celda1.getStock()
				+"\nNombre Producto : "+celda1.getProducto().getNombre()
				+"\nPrecio Producto : "+celda1.getProducto().getPrecio()
				+"\n\n"
				
				+"\n-----------IMPRESION INFORMACION CELDA 2--------------"
				+"\nCodigo          : "+celda2.getCodigo()
				+"\nStock Actual    : "+celda2.getStock()
				+"\nNombre Producto : "+celda2.getProducto().getNombre()
				+"\nPrecio Producto : "+celda2.getProducto().getPrecio()
				+"\n\n"
				
				+"\n-----------IMPRESION INFORMACION CELDA 3--------------"
				+"\nCodigo          : "+celda3.getCodigo()
				+"\nStock Actual    : "+celda3.getStock()
				+"\nNombre Producto : "+celda3.getProducto().getNombre()
				+"\nPrecio Producto : "+celda3.getProducto().getPrecio()
				+"\n\n"
				
				+"\n-----------IMPRESION INFORMACION CELDA 4--------------"
				+"\nCodigo          : "+celda4.getCodigo()
				+"\nStock Actual    : "+celda4.getStock()
				+"\nNombre Producto : "+celda4.getProducto().getNombre()
				+"\nPrecio Producto : "+celda4.getProducto().getPrecio()
				+"\n\n"
				
				
				);	
	}
	//METODO BUSCAR PRODUTO EN CELDA
	public Producto buscarProductoEnCelda(String codigoCelda) {
		Celda celdaEncontrada =  buscarCelda(codigoCelda);
		Producto producto = celdaEncontrada.getProducto();
		return producto;
	}
	
	//METODO CONSULTAR PRECIO
	public double consultarPrecio(String codigoCelda) {
		Celda celdaEncontrada =  buscarCelda(codigoCelda);
		double precio = celdaEncontrada.getProducto().getPrecio();
		return precio;
	}
	
	//METODO BUSCAR CELDA PRODUCTO
	public Celda buscarCeldaProducto(String codigoProducto) {
		if(celda1.getProducto().getNombre().equals(codigoProducto)) {
			return celda1;
		}else if(celda2.getProducto().getNombre().equals(codigoProducto)) {
			return celda2;
		}else if(celda3.getProducto().getNombre().equals(codigoProducto)) {
			return celda3;
		}else if(celda4.getProducto().getNombre().equals(codigoProducto)) {
			return celda4;
		}else {
			return null;
		}
	
	}
	
	//METODO INCREMENTAR PRODUCTOS
	public void incrementarProductos(String codigoProducto, int cantidadItem) {
		Celda celdaEncontrada=buscarCeldaProducto(codigoProducto);
		celdaEncontrada.setStock(cantidadItem);
	}
	
	//METODO VENDER
	public void vender(String codigoCelda) {
		Celda celdaEncontrada=buscarCelda(codigoCelda);
		int capturoStockActual=celdaEncontrada.getStock()-1;
		celdaEncontrada.setStock(capturoStockActual);
		double  capturoPrecioProducto=celdaEncontrada.getProducto().getPrecio();
		this.saldo+=capturoPrecioProducto;
		
		mostrarProductos();
	}
	
	
	//METODO VENDER CON CAMBIO
	public double venderConCambio(String codigoCelda, double valorIngresado) {
		Celda celdaEncontrada=buscarCelda(codigoCelda);
		int capturoStockActual=celdaEncontrada.getStock()-1;
		celdaEncontrada.setStock(capturoStockActual);
		
		double  capturoPrecioProducto=celdaEncontrada.getProducto().getPrecio();
		double cambio=valorIngresado-capturoPrecioProducto;
		this.saldo+=capturoPrecioProducto;
		
		return cambio;
	}
	
	
	
	
	//METODOS GETTER Y SETTER
	public Celda getCelda1() {
		return celda1;
	}

	public void setCelda1(Celda celda1) {
		this.celda1 = celda1;
	}

	public Celda getCelda2() {
		return celda2;
	}

	public void setCelda2(Celda celda2) {
		this.celda2 = celda2;
	}

	public Celda getCelda3() {
		return celda3;
	}

	public void setCelda3(Celda celda3) {
		this.celda3 = celda3;
	}

	public Celda getCelda4() {
		return celda4;
	}

	public void setCelda4(Celda celda4) {
		this.celda4 = celda4;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	
	
}
