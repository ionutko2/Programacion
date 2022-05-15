package Multas;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintStream;
import java.util.*;

public class Menu {
	
	Scanner teclado = new Scanner (System.in);
	List<Vehiculo> vehiculos = new LinkedList<Vehiculo>();
	List<String> vehiculosMultas = new LinkedList<String>();
	Scanner s = null;
	Scanner p = null;
	boolean add = true;
	String archivo;
	
	public Menu (String archivo) {
		this.archivo = archivo;
		try {
			s = new Scanner(
					new BufferedReader(
							new FileReader(this.archivo)));
		} catch (FileNotFoundException e) {
			add = false;
		}
		try {
			p = new Scanner(
					new BufferedReader(
							new FileReader(this.archivo)));
		} catch (FileNotFoundException e) {
			add = false;
		}
		if (s != null && p != null) {
			pasarAColeccion();
		}
		
	}
	
	public void pasarAColeccion() {
	
		while (s.hasNextLine()) {
			//s.useDelimiter(" ");
			
			String matricula = s.next();
			String marca = s.next();
			String modelo = s.next();
			String propietario = s.next();
			String anioMatriculacion = s.next();
			System.out.println(matricula + anioMatriculacion);
			vehiculos.add(new Vehiculo(matricula, marca, modelo, propietario, anioMatriculacion));
			
	
			if(s.hasNextLine()) {
				s.nextLine();
			}
		
		}
		/*
		String fecha = "", motivo = "";
		String importe = "";
		int contador = 0;
		
			
				while(p.hasNextLine()) {
						p.useDelimiter("<multa>");
						p.next();
						p.useDelimiter(" ");
						p.next();
						fecha = p.next();
						motivo = p.next();
						importe = p.next();
						//contador = p.nextInt();
						p.useDelimiter("<multa>");
						System.out.println(fecha + motivo + importe + "si");
						vehiculos.get(contador).ponerMulta(fecha, motivo, importe);
						vehiculos.get(contador).tieneMulta = true;
						System.out.println(contador);	
						p.useDelimiter("<multa>");
				
					
				}
							
			
			if(p.hasNextLine()) {
				p.nextLine();
			}*/
			
				
		
					
	}
		
	public void annadirVehiculo() {
		System.out.println("Matrícula");
		String matricula = teclado.nextLine();
		System.out.println("Marca");
		String marca = teclado.nextLine();
		System.out.println("Modelo");
		String modelo = teclado.nextLine();
		System.out.println("Nombre del propietario");
		String propietario = teclado.nextLine();
		System.out.println("Año de matriculación");
		String anioMatriculacion = teclado.nextLine();
		
		vehiculos.add(new Vehiculo(matricula, marca, modelo, propietario, anioMatriculacion));
		
		if ( s != null )
			s.close();
		s = null;
		PrintStream ps = null;
		// Guarda la información en el archivo
		try {
			ps = new PrintStream(new FileOutputStream(archivo, true));
			ps.println(matricula + " " + marca + " "  + modelo + " "+ propietario + " " + anioMatriculacion);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ps.close();
		}
	
		
		imprimirListaVehiculos();


	
	}
	
	public void imprimirListaVehiculos() {
		/*try {
			s = new Scanner(
					new BufferedReader(
							new FileReader(this.archivo)));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		int contador = 0;
		for (Vehiculo e : vehiculos) {
			contador++;
			System.out.println(contador + ". " + e);
		}

	}
	
	public void eliminarVehiculo() {


		System.out.println("¿Que vehiculo desea eliminar?");
		imprimirListaVehiculos();
		int eliminar = teclado.nextInt() - 1;
		if (!vehiculos.get(eliminar).tieneMulta) {
			vehiculos.remove(eliminar);
		}else {
			System.out.println("No se puede eliminar este vehiculo porque aun tiene multas");
		}
		
		if ( s != null )
			s.close();
		s = null;
		PrintStream ps = null;
		// Elimina toda la información del archivo
		try {
			ps = new PrintStream(new FileOutputStream(archivo, false));
			ps.print("");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ps.close();
		}
		// Guarda la informacion con los cambios en el archivo
		for(Vehiculo v : vehiculos) {
			try {
				ps = new PrintStream(new FileOutputStream(archivo, true));
				ps.println(v.matricula + " " + v.marca + " " + v.modelo + " " + v.propietario + " " + v.anioMatriculacion);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				ps.close();
			}		
		}
		teclado.nextLine();
		

		
	}
	
	void juntarVehiculosMultas() {
		for (Vehiculo v: vehiculos) {
			if  (v.tieneMulta) {
				vehiculosMultas.add(v.matricula + " " + v.marca + " " + v.modelo + " " + v.propietario + " " + v.anioMatriculacion + " " + v.juntarMultas());
			}else {
				vehiculosMultas.add(v.matricula + " " + v.marca + " " + v.modelo + " " + v.propietario + " " + v.anioMatriculacion);
			}
			
		}
	}
	
	public void annadirMulta() {
		System.out.println("¿Que vehículo desea sancionar?");
		imprimirListaVehiculos();
		int sancionar = teclado.nextInt() - 1;
		teclado.nextLine();
		System.out.println("Fecha de la sanción");
		String fecha = teclado.nextLine();
		System.out.println("Motivo");
		String motivo = teclado.nextLine();
		System.out.println("Importe");
		String importe = teclado.nextLine();
		vehiculos.get(sancionar).ponerMulta(fecha, motivo, importe);
		juntarVehiculosMultas();
		
		if ( s != null )
			s.close();
		PrintStream ps = null;
		// Elimina toda la información del archivo
		try {
			ps = new PrintStream(new FileOutputStream(archivo, false));
			ps.print("");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ps.close();
		}
		// Guarda la informacion con los cambios en el archivo
		for(String z : vehiculosMultas) {
			try {
				ps = new PrintStream(new FileOutputStream(archivo, true));
					ps.println(z);
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				ps.close();
			}		
		}
	}
	public void verMultaVehiculo() {
		System.out.println("¿A que vehículo le desea ver las sanciones?");
		imprimirListaVehiculos();
		int vehiculo = teclado.nextInt() - 1;
		vehiculos.get(vehiculo).imprimirMultas();
	}
	public void eliminarMulta() {
		System.out.println("¿A que vehículo le desea eliminar una sanción?");
		imprimirListaVehiculos();
		int vehiculo = teclado.nextInt() - 1;
		vehiculos.get(vehiculo).eliminarMulta();
	}
	/**
	 * Este metodo imprime un listado de los vehiculos que tienen una cuantia del importe de las sanciones mayores al elegido
	 */
	public void imprimirVehiculosSancion() {
		System.out.println("¿Que cuantía quieres elegir?");
		int cantidad = teclado.nextInt();
		List<Vehiculo> vehiculosSancion = new LinkedList<Vehiculo>();
		List<Integer> sumas  = new LinkedList<Integer>();
		int contador = 0;
		int suma = 0;
		for (Vehiculo e : vehiculos) {
			for (Multas o : vehiculos.get(contador).multas) {
				suma = suma + o.importe;
			}
			if (suma >= cantidad) {
				vehiculosSancion.add(e);
				sumas.add(suma);
			}
			contador++;
			suma = 0;
		}
		for (int i = 0 ; i < sumas.size(); i++) {
			System.out.println(vehiculosSancion.get(i) + "el importe es de: " + sumas.get(i));
		}
		
	}
}
