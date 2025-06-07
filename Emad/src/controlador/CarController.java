package controlador;

import java.sql.Statement;

import model.CarModel;
import model.ICarModel;
import model.IUserModel;
import model.UserModel;
import model.entities.Car;
import model.entities.User;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import vista.CarView;
import vista.EnterUser;
import vista.UserView;

public class CarController {

	private CarView carView;
	private ICarModel carModel;
	private String uuid;

	public CarController(String uuid) throws ClassNotFoundException, SQLException, IOException {
		carView = new CarView();
		this.carModel = new CarModel();
		this.uuid = uuid;
	}

	public void createCar(User currentUser) {

		Car newCar = carView.createCar();
		carModel.createCar(newCar, currentUser);
	}

	public void listCar(String uuidUser) throws SQLException {
		try (Connection conn = null) {
			String sql = "SELECT c.id, c.marca, c.modelo, c.matricula, c.año FROM car c JOIN propietarios p ON c.id = p.car_id HWERE p.uuid_user = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, uuidUser);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				System.out.printf("ID: %d, %s %s (%s, %d)%n", rs.getInt("id"), rs.getString("marca"),
						rs.getString("modelo"), rs.getString("matricula"), rs.getInt("año"));
			}
		} catch (SQLException e) {
			System.out.println("Error al listar coches: " + e.getMessage());
		}
	}

	public void addPropietary(Car newCar) {
		Car CarView = carView.addPropietary();
	    carModel.addPropietary(CarId, Uuid);
	}
}
