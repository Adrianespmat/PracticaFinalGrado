package controlador;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.ConexionBD;
import vista.EnterUser;

public class CarController {
	public void createCar(String uuidUser) {
		String marca = EnterUser.leerTexto();
        String modelo = EnterUser.leerTexto();
        String matricula = EnterUser.leerTexto();
        int año = EnterUser.leerEntero();
        
        try (Connection conn = ConexionBD.obtenerConexion()) {
            String sql = "INSERT INTO Car (marca, modelo, matricula, año) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, marca);
            ps.setString(2, modelo);
            ps.setString(3, matricula);
            ps.setInt(4, año);
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int carId = rs.getInt(1);
              
                PreparedStatement psProp = conn.prepareStatement("INSERT INTO propietarios (coche_id, uuid_usuario) VALUES (?, ?)");
                psProp.setInt(1, carId);
                psProp.setString(2, uuidUser);
                psProp.executeUpdate();
                System.out.println("Coche creado correctamente.");
            }
        } catch (SQLException e) {
            System.out.println("Error al crear coche: " + e.getMessage());
        }
	}
	
	public void listCar(String uuidUser) throws SQLException {
		try ( Connection conn = ConexionBD.obtenerConexion()) {
			String sql = "SELECT c.id, c.marca, c.modelo, c.matricula, c.año FROM car c JOIN propietarios p ON c.id = p.car_id HWERE p.uuid_user = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, uuidUser);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	System.out.printf ("ID: %d, %s %s (%s, %d)%n",
                        rs.getInt("id"),
                        rs.getString("marca"),
                        rs.getString("modelo"),
                        rs.getString("matricula"),
                        rs.getInt("año"));
            }
		}catch (SQLException e) {
			System.out.println("Error al listar coches: " + e.getMessage());
		}
	}
	
	public void addPropietary() {
		 int carId = EnterUser.leerEntero();
	        String newUuid = EnterUser.leerTexto();

	        try (Connection conn = ConexionBD.obtenerConexion()) {
	            String sql = "INSERT INTO propietarios (car_id, uuid_user) VALUES (?, ?)";
	            PreparedStatement ps = conn.prepareStatement(sql);
	            ps.setInt(1, carId);
	            ps.setString(2, newUuid);
	            ps.executeUpdate();
	            System.out.println("Nuevo propietario añadido correctamente.");
	        } catch (SQLException e) {
	            System.out.println("Error al añadir propietario: " + e.getMessage());
	        }
	}
}
