
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Agenda {
	ArrayList <Contacto> contactos = new ArrayList <Contacto>();
	public Agenda() {
		contactos = LeerYEscribir.leer();
	}
	
	public void imprimirMenu() {
		String opcion;
		boolean fin = false;
		Scanner teclado = new Scanner(System.in);
		while (!fin) {
			System.out.println("¿Que desea realizar?"
					+ "\n\t 1. Añadir contacto."
					+ "\n\t 2. Borrar  contacto."
					+ "\n\t 3. Ordenar de manera alfabética."
					+ "\n\t 4. Buscar por nombre."
					+ "\n\t 5. Añadir un teléfono."
					+ "\n\t 6. Borrar un teléfono."
					+ "\n\t 7. Buscar por teléfono."
					+ "\n\t 0. Salir.");
			opcion =  teclado.nextLine();
			
			switch (opcion){
			case ("0"):
				fin = true;
				break;
			case ("1"):
				annadirContacto();
				break;
			case ("2"):
				borrarContacto();
				break;
			case ("3"):
				imprimirAlfabético();
				break;
			case ("4"):
				String nombre = buscarNombre();
				if (nombre == null) {
					System.out.println("Ese usuario no se encuentra en la base de datos");
				}else {
					System.out.println(nombre);
				}
				break;
			case ("5"):
				annadirTelefono();
				break;
			case ("6"):
				borrarTelefono();
				break;
			case ("7"):
				buscarTelefono();
				break;
			default:
				System.out.println("Opción no contemplada");
			}
		}
	}
	
	public boolean comprobarSiYaExiste(String nombre) {
		for (Contacto e : contactos) {
			if (e.nombre.equals(nombre)) {
				return true;
			}
		}
		return false;
	}
	
	public void annadirContacto() {
		Scanner teclado = new Scanner(System.in);
		System.out.println("Escriba el nombre del contacto");
		String nombre = teclado.nextLine();
		if (comprobarSiYaExiste(nombre)) {
			System.out.println("El nombre ya se encuentra guardado");
		}else {
			contactos.add(new Contacto(nombre));
			LeerYEscribir.escribir(contactos);
		}
	}
	
	public void imprimirContactos() {
		int contador = 1;
		for (Contacto e : contactos) {
			System.out.println(contador + ". " + e.nombre + " " + e.telefonos);
			contador++;
		}
	}
	
	public void borrarContacto() {
		Scanner teclado = new Scanner(System.in);
		System.out.println("¿Que contacto quieres borrar?");
		imprimirContactos();
		int numero;
		try {
			numero = teclado.nextInt() - 1;
			try {
				contactos.remove(numero);
			}catch(IndexOutOfBoundsException e1) {
				System.out.println("Opción no contemplada");
			}
		}catch (InputMismatchException e){
			System.out.println("Solo admite números");
		}
		
	}
	
	public void imprimirAlfabético() {
		Collections.sort(contactos);
		imprimirContactos();
	}
	
	public String buscarNombre() {
		System.out.println("Introduzca el nombre del usuario que quiere buscar");
		Scanner teclado = new Scanner(System.in);
		String nombre = teclado.nextLine();
		for (Contacto e: contactos) {
			if (e.nombre.equals(nombre)) {
				return e.nombre + e.telefonos;
			}
		}
		return null;
	}
	public void annadirTelefono() {
		Scanner teclado = new Scanner(System.in);
		System.out.println("A que contacto quiere añadirle un teléfono?");
		imprimirContactos();
		int numero;
		try {
			numero = teclado.nextInt() - 1;
			try {
				System.out.println("Indique el número de teléfono que quiere añadir");
				teclado.nextLine();
				String tel = teclado.nextLine();
				contactos.get(numero).annadirTelefono(tel);
				LeerYEscribir.escribir(contactos);
			}catch(IndexOutOfBoundsException e1) {
				System.out.println("Opción no contemplada");
			}
		}catch (InputMismatchException e){
			System.out.println("Solo admite números");
		}
	}
	
	public void borrarTelefono() {
		Scanner teclado = new Scanner(System.in);
		System.out.println("A que contacto quiere borrarle un teléfono?");
		imprimirContactos();
		int numero;
		try {
			numero = teclado.nextInt() - 1;
			if (contactos.get(numero).telefonos.size() > 0) {
				System.out.println("Que telefono desea eliminar?");
				contactos.get(numero).imprimirTelefonos();
				try {
					int eliminar = teclado.nextInt() - 1;
					contactos.get(numero).eliminarTelefono(eliminar);
					LeerYEscribir.escribir(contactos);
				}catch (InputMismatchException e){
					System.out.println("Solo admite números");
				}catch (IndexOutOfBoundsException e1) {
					System.out.println("Opción no contemplada");
				}
			}else {
				System.out.println("El usuario no tiene teléfonos añadidos");
			}
			
		}catch (InputMismatchException e2){
			System.out.println("Solo admite números");
		}catch (IndexOutOfBoundsException e3) {
			System.out.println("Opción no contemplada");
		}
	}
	public void buscarTelefono() {
		System.out.println("Introduzca el numero de telefono por el que quiere buscar usuarios");
		Scanner teclado = new Scanner(System.in);
		String tel = teclado.nextLine();
		int contador = 1;
		for (Contacto e: contactos) {
			for (Telefono p: e.telefonos) {
				if (p.numero.equals(tel)) {
					System.out.println(contador + ". " + e.nombre + " " + e.telefonos);
					contador++;
				}
			}
		}
		if (contador == 1) {
			System.out.println("Ese telefono no se encuentra asociado a ningún usuario");
		}
	}
}
