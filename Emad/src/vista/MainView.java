package vista;

import java.io.IOException;
import java.sql.SQLException;

import controlador.UserController;
import model.entities.User;

public class MainView {
	private UserController userController;
	
	public MainView() throws ClassNotFoundException, SQLException, IOException {
		userController = new UserController();
	}
	
	public void menuInicio() throws SQLException {
		while (true) {
			
			System.out.println("1. registrarse");
			System.out.println("2. Iniciar sesión");
			System.out.println("3. Salir");
			System.out.println("Selecciona una opcion: ");
			
			 
			int opcion = EnterUser.leerEntero();
			switch (opcion) {
			
			case 1: userController.registerUser();
					break;
			case 2: userController.login();
					break;
			case 3: System.exit(0);
					break;
			default: System.out.println("Opcion invalida.");
					break;
			}
		}
	}
}
