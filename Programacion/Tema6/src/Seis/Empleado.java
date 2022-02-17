package Seis;
/**
 * lo utilizo para el ej 6
 * @author ionut
 *
 */
public class Empleado {
	private int numeroId;
	private String nombre;
	private String estadoCivil;
	private String turno;
	private int titulacion;
	private int anosEmpresa;
	
	Empleado() {
		numeroId = 0;
		nombre = "Antonio";
		estadoCivil = " ";
		turno = " ";
		titulacion = '4';
		anosEmpresa = '5';
	}
	
	public int getNumeroId() {
		return numeroId;
	}
	public void setNumeroId(int numeroId) {
		this.numeroId = numeroId;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEstadoCivil() {
		return estadoCivil;
	}
	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	public String getTurno() {
		return turno;
	}
	public void setTurno(String turno) {
		this.turno = turno;
	}
	public int getTitulacion() {
		return titulacion;
	}
	public void setTitulacion(int titulacion) {
		this.titulacion = titulacion;
	}
	public int getAnosEmpresa() {
		return anosEmpresa;
	}
	public void setAnosEmpresa(int anosEmpresa) {
		this.anosEmpresa = anosEmpresa;
	}
}