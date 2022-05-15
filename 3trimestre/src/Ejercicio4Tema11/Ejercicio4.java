package Ejercicio4Tema11;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintStream;
import java.util.*;

/**
 * Ejercicio 4
Realiza un programa que sea capaz de ordenar alfabéticamente las palabras
contenidas en un fichero de texto. El nombre del fichero que contiene las
palabras se debe pasar como argumento en la línea de comandos. El nombre
del fichero resultado debe ser el mismo que el original añadiendo la coletilla sort,
por ejemplo palabras_sort.txt. Suponemos que cada palabra ocupa una línea.
 * @author Ionut
 *
 */
public class Ejercicio4 {
	Set<String> palabras = new TreeSet<String>(); //Este tipo de colección ordena de manera automática los valores que recibe
	
	Scanner p = null;
	String origen;
	
	/**
	 * Se necesitas pasar como String el niombre del archivo a ordenar
	 * @param origen
	 */
	public Ejercicio4(String origen) {
		this.origen = origen;
		leerArchivos(origen);
		escribirArchivo();
	}
	
	public void leerArchivos(String origen) {
			
		try {
			p = new Scanner(
					new BufferedReader(
							new FileReader(origen + ".txt")));
				
			while (p.hasNext()) {
					
				if (p.hasNext()) {
					palabras.add(p.next());
				}
			}
	
		} catch (FileNotFoundException e) {
				
		}
	}
	public void escribirArchivo() {
			
		PrintStream ps = null;
		try {
			ps = new PrintStream(new FileOutputStream(origen + "_sort.txt", false));
			ps.print("");
		} catch (FileNotFoundException e) {
			
		} finally {
			ps.close();
			
		}
		for (String p : palabras) {
			try {
				ps = new PrintStream(new FileOutputStream(origen + "_sort.txt", true));
				ps.println(p);
			} catch (FileNotFoundException e) {
				
			} finally {
				ps.close();
				
			}
		}
		System.out.println("Palabra ordenadas en el archivo: " + origen + "_sort");
	}
	
	public static void main (String [] Args) {
		Scanner teclado = new Scanner(System.in);
		System.out.println("Escriba el archivo a ordenar");
		Ejercicio4 prueba = new Ejercicio4(teclado.nextLine());
	}

	
}
