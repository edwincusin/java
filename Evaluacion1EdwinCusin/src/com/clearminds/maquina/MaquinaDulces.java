package com.clearminds.maquina;
import java.util.ArrayList;
import java.util.Iterator;

import com.clearminds.componentes.Celda;
import com.clearminds.componentes.Producto;

public class MaquinaDulces {
	private ArrayList<Celda> celdas;
	private double saldo;
	
	
	//CONSTRUCTOR PARA EVITAR QUE EL OBJETO ESTE EN NULL
	public MaquinaDulces() {
		celdas=new ArrayList<Celda>(); // inicializacion siempre para evitar error null
	}

	//METODO AGREGAR CELDA
	public void agregarCelda(Celda celda) {
		celdas.add(celda);		
	}
	

	//METODO MOSTRAR CONFIGURACION
	public void mostrarConfiguracion() {
		Celda elementoCelda;
		for(int i=0;i<celdas.size();i++) {
			elementoCelda=celdas.get(i);
			System.out.println("Celda "+(i+1)+" : "+elementoCelda.getCodigo());
		}
	}
	
	//METODO BUSCAR CELDA
	public Celda buscarCelda(String codigoCelda) {
		Celda elementoCelda;
		Celda celdaEncontrada=null;
		for(int i=0;i<celdas.size();i++) {
			elementoCelda=celdas.get(i);
			if(elementoCelda.getCodigo().equals(codigoCelda)) {
				celdaEncontrada=elementoCelda;
			}
		}		
		return celdaEncontrada;
	}
	
	//METODO CARGAR PRODUCTO
	public void cargarProducto(Producto producto, String codigoCelda, int cantidadItem) {
		Celda celdaRecuperada=buscarCelda(codigoCelda);
		celdaRecuperada.ingresarProducto(producto, cantidadItem);
	}
	
	//METODO MOSTRAR PRODUCTOS
	public void mostrarProductos() {
		Celda elementoCelda=null;
		for(int i=0; i<celdas.size();i++) {
			elementoCelda=celdas.get(i);
			if(elementoCelda.getProducto()!=null) {
				System.out.println("Celda: "+elementoCelda.getCodigo()
									+"  Stock: "+elementoCelda.getStock()
									+"  Producto: "+elementoCelda.getProducto().getNombre()
									+" Precio: "+elementoCelda.getProducto().getPrecio()
						);
			}else {
				System.out.println("Celda: "+elementoCelda.getCodigo()
								+"  Stock: "+elementoCelda.getStock()
								+"  Producto: sin producto asignado"
						);
			}
		}
	}
	
	//METODO BUSCAR PRODUCTO EN CELDA
	public Producto buscarProductoEnCelda(String codigoCelda) {
		Celda celdaRecuperada=buscarCelda(codigoCelda);
		Producto producto=null;
		if (celdaRecuperada!=null) {
			producto=celdaRecuperada.getProducto();
		}
		return producto;
	}
	//METODO CONSULTAR PRECIO
	public double consultarPrecio(String codigoCelda) {
		Celda celdaRecuperada=buscarCelda(codigoCelda);
		Producto producto=null;
		if (celdaRecuperada!=null) {
			producto=celdaRecuperada.getProducto();
		}
		
		return producto.getPrecio();
	}
	
	//METODO BUSCAR CELDA PRODUCTO // ANTES VALIDAR QUE CELDA TENGA PRODUCTO PARA EVITAR EL ERROR NULL
	public Celda buscarCeldaProducto(String codigoProducto) {
		Celda elementoCelda;
		Celda celdaEncontrada=null;
		for(int i=0; i<celdas.size();i++) {
			elementoCelda=celdas.get(i);
			if(elementoCelda.getProducto()!=null &&
				elementoCelda.getProducto().getCodigo().equals(codigoProducto)) {
					celdaEncontrada=elementoCelda;
					break;
			}			
		}
		return celdaEncontrada;
	}
	
	//METODO INCREMENTAR PRODUCTOS 
	public void incrementarProductos(String codigoProducto, int itemIncrementar) {
		Celda celdaEncontrada=buscarCeldaProducto(codigoProducto);
		int nuevoValorItem=celdaEncontrada.getStock()+itemIncrementar;
		celdaEncontrada.setStock(nuevoValorItem);
	}
	
	//METODO VENDER 
	public void vender(String codigoCelda) {
		Celda celdaEncontrada=buscarCelda(codigoCelda);
		int nuevoValorItem=celdaEncontrada.getStock()-1;
		celdaEncontrada.setStock(nuevoValorItem);
		this.saldo+=celdaEncontrada.getProducto().getPrecio();
	}
	
	//VENDER CON CAMBIO
	public double venderConCambio(String codigoCelda, double valorIngresadoPorCliente) {
		Celda celdaEncontrada=buscarCelda(codigoCelda);
		int nuevoValorItem=celdaEncontrada.getStock()-1;
		celdaEncontrada.setStock(nuevoValorItem);
		double cambio=(valorIngresadoPorCliente)-(celdaEncontrada.getProducto().getPrecio());
		this.saldo+=celdaEncontrada.getProducto().getPrecio();
				
		return cambio;
	}
	
	//BUSCAR MENORES
	public ArrayList<Producto> buscarMenores(double limite){
		ArrayList<Producto> productosSelecionadosMenores = new ArrayList<Producto>();
		Celda elementoCelda;
		for(int i=0; i<celdas.size();i++) {
			elementoCelda=celdas.get(i);
			if(elementoCelda.getProducto().getPrecio() <= limite) {
				productosSelecionadosMenores.add(elementoCelda.getProducto());
			}
		}
		
		return productosSelecionadosMenores;
	}
	
	//IMPRIMIR ESTILO PARA MENORES
	public void imprimirMenores(ArrayList<Producto> produtosMenores) {
		Producto elementoProducto;
		for(int i=0; i<produtosMenores.size();i++) {
			elementoProducto=produtosMenores.get(i);
			System.out.println(
					"Nombre  : "+elementoProducto.getNombre()
					+"  Precio : "+elementoProducto.getPrecio()
					);
			
		}
	}
	
	//MEOTODO GET Y SET
	public ArrayList<Celda> getCeldas() {
		return celdas;
	}
	public void setCeldas(ArrayList<Celda> celdas) {
		this.celdas = celdas;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	
}
