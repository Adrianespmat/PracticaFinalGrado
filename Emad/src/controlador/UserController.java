package controlador;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import Utils.HashUtil;

import model.IUserModel;
import model.UserModel;
import model.entities.User;
import p09.model.dtos.UserLoginDto;
import vista.EnterUser;
import vista.UserView;

public class UserController {
	private UserView userView;
	private IUserModel userModel;
	private Object passwordEncryptor;

	public UserController() throws ClassNotFoundException, SQLException, IOException {
		userView = new UserView();
		this.userModel = new UserModel();
	}

	public void registerUser() throws SQLException {
		// necesitamos userView nos pase la informacion de User
		User newUser = userView.registerUser();
		// necesitamos que UserModel guarde la informacion que hemos recibido
		userModel.registerUser(newUser);
	}

	public boolean login() {
		
		User newUser = userView.login();

		userModel.login(newUser);

		User userDb = this.userModel.byName(userDb.getNombre());

		if (userDb == null) {
			return false;
		}
		// Hashear la contraseña ingresada
		String hashedInpuntPassword = HashUtil.hashear(newUser.getContrasena());
		
		// Comparar el hash de la contraseña ingresada con el hash almacenado
		boolean result = hashedInputPassword.equals(userDb.getContrasena());
		return result;
	}

}
