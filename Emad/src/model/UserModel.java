package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.entities.User;

public class UserModel {
	public void registerUser(User newUser) {
		
		try (Connection conn = ConexionBD.obtenerConexion()) {
			String sql = "INSERT INTO user (uuid, nombre, contrasena) VALUES (?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, newUser.getUuid().toString());
			ps.setString(2, newUser.getNombre());
			ps.setString(3, newUser.getContrasena());
			ps.executeUpdate();
			System.out.println("Usuario registrado con UUID: " + newUser.getUuid());
		} catch (SQLException e) {
			System.out.println("Error al registrar usuario: " + e.getMessage());
		}
	}
	
	
}
