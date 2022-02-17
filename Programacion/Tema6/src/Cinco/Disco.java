package Cinco;
/*
 * Es para el ejercicio 5 (Coleccion)
 */
import java.util.Scanner;
public class Disco {
	Scanner teclado = new Scanner(System.in);
	private String titulo;
	private int numeroCanciones;
	private int precio;
	private String fechaCompra;
	
	Disco(){
		titulo = "";
		numeroCanciones = 0;
		precio = 0;
		fechaCompra = "";
	}
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String título) {
		this.titulo = título;
	}
	public int getNumeroCanciones() {
		return numeroCanciones;
	}
	public void setNumeroCanciones(int numeroCanciones) {
		this.numeroCanciones = numeroCanciones;
	}
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	public String getFechaCompra() {
		return fechaCompra;
	}
	public void setFechaCompra(String fechaCompra) {
		this.fechaCompra = fechaCompra;
	}
	
}