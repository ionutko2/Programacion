package Ejercicio1y2Tema11;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * Ejercicio 2
Realiza un programa que lea el fichero creado en el ejercicio anterior y que
muestre los números por pantalla.
 * @author Ionut
 *
 */
public class Archivo {
	Scanner s = null;
	
	public Archivo() {
		try {
			s = new Scanner(
					new BufferedReader(
							new FileReader("numerosprimos.txt")));
		} catch (FileNotFoundException e) {
			System.out.println("Se ha creado un archivo con ese nombre");
		}
	}
	public void escribirArchivo() {
		NumerosPrimos primos = new NumerosPrimos();
		primos.cribaDeEratostenes();
		PrintStream ps = null;
		try {
			ps = new PrintStream(new FileOutputStream("numerosprimos.txt"));
			ps.println(primos.numerosPrimos);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ps.close();
		}
	}
	public static void main (String [] Args) {
		Archivo prueba = new Archivo();
		prueba.escribirArchivo();
	}
}
