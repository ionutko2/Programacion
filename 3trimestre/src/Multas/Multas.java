package Multas;

public class Multas {
	public String fecha;
	String motivo;
	String importe;
	
	public Multas(String fecha, String motivo, String importe) {
		this.fecha = fecha;
		this.motivo = motivo;
		this.importe = importe;
	}
	public String toString() {
		return "Fecha: " + fecha + " Motivo: " + motivo + " Importe: " + importe;
	}
}
