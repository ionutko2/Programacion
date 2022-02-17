package Cuatro;
/**
 * Generar dos vectores de dimensión 10 (dar valores aleatorios entre 1 y 5) y comprobar para
cada uno de los elementos del primer vector cuántas veces está en el segundo,
 * @author alu
 *
 */
import java.util.Random;
public class Cuatro {
	public static void main(String[] args) {
		int [] numeros1 = new int [10];
		int [] numeros2 = new int [10];
		int nveces = 0;
		Random r = new Random();
		for(int i = 0; i < numeros1.length; i++) {
			numeros1[i] = r.nextInt(5) + 1;
			numeros2[i] = r.nextInt(5) + 1;
			System.out.println(i + " :" + numeros1[i]);
			System.out.println(i + " :" + numeros2[i]);
		}for(int i = 0; i < numeros1.length; i++) {
			nveces = 0;
			for(int j = 0; j < numeros2.length; j++) {
				if (numeros1[i] == numeros2[j]) {
					nveces++;
				}
			}
			System.out.println("Elemento " + i + " (" + numeros1[i] + "): " + nveces + " veces.");
		}

	}

}