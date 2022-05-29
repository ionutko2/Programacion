package PruebaGuardarObjetos;

import java.util.ArrayList;
import java.util.Scanner;

public class ProgramaPrueba {
	public static void main (String [] args) {
		ObjetoPrueba prueba1 = null;
		ObjetoPrueba prueba = new ObjetoPrueba(123,"hola");
		ObjetoPrueba prueba2 = new ObjetoPrueba(153,"hosad");
		ObjetoPrueba prueba3 = new ObjetoPrueba(1278,"hsdla");
		ObjetoPrueba prueba4 = new ObjetoPrueba(113,"houyt");
		ArrayList <ObjetoPrueba> pruebas = new ArrayList <ObjetoPrueba>();
		
		pruebas = LeerYEscribir.leer();
		/*for (ObjetoPrueba p : pruebas) {
			System.out.println(p.palabara + " " + p.numero);
		}
		pruebas.add(prueba);
		pruebas.add(prueba2);
		pruebas.add(prueba3);
		pruebas.add(prueba4);
		LeerYEscribir.escribir(pruebas);*/
		System.out.println("Elige el objeto a eliminar");
		int contador = 1;
		for (ObjetoPrueba p : pruebas) {
			System.out.println(contador + ". " + p.palabara + " " + p.numero);
			contador++;
		}
		Scanner teclado = new Scanner(System.in);
		int eliminar = teclado.nextInt() - 1;
		pruebas.remove(eliminar);
		contador = 1;
		for (ObjetoPrueba p : pruebas) {
			System.out.println(contador + ". " + p.palabara + " " + p.numero);
			contador++;
		}
		/*prueba1 = LeerYEscribir.leer();
		System.out.println(prueba1.palabara);*/
	}
}
