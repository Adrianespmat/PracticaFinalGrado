package model.entities;

import java.util.ArrayList;
import java.util.List;

public class Car {
	private int id;
	private String marca;
	private String modelo;
	private String matricula;
	private int año;
	private List<String> propietarios;
	
	public Car(String marca, String modelo, String matricula, int año) {
		this.marca = marca;
		this.modelo = modelo;
		this.matricula = matricula;
		this.año = año;
		this.propietarios = new ArrayList<>();
		
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public int getAño() {
		return año;
	}
	public void setAño(int año) {
		this.año = año;
	}
	
}
