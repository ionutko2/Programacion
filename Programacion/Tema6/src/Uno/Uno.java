package Uno;
/**
 * Se generan 20 números aleatorios de tipo entero y se almacenan en un vector. Hay que calcular
y mostrar la media y, además, mostrar cuántos números hay:
-Superiores a la media
-Inferiores a la media
-Iguales a la media
 * @author alu
 *
 */
import java.util.Random;
public class Uno {
	public static void main (String [] args) {
		int [] numeros = new int [20];
		Random r = new Random();
		int suma = 0;
		int media;
		int mayor = 0;
		int menor = 0;
		int igual = 0;
		
		// Dar un valor aleatorio a cada numero y sumar los números.
		for(int i = 0; i < numeros.length; i++) {
			numeros[i] = r.nextInt(100);
			suma = suma + numeros[i];
		}
		
		// Calcular la media y ver cuantos valores son mayores, menores o iguales a la media.
		media = suma / numeros.length;
		for(int i = 0; i < numeros.length; i++) {
			if (numeros[i] < media) {
				menor++;
			}else if (numeros[i] > media) {
				mayor++;
			}else {
				igual++;
			}
		}
		System.out.println("La media de estos números es: " + media + ". Hay " + mayor + " numeros que superan la media, " + menor + " que son inferiores y " + igual + " que son iguales.");
	}

}