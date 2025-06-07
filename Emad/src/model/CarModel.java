package model;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.entities.Car;
import model.entities.User;

public class CarModel implements ICarModel {
	
	private Connection connection;
	
public CarModel() throws ClassNotFoundException, SQLException, IOException {
		
		this.connection = DatabaseConexion.getConnection();
	}

public void createCar(Car newCar, User currentUser) {
	try {
        String sql = "INSERT INTO Car (marca, modelo, matricula, año) VALUES (?, ?, ?, ?)";
        PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, newCar.getMarca());
        ps.setString(2, newCar.getModelo());
        ps.setString(3, newCar.getMatricula());
        ps.setInt(4, newCar.getAño());
        ps.executeUpdate();

        ResultSet rs = ps.getGeneratedKeys();
        if (rs.next()) {
            int carId = rs.getInt(1);
          
            PreparedStatement psProp = connection.prepareStatement("INSERT INTO propietarios (coche_id, uuid_usuario) VALUES (?, ?)");
            psProp.setInt(1, carId);
            psProp.setString(2, currentUser.getUuid().toString());
            psProp.executeUpdate();
            System.out.println("Coche creado correctamente.");
        }
    } catch (SQLException e) {
        System.out.println("Error al crear coche: " + e.getMessage());
    }
}

public void addPropietary(int carId, String Uuid) {
	
	 try {
         String sql = "INSERT INTO propietarios (car_id, uuid_user) VALUES (?, ?)";
         PreparedStatement ps = connection.prepareStatement(sql);
         ps.setInt(1, carId);
         ps.setString(2, Uuid);
         ps.executeUpdate();
         System.out.println("Nuevo propietario añadido correctamente.");
     } catch (SQLException e) {
         System.out.println("Error al añadir propietario: " + e.getMessage());
     }
}

}
