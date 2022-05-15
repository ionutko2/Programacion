package Ejercicio2Temafin;

public class Viajante {
	private String dni, nombre;
	private int antiguedad, distancia, ventas;
	
	/**
	 * Escribir el dni, nombre, antiguedad y distancia recorrida del cliente
	 * @param dni
	 * @param nombre
	 * @param antiguedad
	 * @param distancia
	 */
	public  Viajante (String dni, String nombre, int antiguedad, int distancia) {
		this.dni = dni;
		this.nombre = nombre;
		this.antiguedad = antiguedad;
		this.distancia = distancia;
		ventas = 0;
	}
	
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getAntiguedad() {
		return antiguedad;
	}
	public void setAntiguedad(int antiguedad) {
		this.antiguedad = antiguedad;
	}
	public int getDistancia() {
		return distancia;
	}
	public void setDistancia(int distancia) {
		this.distancia += distancia;
	}
	public int getVentas() {
		return ventas;
	}
	public void setVentas(int ventas) {
		this.ventas = ventas;
	}
	
	public String toString() {
		return dni + " " + nombre + " " +  antiguedad + " " + distancia + " " + ventas;
	}
	
}
