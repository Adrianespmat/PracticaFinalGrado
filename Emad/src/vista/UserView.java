package vista;

import Utils.HashUtil;
import model.entities.User;

public class UserView {
	public User registerUser() {
		// Imprimir por pantalla pedir nombre
		System.out.println("Nombre: ");
		String nombre = EnterUser.leerTexto();
		
		// Imprimir por pantalla pedir contraseña
		System.out.println("Contraseña: ");
		String contrasena = EnterUser.leerTexto();
		String hash = HashUtil.hashear(contrasena);
		User newUser = new User(nombre, hash);
		return newUser;

	}

	public User login() {
		String nombre = EnterUser.leerTexto();
		String contrasena = EnterUser.leerTexto();
		String hash = HashUtil.hashear(contrasena);
		User newUser = new User(nombre, hash);
		return newUser;
	}
}
