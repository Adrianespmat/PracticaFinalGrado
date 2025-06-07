package model;

import model.entities.User;

public interface IUserModel {

	void registerUser(User newUser);

	User login(User newUser);

	User byName(String nombre);

}
