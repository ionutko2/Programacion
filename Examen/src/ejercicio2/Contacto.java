package ejercicio2;
import java.io.Serializable;
import java.util.ArrayList;

public class Contacto implements  Serializable, Comparable<Contacto>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String nombre;
	ArrayList <Telefono> telefonos = new ArrayList <Telefono>();
	
	public Contacto(String nombre) {
		this.nombre = nombre;
	}

	public int compareTo(Contacto o) {
		return nombre.compareTo(o.nombre);
	}
	
	public boolean comprobarTelefono(String tel) {
		for (int i = 0; i < tel.length(); i++) {
			if (tel.length() == 13) {
				if (i == 0 && tel.charAt(i) == '+') {
					
				}else if (i == 3 && tel.charAt(i) == ' ') {
					
				}else if (tel.charAt(i) >= '0' && tel.charAt(i) <= '9') {
					
				}else {
					return false;
				}
			}else if (tel.length() == 9) {
				if (tel.charAt(i) >= '0' && tel.charAt(i) <= '9') {
					
				}else {
					return false;
				}
			}else {
				return false;
			}
		}
		return true;
	}
	
	public void annadirTelefono(String tel) {
		if (comprobarTelefono(tel)) {
			telefonos.add(new Telefono(tel));
		}else {
			System.out.println("Formato incorrecto");
		}
	}
	
	public void imprimirTelefonos() {
		int contador = 1;
		for (Telefono e: telefonos) {
			System.out.println(contador + ". " + e);
			contador++;
		}
	}
	
	public void eliminarTelefono(int numero) {
		telefonos.remove(numero);
	}
}
