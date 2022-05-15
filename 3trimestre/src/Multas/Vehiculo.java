package Multas;

import java.util.*;

public class Vehiculo {
	String matricula;
	String marca;
	String modelo;
	String propietario;
	String anioMatriculacion;
	boolean tieneMulta;
	List<Multas> multas = new LinkedList<Multas>();
	Scanner teclado = new Scanner(System.in);
	/**
	 * Constructor de vehiculo.
	 * @param matricula
	 * @param marca
	 * @param modelo
	 * @param propietario
	 * @param anioMatriculacion
	 */
	public Vehiculo(String matricula, String marca, String modelo, String propietario, String anioMatriculacion) {
		this.matricula = matricula;
		this.marca = marca;
		this.modelo =  modelo;
		this.propietario = propietario;
		this.anioMatriculacion = anioMatriculacion;
		this.tieneMulta = false;
	}
	void ponerMulta(String fecha, String motivo, String importe) {
		tieneMulta = true;
		multas.add(new Multas(fecha, motivo, importe));
		
	}
	
	String juntarMultas() {
		int contador = 0;
		String juntar = "";
			for (Multas e : multas) {
				contador++;
				juntar = juntar + " <multa> " + e.fecha + " "  + e.motivo + " " + e.importe;
			}
			juntar = juntar + " |";
			return juntar;
		}
		
	
	
	void imprimirMultas() {
		int contador = 0;
		if (tieneMulta == true) {
			for (Multas e : multas) {
				contador++;
				System.out.println(contador + ". " + e );
			}
			return;
		}
		System.out.println("No tiene multas");
	}
	
	void eliminarMulta() {
		if (tieneMulta) {
			System.out.println("¿Que multa desea eliminar?");
			imprimirMultas();
			multas.remove(teclado.nextInt() - 1);
			if (multas.size() == 0) {
				tieneMulta = false;
			}
		}else {
			System.out.println("No tiene multas");
		}
	}
	
	public boolean equals(Vehiculo e) {
		if (matricula == e.matricula) {
			return true;
		}return false;
	}
	
	public String toString() {
		return "Matrícula: " + matricula + " Marca: " + marca + " Modelo: " + modelo + " Propietario: " + propietario + " Año de Matriculación: " + anioMatriculacion;
	}
}
