package Seis;
/**
 * Escribe un programa que utilice la clase Empleado, creando un vector de objetos de la clase
Empleado y luego lo llene con datos correspondientes a 50 empleados (utilizar una tabla de
nombres para rellenar con un random). Una vez rellenado, visualizar los datos de todos los
empleados
 */
import java.util.Random;
public class Seis {
	Empleado [] empleado = new Empleado[50];
	
	/**
	 * Método para darle valores a cada objeto de la clase Empleado
	 */
	void rellenarDatos() {
		NombresAleatorios [] aleatorio =  new NombresAleatorios[50];
		Random r = new Random();
		int random = 0;
		for (int i = 0; i < empleado.length; i++) {
			empleado[i] = new Empleado();
			aleatorio[i] = new NombresAleatorios();
			empleado[i].setNombre(aleatorio[i].getNombreCompleto());
			empleado[i].setNumeroId(i + 1);
			empleado[i].setAnosEmpresa(r.nextInt(5) + 1);
			random = r.nextInt(2);
			if (random == 0) {
				empleado[i].setEstadoCivil("solter@");
			}else {
				empleado[i].setEstadoCivil("casad@");
			}
			empleado[i].setTitulacion(r.nextInt(6));
			random = r.nextInt(2);
			if (random == 0) {
				empleado[i].setTurno("Día");
			}else {
				empleado[i].setTurno("Noche");
			}
			
		}
	}
	/**
	 * Método para imprir los datos creados anteriormente
	 */
	void imprimirDatos() {
		for (int i = 0; i < empleado.length; i++) {
			System.out.println(empleado[i].getNumeroId() + " Nombre: " + empleado[i].getNombre() + " ||Estado civil: " + 
					empleado[i].getEstadoCivil() + " ||Turno: " + empleado[i].getTurno() + " ||Años en la empresa: " + 
					empleado[i].getAnosEmpresa() + " ||Titulación: " + empleado[i].getTitulacion());
		}
	}
	public static void main (String [] args) {
		Seis empleado = new Seis();
		empleado.rellenarDatos();
		empleado.imprimirDatos();
	}
}
