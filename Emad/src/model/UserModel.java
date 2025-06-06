package model;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.entities.User;



public class UserModel implements IUserModel {

	private Connection connection;
	
	public UserModel() throws ClassNotFoundException, SQLException, IOException {
		
		this.connection = DatabaseConexion.getConnection();
	}
	
	public void registerUser(User newUser) {
		
		try {
			String query = "INSERT INTO User (uuid, nombre, contrasena) values (?, ?, ?)";
			PreparedStatement ps1 = connection.prepareStatement(query);
			
			ps1.setString(1, newUser.getUuid().toString());
			ps1.setString(2, newUser.getNombre());
			ps1.setString(3, newUser.getContrasena());
			
			ps1.executeUpdate();
			System.out.println("Usuario registrado con UUID: " + newUser.getUuid());
		} catch (Exception e) {
			System.out.println("Error al registrar usuario: " + e.getMessage());

		}
	}
	public User login(User newUser) {
		
		try  {
			String sql = "SELECT uuid FROM User WHERE nombre = ? AND contrasena = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, newUser.getNombre());
			ps.setString(2, newUser.getContrasena());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				String uuid = rs.getString("uuid");
				System.out.println("Bienvenido, " + newUser.getNombre() + ". Tu UUID es: " + uuid);
				
			} else {
				System.out.println("Credenciales incorrectas.");
			}
		} catch (SQLException e) {
			System.out.println("Error al iniciar sesión: " + e.getMessage());
		}
		return ;
	}
	

}
