package Ejercicio1y2Tema11;

import java.util.*;
/**
 * Ejercicio 1
Escribe un programa que guarde en un fichero con nombre primos.txt los
números primos que hay entre 1 y 500. (Busca en Wikipedia "Criba de
Eratóstenes)ç
 * @author Ionut
 *
 */
public class NumerosPrimos {
	Set<Integer> numeros = new LinkedHashSet<Integer>();
	Set<Integer> numerosPrimos = new LinkedHashSet<Integer>();	
	
	public NumerosPrimos() {
		rellenar();
	}
	
	/**
	 * Metodo para rellenar el arraylist hasta llegar a 500
	 */
	public void rellenar() {
		
		for (int i = 1; i <= 500; i++) {
			numeros.add(i);
			numerosPrimos.add(i); // Este segundo ArrayList es solo porque si estoy usando un for each  no puedo eliminar un valor 
		}
	}
	
	public void imprimir() {
		
		for (Integer e : numerosPrimos) {
			System.out.println(e);
		}
		
	}
	
	public void cribaDeEratostenes() {
		
		for (Integer e : numeros) {
			if (e == 1) {
				numerosPrimos.remove(e);
			}
			for (Integer o : numeros) {
				if (e !=1) {
					if ((e < o && o % e ==0)) {
						numerosPrimos.remove(o);
					}
				}
			}
		}
	}
	
	public static void main (String [] Args) {
		NumerosPrimos prueba = new NumerosPrimos();
		prueba.cribaDeEratostenes();
		prueba.imprimir();
	}
}
