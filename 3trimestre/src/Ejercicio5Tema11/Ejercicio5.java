package Ejercicio5Tema11;

import java.io.*;
import java.util.*;

/**
 * Ejercicio 5
Escribe un programa capaz de quitar los comentarios de un programa de Java.
Se utilizaría de la siguiente manera:
quita_commentarios PROGRAMA_ORIGINAL PROGRAMA_LIMPIO
Por ejemplo:
quita_comentarios hola.java holav2.java

crea un fichero con nombre holav2.java que contiene el código de hola.java pero
sin los comentarios.
 * @author Ionut
 *
 */
public class Ejercicio5 {
	List<String> archivo = new LinkedList<String>();
	Scanner s = null;
	String programa;
	
	public Ejercicio5(String programa) {
		this.programa = programa;
	}
	
	
	public void leerPrograma() {
		try {
			s = new Scanner(new BufferedReader(new FileReader(programa + ".java")));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			
		}
		/*
		String comparador;
		PrintStream ps = null;
		while(s.hasNext()) {
			comparador = s.next();
			if(comparador == "/*" || comparador == "/**") {
				while(comparador != "") {
					comparador = s.next();
				}
			}else if (comparador == "//") {
				comparador = s.nextLine();
			}else {
				try {
					ps = new PrintStream (new FileOutputStream(programa + "v2.java",true));
					ps.print(comparador + " ");
				} catch (FileNotFoundException e) {
					
				}finally{
					ps.close();
				}
			}
		}*/
	}
	public static void main (String [] Args) {
		Scanner teclado = new Scanner(System.in);
		System.out.println("Escriba el nombre del programa al que le  quiere eliminar los comentarios");
		Ejercicio5 prueba = new Ejercicio5(teclado.nextLine());
		
		prueba.leerPrograma();
	}
}
