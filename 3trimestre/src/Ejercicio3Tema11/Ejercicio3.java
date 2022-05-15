package Ejercicio3Tema11;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintStream;
import java.util.*;

/**
 * Ejercicio 3
Escribe un programa que guarde en un fichero el contenido de otros dos ficheros,
de tal forma que en el fichero resultante aparezcan las líneas de los primeros dos
ficheros mezcladas, es decir, la primera línea será del primer fichero, la segunda
será del segundo fichero, la tercera será la siguiente del primer fichero, etc.
Los nombres de los dos ficheros origen y el nombre del fichero destino se deben
pasar como argumentos en la línea de comandos.
Hay que tener en cuenta que los ficheros de donde se van cogiendo las líneas
pueden tener tamaños diferentes.
 * @author Ionut
 *
 */
public class Ejercicio3 {
	Scanner s = null;
	Scanner p = null;
	Set<String> copia = new LinkedHashSet<String>();
	
	/**
	 * Se necesita introducir el nombre de los archivos de origen y el de destino en String
	 * @param origen1
	 * @param origen2
	 * @param destino
	 */
	public Ejercicio3(String origen1, String origen2, String destino) {
		leerArchivos(origen1, origen2);
		escribirArchivo(destino);
		
	}
	
	public void leerArchivos(String origen1, String origen2) {
		
		try {
			p = new Scanner(
					new BufferedReader(
							new FileReader(origen2 + ".txt")));
			s = new Scanner(
					new BufferedReader(
							new FileReader(origen1 + ".txt")));
			while (s.hasNext() || p.hasNext()) {
				if (s.hasNext()) {
					copia.add(s.next());
				}
				if (p.hasNext()) {
					copia.add(p.next());
				}
			}
			s.close();
			p.close();

		} catch (FileNotFoundException e) {
			
		}
	}
	
	public void escribirArchivo(String destino) {
		
		PrintStream ps = null;
		
		for (String p : copia) {
			try {
				ps = new PrintStream(new FileOutputStream(destino + ".txt", true));
				ps.println(p);
			} catch (FileNotFoundException e) {
				
			} finally {
				ps.close();
			}
		}
		
	}
	public static void main (String [] Args) {
		Scanner teclado = new Scanner(System.in);
		String origen1, origen2, destino;
		System.out.println("Escriba los archivos de origen");
		origen1 = teclado.nextLine();
		origen2 = teclado.nextLine();
		System.out.println("Escriba el archivo de destino");
		destino = teclado.nextLine();
		Ejercicio3 prueba = new Ejercicio3(origen1, origen2, destino);
	}
}
