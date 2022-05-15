package Multas;

import java.util.*;

public class Programa {

	public static void main(String[] args) {
		boolean seguir = true;
		Menu menu = new Menu("vehiculos.txt");
		Scanner teclado = new Scanner(System.in);
		
		while (seguir) {
			int opcion;
			System.out.println("¿Que desea realizar?\n"
					+ "\t 1.Añadir vehículo\n"
					+ "\t 2.Eliminar vehiculo\n"
					+ "\t 3.Añadir sanción\n"
					+ "\t 4.Consultar sanciones\n"
					+ "\t 5.Eliminar sanciones\n"
					+ "\t 6.Mostrar los vehículos que superan la cuantía estimada en el importe de las multas\n"
					+ "\t 7.Terminar");
			opcion = teclado.nextInt();
			
			switch (opcion) {
			case 1:
				menu.annadirVehiculo();
				break;
			case 2:
				menu.eliminarVehiculo();
				break;
			case 3:
				menu.annadirMulta();
				break;
			case 4:
				menu.verMultaVehiculo();
				break;
			case 5:
				menu.eliminarMulta();
				break;
			case 6:
				menu.imprimirVehiculosSancion();
				break;
			case  7:
				seguir = false;
			}
		}
	}

}
