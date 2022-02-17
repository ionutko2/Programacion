package Siete;
import java.util.Scanner;

public class Conjunto {
	private int [] numeros;
	Scanner teclado = new Scanner(System.in);
	/**
	 * En el constructor solo creo el vector con 100 variables y lo iniciazo a 0.
	 */
	public Conjunto(){
		numeros = new int [100];
		vaciar();
	}
	/**
	 * Le asigno el valor 0 a todas posiciones del vector.
	 */
	public void vaciar() {
		for ( int i = 0 ; i < numeros.length ; i++ ) {
			numeros [i] = 0;
		}
	}
	/**
	 * Le a�ado el valor deseado a la posicion deseada, comprobando tambien que la posicion se encuentra dentro del dominio del vector y compruebo tambien que el
	 * valor no esta repetido.
	 */
	public void agregarValor() {
		int posicion, valor, numseguir;
		boolean seguir = true; //Valor para saber si pasar a la siguiente posici�n del vector.
		boolean igual = false; // Valor para saber si ese n�mero ya existe en el vector.
		boolean bien = true; // Valor para comprobar si el valor es 1 o 2.
		boolean posicionbien = true; // Valor para saber si la poscion existe en el vector.
		do {
			do { // Elegir posici�n y comprobar que la posici�n se encuentra dentro del  rango del vector.
				System.out.println("Elija una posicion");
				posicion = teclado.nextInt() - 1;
				if ( posicion < 0  || posicion >= numeros.length ) {
					System.out.println("Error, posici�n no encontrada.");
					posicionbien = false;
				}else {
					posicionbien = true;
				}
			}while (posicionbien == false);
			
			do { // Elegir un valor para esa posici�n y comprobar que no se repita
				igual = false;
				System.out.println("Elija un valor para esa posici�n");
				valor = teclado.nextInt();
				for ( int i = 0 ; i < numeros.length && igual == false ; i++ )
					if ( valor == numeros [i] && i != posicion) {
						igual = true;
					}else {
						numeros [posicion] = valor;
						igual = false;
					}
				if ( igual == true ) {
					System.out.println("Error, este n�mero ya se encuentra en el vector.");
				}
			}while (igual == true);
			
			do { // Elegir si seguir a�adiendo datos o no
				System.out.println("�Quiere seguir a�adiendo datos? 1-Si 2-No");
				numseguir = teclado.nextInt();
				if ( numseguir == 1 ) {
					seguir = true;
					bien = true;
				}else if ( numseguir == 2 ) {
					seguir = false;
					bien = true;
				}else {
					bien = false;
					System.out.println("Error, n�mero incorrecto.");
				}
			}while ( bien == false );
		}while ( seguir  == true );
	}
	/**
	 * Eliminar el valor de la posicion deseada y ademas mover todos los valores una posicion.
	 */
	public void eliminarValor() {
		int posicion;
		boolean posicionbien = true;
		do { // Elegir posici�n y comprobar que la posici�n se encuentra dentro del  rango del vector.
			System.out.println("�A qu� posici�n quiere eliminarle el valor?");
			posicion = teclado.nextInt() - 1;
			if ( posicion < 0  || posicion >= numeros.length ) {
				System.out.println("Error, posici�n no encontrada.");
				posicionbien = false;
			}else {
				posicionbien = true;
			}
		}while (posicionbien == false);
		for ( int i = posicion ; i < ( numeros.length ); i++ ) {
			if ( i < numeros.length - 1 ) {
				numeros[i] = numeros[i + 1];
			}else {
				numeros[i] = 0;
			}
		}
	}
	/**
	 * Crear un nuevo vector id�ntico al anterior.
	 */
	public void copiarConjunto() {
		int[] numeros1 = new int [numeros.length]; // Asigno la misma longitud de vector.
		for ( int i = 0 ; i < numeros1.length ; i++ ) { // Doy el valor de cada posicion del primer vector al segundo.
			numeros1[i]  = numeros[i];
		}
	}
	/**
	 * Comprobar si el numero elegido  pertenece al conjunto.
	 * @return true si pertenece false si no
	 */
	public boolean esMiembro() {
		int numero;
		boolean esMiembro = false;
		System.out.println("Qu� n�mero desea comrpobar si pertenece al conjunto?");
		numero = teclado.nextInt();
		for ( int i = 0 ; i < numeros.length && esMiembro == false ; i++) {
			if ( numeros[i] == numero ) {
				esMiembro  = true;
			}else {
				esMiembro = false;
			}
		}
		return esMiembro;
	}
	/**
	 * Comprobar si el numero elegido  pertenece al conjunto.
	 * @return la posicion donde se encuentra y -1 si no se encuentra.
	 */
	public int posicion() {
		int numero;
		boolean esMiembro = false;
		int posicion = 0;
		System.out.println("Qu� n�mero desea comrpobar si pertenece al conjunto?");
		numero = teclado.nextInt();
		for ( int i = 0 ; i < numeros.length && esMiembro == false ; i++) {
			if ( numeros[i] == numero ) {
				esMiembro  = true;
				posicion = i + 1;
			}else {
				esMiembro = false;
				posicion = -1;
			}
		}
		return posicion;
	}
	/**
	 * Comprobar si dos vectores son id�nticos.
	 * @param numeros vector con  el que lo compara.
	 * @return true si son id�nticos y false si no.
	 */
	public boolean esIgual(int[]numeros) {
		boolean esIgual = false;
		int contador = 0; // Cuenta las veces que se repita un valor en la misma posicion de cada vector.
		if (numeros.length == this.numeros.length) {
			for ( int i = 0 ; i < numeros.length && esIgual == false ; i++ ) {
				if ( numeros[i] == this.numeros[i] ) {
					contador++;
				}
				if ( contador == numeros.length) {
					esIgual = true;
				}else {
					esIgual = false;
				}
			}
		}else {
			esIgual = false;
		}
		return esIgual;
	}
	/**
	 * Leer el vector numeros.
	 */
	public void leer() {
		for ( int i = 0 ; i < numeros.length ; i++ ) {
			System.out.print(numeros [i] + " ");
			if ( (i + 1) % 10 == 0 && i != 0 ) { // Esto solo es para poner n�meros de 10 en 10 en cada fila.
				System.out.println();
			}
		}
	}
}
