package com.krakedev.prestamos.entidades;

import java.math.BigDecimal;
import java.util.Date;

public class Prestamo {
	private int codigo;
	private Persona persona;
	private BigDecimal monto;
	private Date fechaPrestamo;
	private Date horaPrestamo;
	private String garante;
	
	//CONSTRUCTOR SIN PARAMETROS
	public Prestamo() {
	}
	
	//CONSTRUCTOR CON PARAMETROS
	public Prestamo(int codigo, Persona persona, BigDecimal monto, Date fechaPrestamo, Date horaPrestamo,
			String garante) {
		super();
		this.codigo = codigo;
		this.persona = persona;
		this.monto = monto;
		this.fechaPrestamo = fechaPrestamo;
		this.horaPrestamo = horaPrestamo;
		this.garante = garante;
	}
	
	//CONSTRUCTOR CON PARAMETROS
	public Prestamo(int codigo, Persona persona, BigDecimal monto,
			String garante) {
		super();
		this.codigo = codigo;
		this.persona = persona;
		this.monto = monto;
		this.garante = garante;
	}

	//METODOS GET Y SET
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public BigDecimal getMonto() {
		return monto;
	}

	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}

	public Date getFechaPrestamo() {
		return fechaPrestamo;
	}

	public void setFechaPrestamo(Date fechaPrestamo) {
		this.fechaPrestamo = fechaPrestamo;
	}

	public Date getHoraPrestamo() {
		return horaPrestamo;
	}

	public void setHoraPrestamo(Date horaPrestamo) {
		this.horaPrestamo = horaPrestamo;
	}

	public String getGarante() {
		return garante;
	}

	public void setGarante(String garante) {
		this.garante = garante;
	}
	
	//METODO TO STRING
	@Override
	public String toString() {
		return "Prestamo [codigo=" + codigo + ", persona=" + persona + ", monto=" + monto + ", fechaPrestamo="
				+ fechaPrestamo + ", horaPrestamo=" + horaPrestamo + ", garante=" + garante + "]";
	}
	
}
