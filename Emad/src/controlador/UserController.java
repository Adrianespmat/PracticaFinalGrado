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
import vista.EnterUser;
import vista.UserView;

public class UserController {
	private UserView userView;
	private IUserModel userModel;

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

	public void login() {
		User newUser = userView.login();
		
		userModel.registerUser(newUser);
	}

}
