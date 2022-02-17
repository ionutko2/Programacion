package Tres;
/**
 * Leer un vector de 10 componentes enteros; calcular el mayor, el menor y los lugares donde se
encuentran.
 * @author alu
 *
 */
import java.util.Random;
public class Tres {
	public static void main (String [] args) {
		int [] numeros = new int [10];
		Random r = new Random();
		int menor = 100;
		int menorpos = 0;
		int mayor = 0;
		int mayorpos = 0;
			
		// Asignarle valores aleatorios al vector.
		for(int i = 0; i < numeros.length; i++) {
			numeros[i] = r.nextInt(100);
		}
		// Calcular cual es el menor y el mayor.
		for(int i = 0; i < numeros.length; i ++) {
			if (numeros[i] < menor) {
				menor = numeros[i];
				menorpos = i;
			}
			if (numeros[i] > mayor) {
				mayor = numeros[i];
				mayorpos = i;
			}
		}
		System.out.println("Mayor: " + mayorpos + ": " + mayor);
		System.out.println("Menor: " + menorpos + ": " + menor);
	}
}