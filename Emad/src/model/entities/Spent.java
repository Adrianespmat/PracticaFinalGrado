package model.entities;

import java.sql.Date;

public class Spent {
	private int id;
	private int cocheId;
	private String tipo;
	private int kilometraje;
	private Date fecha;
	private double importe;
	private String descripcion;
	
	public Spent(int cocheId, String tipo, int kilometraje, Date fecha, double importe, String descripcion) {
	       this.cocheId = cocheId;
	       this.tipo = tipo;
	       this.kilometraje = kilometraje;
	       this.fecha = fecha;
	       this.importe = importe;
	       this.descripcion = descripcion;
	    }
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCocheId() {
		return cocheId;
	}
	public void setCocheId(int cocheId) {
		this.cocheId = cocheId;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public int getKilometraje() {
		return kilometraje;
	}
	public void setKilometraje(int kilometraje) {
		this.kilometraje = kilometraje;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public double getImporte() {
		return importe;
	}
	public void setImporte(double importe) {
		this.importe = importe;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
}
