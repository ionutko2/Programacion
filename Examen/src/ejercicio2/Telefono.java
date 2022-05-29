package ejercicio2;
import java.io.Serializable;
import java.util.Scanner;

public class Telefono implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String tipo;
	String numero;
	
	public Telefono(String numero) {
		this.numero = numero;
		imprimirMenu();
	}
	
	public void imprimirMenu() {
		Scanner teclado = new Scanner(System.in);
		boolean bien = true;
		do {
			System.out.println("Que tipo de teléfono es?"
					+ "\n\t 1. Personal."
					+ "\n\t 2. Empresa."
					+ "\n\t 3. Fax."
					+ "\n\t 4. Fijo.");
			String opcion = teclado.nextLine();
			switch (opcion) {
			case ("1"):
				tipo = "Personal";
				break;
			case ("2"):
				tipo = "Empresa";
				break;
			case ("3"):
				tipo = "Fax";
				break;
			case ("4"):
				tipo = "Fijo";
				break;
			default:
				System.out.println("Opción no contemplada");
				bien = false;
			}
		}while(!bien);
		
	}
	public String toString() {
		return tipo + ": " + numero;
	}
}
