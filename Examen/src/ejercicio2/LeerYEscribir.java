package ejercicio2;


import java.io.*;
import java.util.ArrayList;

public class LeerYEscribir {
	
	/**
	 * Método para escribir en un archivo objetos de la clase Contacto
	 * @param p para ello hay que darle un arraylist de Contacto
	 */
	static void escribir(ArrayList <Contacto> p) {
		ObjectOutputStream salida = null;
		try {
			salida = new ObjectOutputStream(new FileOutputStream("src/agenda.dat"));
			for (Contacto e: p) {
				salida.writeObject(e);
			}
		} catch (IOException e) {
			
		}finally {
			try {
				if (salida != null) {
					salida.close();
				}
			} catch (IOException e) {
				
			}
		}
	}
	/**
	 * metodo para leer un archivo y  convertir esa informacion en un arraylist de contactos
	 * @return un arraylist de contactos
	 */
	static ArrayList <Contacto> leer() {
		ObjectInputStream entrada = null;
		ArrayList <Contacto> p = new ArrayList <Contacto>();
		try {
			entrada = new ObjectInputStream(new FileInputStream("src/agenda.dat"));
			while (true) {
				p.add((Contacto) entrada.readObject());
			}
		} catch (IOException e) {
			try {
				if (entrada != null) {
					entrada.close();
				}
			} catch (IOException e1) {
				
			}
		} catch (ClassNotFoundException e) {
					
		}
		return p;
	}
}
