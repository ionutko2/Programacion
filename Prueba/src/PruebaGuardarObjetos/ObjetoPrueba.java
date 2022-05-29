package PruebaGuardarObjetos;

import  java.io.*;

public class ObjetoPrueba implements Serializable {
	int numero;
	String palabara;
	public ObjetoPrueba(int numero, String palabra) {
		this.numero = numero;
		this.palabara = palabra;
	}
}
