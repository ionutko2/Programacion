package Nueve;
/**
 * Escribe un proyecto en Java que tenga: una clase llamada Comedor en la que estará el método
main() y en la que se instanciarán los objetos de las clases que sean necesarias para:
 Mostrar la carta de un restaurante en el que se ofrecen 6 platos. En cada plato se
mostrarán los ingredientes que lo componen y el precio de ese plato.
 Se supone que en el restaurante se pueden servir en un día un máximo de 100 menús.
Cada menú consta de dos platos y a la bebida y el postre invita la casa.
 A cada cliente que vaya al restaurante se le anotará cuántos menús quieren en su mesa,
qué platos han formado cada uno y el precio de cada menú. A la hora de pagar se
mostrará en pantalla: el detalle de los menús que tiene que pagar, indicando el precio
de cada plato y el de cada menú, el total a pagar, el dinero entregado y el cambio.
 * @author Ionut
 *
 */
import java.util.Scanner;
public class Comedor {
	private String [] menu = new String [200];
	Scanner teclado = new Scanner(System.in);
	int contador;
	
	public  String platos (int i) {
		String [] platos = new String [6];
		platos[0] = "1 Caviar del malo";
		platos[1] = "2 Caviar del bueno";
		platos[2] = "3 Ensalada cesar hecha por un romano de su época";
		platos[3] = "4 No se ni lo que  es";
		platos[4] = "5 Tortilla española a la francesa xD";
		platos[5] = "6 Mis ganas de vivir";
		return platos [i];
	}
	
	public int precio(int i) {
		int [] precio = new int [6];
		precio [0] = 100;
		precio [1] = 200;
		precio [2] = 20;
		precio [3] = 15;
		precio [4] = 32;
		precio [5] = 1276;
		return precio[i];
	}
	
	public String ingredientes(int i) {
		String [] ingredientes = new  String [6];
		ingredientes [0] = "Caviar que no es tan bueno xD";
		ingredientes [1] = "Caviar mejor que el anterior";
	    ingredientes [2] = "Lo que tiene una ensalada cesar";
	    ingredientes [3] = "Si no se lo que es, imaginate lo que lleva";
	    ingredientes [4] = "Si";
	    ingredientes [5] = "Pues mis ganas de vivir, que como no son muchas pues vale un riñon ☺";
	    return ingredientes [i];
	}
	
	public void imprimirMenu() {
		System.out.println("MENU");
		for (int i = 0; i < 6; i++) {
			System.out.println(platos(i) + "\nIngredientes: " + ingredientes(i) + " Precio: " + precio(i));
		}
	}
	
	public void elegirPlatos() {
		boolean seguir = true;
		boolean error = true;
		int pregunta;
		contador = 0;
		for (int i = 0; i < menu.length && seguir == true; i++) {
			int [] numero = new int [200];
			System.out.println("¿Que desea?");
			numero [i] = teclado.nextInt() -1; 
			menu [i] = platos(numero[i]) + "\nIngredientes: " + ingredientes(numero[i]) + " Precio: " + precio(numero[i]);
			contador++;
			if (i % 2 != 0) {
				do {
					System.out.println("Quiere mas menus? 1- si 2- no");
					pregunta = teclado.nextInt();
					if (pregunta == 1) {
						seguir = true;
						error = false;
					}else if (pregunta == 2) {
						seguir = false;
						error = false;
					}else {
						error = true;
						System.out.println("Error");
					}
				}while(error == true);
			}
			
			
		}
	}
	
	public void imprimirEleccion() {
		int contar = 1;
		for (int i = 0; i < contador; i++) {
			if (i % 2 == 0) {
				System.out.println("MENU " + contar);
				contar++;
			}
			System.out.println(menu[i]);
			if (i % 2 != 0) {
				System.out.println("PRECIO MENU " + );
			}
		}
	}
	
	public static void main (String [] args) {
		Comedor menu = new Comedor();
		menu.imprimirMenu();
		menu.elegirPlatos();
		menu.imprimirEleccion();
	}
}
