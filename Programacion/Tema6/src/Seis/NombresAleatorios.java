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
		"Mar�a", "Bel�n", "Carmen", "Isabel", "Marcos", "Mario", "Samuel", "Sara",
		"Luc�a", "Guillermo", "In�s"};
String [] apellidos = {"Garc�a", "Sancho", "Mart�nez", "Rodr�guez", "P�rez", "Sierra", "Serrano",
		"Sobreviela", "Coma", "Duc", "Mall�n", "Ara"};
private String nombreCompleto;
NombresAleatorios(){
	nombreCompleto = nombres[r.nextInt(17)] + " " + apellidos[r.nextInt(12)]+ " " + apellidos[r.nextInt(12)];
}
public String getNombreCompleto() {
	return nombreCompleto;
}
}
