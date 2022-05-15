package Multas;


import java.util.*;

/**
 * Clase encargada de realizar operaciones de manera aleatoria.
 * @author Ionut
 *
 */

public class Aleatorio {
	
	Random aleatorio = new Random();
	
	/**
	 * Metodo para crear una matricula de manera aleatoria
	 * @return matricula creada
	 */
	public String crearMatricula() {
		String matricula = "";
		String consonantes = "BCDFGHJKLMNPRSTVWXYZ";
		
		for (int i = 0; i < 4; i++) {
			matricula = matricula + aleatorio.nextInt(10);
		}
		for (int i = 0; i < 3; i++) {
			matricula = matricula + consonantes.charAt(aleatorio.nextInt(20));
		}
		return matricula;
	}
	/**
	 * Metodo para darle una marca aleatoria.
	 * @return marca elegida
	 */
	public String elegirMarca() {
		List<String> marcas = new LinkedList<String>();
		marcas.add("Ford");
		marcas.add("Renault");
		marcas.add("Citroen");
		marcas.add("Mercedes");
		marcas.add("BMW");
		marcas.add("Audi");
		String marca;
		
		marca = marcas.get(aleatorio.nextInt(6));
		
		return marca;
	}
	
	public String elegirModelo(String marca) {
		String modelo;
		if(marca == "Ford") {
			List<String> ford = new LinkedList<String>();
			ford.add("Mondeo");
			ford.add("Fiesta");
			ford.add("Focus");
			ford.add("Mustang");
			modelo = ford.get(aleatorio.nextInt(4));
		}else if (marca == "Renault") {
			List<String> renault = new LinkedList<String>();
			renault.add("Arkana");
			renault.add("Clio");
			renault.add("Austral");
			renault.add("Megane");
			modelo = renault.get(aleatorio.nextInt(4));
		}else if (marca == "Citroen") {
			List<String> citroen = new LinkedList<String>();
			citroen.add("C1");
			citroen.add("C2");
			citroen.add("C3");
			citroen.add("C4");
			modelo = citroen.get(aleatorio.nextInt(4));
		}else if (marca == "Mercedes") {
			List<String> mercedes = new LinkedList<String>();
			mercedes.add("Vito");
			mercedes.add("Cla");
			mercedes.add("Glz");
			mercedes.add("Gla");
			modelo = mercedes.get(aleatorio.nextInt(4));
		}else if (marca == "BMW") {
			List<String> bmw = new LinkedList<String>();
			bmw.add("i4");
			bmw.add("i5");
			bmw.add("i6");
			bmw.add("i7");
			modelo = bmw.get(aleatorio.nextInt(4));
		}else {
			List<String> audi = new LinkedList<String>();
			audi.add("q5");
			audi.add("q6");
			audi.add("q7");
			audi.add("q8");
			modelo = audi.get(aleatorio.nextInt(4));
		}
		return modelo;
	}
	
	
}
