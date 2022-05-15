package Ejercicio2Temafin;

import java.util.*;
import java.io.*;
/**
 * Lo estoy haciendo sin usar colleciones
 * @author Ionut
 *
 */
public class Menu {
	Scanner teclado = new Scanner(System.in);
	int  contadorVenta;
	public void imprimirMenu() {
		boolean fin = false;
		int opcion;
		
		while (!fin) {
			System.out.println("¿Que desea realizar?"
					+ "\n\t 1.Añadir un viajante"
					+ "\n\t 2.Eliminar un viajante"
					+ "\n\t 3.Mostrar un listado de todos los viajantes"
					+ "\n\t 4.Inicializar ventas"
					+ "\n\t 5.Incrementar distancia reccorida"
					+ "\n\t 6.Aañdir venta"
					+ "\n\t 7.Cobrar venta"
					+ "\n\t 8.Mostrar ventas no cobradas de un viajante"
					+ "\n\t 9.Finalizar");
			opcion = teclado.nextInt();
			switch(opcion) {
			case 1:
				annadirViajante();
				break;
			case 2:
				eliminarViajante();
				break;
			case 3:
				mostrarViajantes();
				break;
			case 4:
				inicializarVentas();
				break;
			case 5:
				aumentarDistancia();
				break;
			case 6:
				annadirVenta();
				break;
			case 7:
				cobrarVenta();
				break;
			case 8:
				break;
			case 9:
				fin = true;
				break;
			}
		}
	}
	
	public void annadirViajante() {
		teclado.nextLine();	
		String dni, nombre;
		int antiguedad, distancia;
		System.out.println("DNI del cliente");
		dni = teclado.nextLine();
		System.out.println("Nombre del cliente");
		nombre = teclado.nextLine();
		System.out.println("Antiguedad del cliente");
		antiguedad = teclado.nextInt();
		System.out.println("Distancia recorrida");
		distancia = teclado.nextInt();
		Viajante nuevoViajante = new Viajante(dni, nombre, antiguedad, distancia);
		PrintStream ps = null;
		try {
			ps = new PrintStream(new FileOutputStream("viajantes.txt", true));
			ps.println(nuevoViajante);
		} catch (FileNotFoundException e) {
			
		}finally {
			ps.close();
		}
	}
	
	public int contarLineas(String archivo) {
		int contador = 0;
		Scanner s = null;
		try {
			s = new Scanner (new BufferedReader(new FileReader(archivo)));
			while (s.hasNextLine()) {
				contador++;
				s.nextLine();
			}
			
		} catch (FileNotFoundException e) {
		
		}
		return contador;
	}
	
	public void eliminarViajante() {
		System.out.println("¿A quién desea eliminar?");
		mostrarViajantes();
		int opcion = teclado.nextInt();
		String [] eliminar = new String[contarLineas("viajantes.txt")];
		Scanner s = null;
		try {
			s = new Scanner (new BufferedReader(new FileReader("viajantes.txt")));
			for (int i = 0; i < eliminar.length; i++) {
				eliminar [i] = s.nextLine(); 
			}
			
		} catch (FileNotFoundException e) {
		
		}
		PrintStream ps = null;
		try {
			ps = new PrintStream(new FileOutputStream("viajantes.txt", false));
			ps.print("");
		} catch (FileNotFoundException e) {
			
		}finally {
			ps.close();
		}
		try {
			ps = new PrintStream(new FileOutputStream("viajantes.txt", true));
			for (int i = 0; i < eliminar.length; i++) {
				if(i != (opcion - 1)) {
					ps.println(eliminar[i]);
				}
			}
		} catch (FileNotFoundException e) {
			
		}finally {
			ps.close();
		}
	}
	
	public void mostrarViajantes() {
		Scanner s = null;
		int contador = 0;
		try {
			s = new Scanner (new BufferedReader(new FileReader("viajantes.txt")));
			while (s.hasNextLine()) {
				contador++;
				System.out.print(contador + ". ");
				for (int i = 0; i < 5; i++) {
					System.out.print(s.next() + " ");
				}
				System.out.println("");
				s.nextLine();
			}
			
		} catch (FileNotFoundException e) {
		
		}
	}
	// falta la segunda parte
	public void inicializarVentas() {
		// Poner a 0 la distancia recorrida de todos los viajantes
		String [] inicializador = new String[contarLineas("viajantes.txt")];
		Scanner s = null;
		try {
			s = new Scanner (new BufferedReader(new FileReader("viajantes.txt")));
			for (int i = 0; i < inicializador.length; i++) {
				
				inicializador [i] = s.next() + " ";
				inicializador [i] += s.next() + " ";
				inicializador [i] += s.next() + " ";
				inicializador [i] += 0 + " ";
				s.next();
				inicializador [i] += s.next();
			}
			
		} catch (FileNotFoundException e) {
		
		}
		PrintStream ps = null;
		try {
			ps = new PrintStream(new FileOutputStream("viajantes.txt", false));
			ps.print("");
		} catch (FileNotFoundException e) {
			
		}finally {
			ps.close();
		}
		try {
			ps = new PrintStream(new FileOutputStream("viajantes.txt", true));
			for (int i = 0; i < inicializador.length; i++) {
				ps.println(inicializador[i]);
			}
		} catch (FileNotFoundException e) {
			
		}finally {
			ps.close();
		}
		
	}
	
