package model.entities;

import java.util.UUID;

public class User {
	private UUID uuid;
	private String nombre;
	private String contrasena;
	
	public User (String nombre, String contrasena) {
		this.uuid = UUID.randomUUID();
		this.nombre = nombre;
		this.contrasena = contrasena;
	}
	
	public UUID getUuid() {
		return uuid;
	}
	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
}
