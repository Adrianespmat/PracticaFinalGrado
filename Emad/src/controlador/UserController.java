package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import Utils.HashUtil;
import model.ConexionBD;
import model.UserModel;
import model.entities.User;
import vista.EnterUser;
import vista.UserView;

public class UserController {
	private UserView userView;
	private UserModel userModel;

	public UserController() {
		userView = new UserView();
		userModel = new UserModel();
	}

	public void registerUser() throws SQLException {
		// necesitamos userView nos pase la informacion de User
		User newUser = userView.registerUser();
		// necesitamos que UserModel guarde la informacion que hemos recibido
		userModel.registerUser(newUser);
	}

	public boolean login() {
		User newUser = userView.login();

		try (Connection conn = ConexionBD.obtenerConexion()) {
			String sql = "SELECT uuid FROM user WHERE nombre = ? AND contrasena = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, newUser.getNombre());
			ps.setString(2, newUser.getContrasena());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				String uuid = rs.getString("uuid");
				System.out.println("Bienvenido, " + newUser.getNombre() + ". Tu UUID es: " + uuid);
				return true;
			} else {
				System.out.println("Credenciales incorrectas.");
			}
		} catch (SQLException e) {
			System.out.println("Error al iniciar sesión: " + e.getMessage());
		}

		return false;
	}

}
