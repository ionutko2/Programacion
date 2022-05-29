package PruebaGuardarObjetos;

import java.io.*;
import java.util.ArrayList;

public class LeerYEscribir {
	static void escribir(ArrayList <ObjetoPrueba> p) {
		ObjectOutputStream salida = null;
		try {
			salida = new ObjectOutputStream(new FileOutputStream("src/prueba.txt"));
			for (ObjetoPrueba e: p) {
				salida.writeObject(e);
			}
		} catch (IOException e) {
			
		}finally {
			try {
				salida.close();
			} catch (IOException e) {
				
			}
		}
	}
	static ArrayList <ObjetoPrueba> leer() {
		ObjectInputStream entrada = null;
		ArrayList <ObjetoPrueba> p = new ArrayList <ObjetoPrueba>();
		try {
			entrada = new ObjectInputStream(new FileInputStream("src/prueba.txt"));
			while (true) {
				p.add((ObjetoPrueba) entrada.readObject());
			}
		} catch (IOException e) {
			try {
				entrada.close();
			} catch (IOException e1) {
				
			}
		} catch (ClassNotFoundException e) {
					
		}
		return p;
	}
}
