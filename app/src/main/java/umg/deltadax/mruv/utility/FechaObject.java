package com.centrikal.visitasmovil.utility;

/**
 * Objeto para manipular fechas en int
 * @author josepablocabreragarcia
 *
 */
public class FechaObject {
	private int dia;
	private int mes;
	private int anio;

	public FechaObject() {
	}

	public FechaObject(int dia, int mes, int anio) {
		setDia(dia);
		setMes(mes);
		setAnio(anio);
	}

	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}
}
