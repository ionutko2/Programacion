package Cinco;
import java.util.Scanner;
/**
 * Crea una clase que nos permita almacenar una colección de discos. El nombre de la clase será
Coleccion. Los datos miembro serán:
 Un vector de 100 elementos de la clase Disco.
 Un entero al que llamaremos índice que servirá para saber cuántos discos hemos
almacenado en la colección.
Diseña los métodos necesarios para gestionar la colección.
 * @author ionut
 *
 */
public class Coleccion {
	Disco[] discos = new Disco[100];
	Scanner teclado = new Scanner(System.in);
	int contador = 0;
	void asignarValores() {
		int añadirmas;
		boolean añadirmasdiscos = true;
		for (int i = 0; i < discos.length && añadirmasdiscos == true; i++) {
			discos[i] = new Disco();
			System.out.println("¿Cuál es el título del disco?");
			discos[i].setTitulo(teclado.nextLine());
			System.out.println("¿Cuántas canciones tiene?");
			discos[i].setNumeroCanciones(teclado.nextInt());
			System.out.println("¿Cuál es su precio?");
			discos[i].setPrecio(teclado.nextInt());
			System.out.println("¿Cuándo lo compró?");
			teclado.nextLine();
			discos[i].setFechaCompra(teclado.nextLine());
			do {
				System.out.println("¿Quieres añadir más discos? 1-Sí 2-No");
				añadirmas = teclado.nextInt();
				teclado.nextLine();
				if (añadirmas == 1) {
					añadirmasdiscos = true;
					contador++;
				}else if (añadirmas  == 2) {
					añadirmasdiscos = false;
				}else {
					System.out.println("Error");
				}
			}while(añadirmas != 1 && añadirmas != 2);
		}
	}
	void imprimirColeccion() {
		for (int indice = 0; indice <= contador;  indice++) {
			System.out.println("_____________________________________________________________________________________________________________________");
			System.out.println("Disco número: " + (indice + 1));
		    System.out.println(" Título: " + discos[indice].getTitulo());
			System.out.println(" Número de canciones: " + discos[indice].getNumeroCanciones());
			System.out.println(" Precio: " + discos[indice].getPrecio());
			System.out.println(" Fecha de compra: " + discos[indice].getFechaCompra());
			System.out.println("_____________________________________________________________________________________________________________________");
		}
	}
	public static void main (String [] args) {
		Coleccion coleccion = new Coleccion();
		coleccion.asignarValores();
		coleccion.imprimirColeccion();
	}
}
