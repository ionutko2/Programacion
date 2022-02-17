package Dos;
/**
 * Leer dos vectores de dimensión 10 para construir un tercer vector cuyos componentes sean la
suma de los dos anteriores e imprimirlo
 * @author alu
 *
 */
import java.util.Random;
public class Dos {
	public static void main (String [] args) {
		int [] numeros1 = new int [10];
		int [] numeros2 = new int [10];
		int [] numeros3 = new int [10];
		Random r = new Random();
		// Asignar un valor aleatorio a los vectores numeros1 y numeros2.
		for(int i = 0; i < numeros1.length; i++) {
			numeros1[i] = r.nextInt(100);
			numeros2[i] = r.nextInt(100);
		}
		// Sumar los vectores anteroiormente mencionados e imprimir la solución.
		System.out.println("La suma es de:");
		for (int i = 0; i < numeros1.length; i++) {
			numeros3[i] = numeros1[i] + numeros2[i];
			System.out.println(numeros3[i]);
		}
	}
}