	public void aumentarDistancia() {
		System.out.println("¿Cual es su cuenta??");
		mostrarViajantes();
		int usuario = teclado.nextInt() - 1;
		System.out.println("¿Cuanto ha reccorrido?");
		int recorrido = teclado.nextInt();
		String [] aumentar = new String[contarLineas("viajantes.txt")];
		Scanner s = null;
		try {
			s = new Scanner (new BufferedReader(new FileReader("viajantes.txt")));
			
			for (int i = 0; i < aumentar.length; i++) {
				
				
				if  (i != usuario) {
					aumentar [i] = s.next() + " ";
					aumentar [i] += s.next() + " ";
					aumentar [i] += s.next() + " ";
					aumentar [i] += s.next() + " ";
					aumentar [i] += s.next();
				}else {
					aumentar [i] = s.next() + " ";
					aumentar [i] += s.next() + " ";
					aumentar [i] += s.next() + " ";
					int suma = s.nextInt() + recorrido;
					aumentar [i] += (suma + " ");
					aumentar [i] += s.next();
				}
				
			}
			
		} catch (FileNotFoundException e) {
		
		}
		PrintStream ps = null;
		try {
			ps = new PrintStream(new FileOutputStream("viajantes.txt", false));
			ps.print("");
		} catch (FileNotFoundException e) {
			
		}finally {
			ps.close();
		}
		try {
			ps = new PrintStream(new FileOutputStream("viajantes.txt", true));
			for (int i = 0; i < aumentar.length; i++) {
				ps.println(aumentar[i]);
			}
		} catch (FileNotFoundException e) {
			
		}finally {
			ps.close();
		}
	}
	public void annadirVenta() {
		teclado.nextLine();	
		String fecha, importe, cliente;
		System.out.println("¿Cual es su DNI?");
		cliente = teclado.nextLine();
		System.out.println("Fecha de la venta");
		fecha = teclado.nextLine();
		System.out.println("Importe de la venta");
		importe = teclado.nextLine();
		Venta nuevaVenta = new Venta(cliente, fecha, importe);
		PrintStream ps = null;
		try {
			ps = new PrintStream(new FileOutputStream("ventas.txt", true));
			ps.println(nuevaVenta);
		} catch (FileNotFoundException e) {
			
		}finally {
			ps.close();
		}
	}
	
	public String imprimirVentaUsuario(int usuario) {
		Scanner s = null;
		Scanner p = null;
		contadorVenta = 0;
		String usuario1 = "";
		try {
			p = new Scanner(new BufferedReader(new FileReader("viajantes.txt")));
			for ( int i = 0; i < contarLineas("viajantes.txt"); i++) {
				if (i == usuario) {
					usuario1 = p.next();
				}else {
					if (p.hasNextLine()) {
						p.nextLine();
					}
				}
			}
		} catch (FileNotFoundException e1) {
			
		}
		try {
			s = new Scanner (new BufferedReader(new FileReader("ventas.txt")));
			while (s.hasNext()) {
				String pruebaUsuario = s.next();
				if (pruebaUsuario.equals(usuario1)) {
					contadorVenta++;
					System.out.print(contadorVenta + ". " + pruebaUsuario + " ");
					System.out.print(s.next() + " ");
					System.out.print(s.next() + " ");
					System.out.print(s.next());
					System.out.println("");
				}else {
					s.next();
					s.next();
					s.next();
				}
			}
			if (contadorVenta == 0) {
				System.out.println("No tiene ninguna venta realizada");
			}
			
		} catch (FileNotFoundException e) {
		
		}
		return usuario1;
	}
	
	public void cobrarVenta() {
		System.out.println("¿Cual es su cuenta??");
		mostrarViajantes();
		int usuario = teclado.nextInt() - 1;
		String nie = imprimirVentaUsuario(usuario);
		System.out.println("¿Que venta quiere cobrar?");
		int venta = teclado.nextInt();
		String [] cobrar = new String[contarLineas("ventas.txt")];
		Scanner s = null;
		try {
			s = new Scanner (new BufferedReader(new FileReader("ventas.txt")));
	
			while (s.hasNext())
			for (int i = 0; i < contadorVenta; i++) {
				String nieUsuario = s.next();
				if  (nie != nieUsuario) {
					cobrar [i] = nieUsuario + " ";
					cobrar [i] += s.next() + " ";
					cobrar [i] += s.next() + " ";
					cobrar [i] += s.next() + " ";
				}else {
					cobrar [i] = s.next() + " ";
					cobrar [i] += s.next() + " ";
					cobrar [i] += s.next() + " ";
					cobrar [i] += "true";
				}
				
			}
			
		} catch (FileNotFoundException e) {
		
		}
		PrintStream ps = null;
		try {
			ps = new PrintStream(new FileOutputStream("ventas.txt", false));
			ps.print("");
		} catch (FileNotFoundException e) {
			
		}finally {
			ps.close();
		}
		try {
			ps = new PrintStream(new FileOutputStream("ventas.txt", true));
			for (int i = 0; i < cobrar.length; i++) {
				ps.println(cobrar[i]);
			}
		} catch (FileNotFoundException e) {
			
		}finally {
			ps.close();
		}
	}
	
}
