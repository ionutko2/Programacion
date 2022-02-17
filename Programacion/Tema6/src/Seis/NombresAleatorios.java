package Seis;
import java.util.Random;
/**
 * lo utilizo para el ejercicio 6
 * @author ionut
 *
 */
public class NombresAleatorios {
Random r = new Random();
String [] nombres = {"Andrea", "Antonio", "Federico", "Javier", "Miguel", "Marta", 
		"María", "Belén", "Carmen", "Isabel", "Marcos", "Mario", "Samuel", "Sara",
		"Lucía", "Guillermo", "Inés"};
String [] apellidos = {"García", "Sancho", "Martínez", "Rodríguez", "Pérez", "Sierra", "Serrano",
		"Sobreviela", "Coma", "Duc", "Mallén", "Ara"};
private String nombreCompleto;
NombresAleatorios(){
	nombreCompleto = nombres[r.nextInt(17)] + " " + apellidos[r.nextInt(12)]+ " " + apellidos[r.nextInt(12)];
}
public String getNombreCompleto() {
	return nombreCompleto;
}
}
