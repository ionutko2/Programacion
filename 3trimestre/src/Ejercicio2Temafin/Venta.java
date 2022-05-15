package Ejercicio2Temafin;

public class Venta {
	private String fecha, importe, cliente;
	private boolean cobrada = false;
	
	public Venta(String cliente, String importe, String fecha) {
		this.fecha = fecha;
		this.cliente = cliente;
		this.importe = importe;
 	}
	
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getImporte() {
		return importe;
	}
	public void setImporte(String importe) {
		this.importe = importe;
	}
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	public boolean isCobrada() {
		return cobrada;
	}
	public void setCobrada(boolean cobrada) {
		this.cobrada = cobrada;
	}
	
	public String toString() {
		return cliente + " " + fecha + " " +  importe + " " + cobrada;
	}
	
}
