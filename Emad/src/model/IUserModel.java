package model;

import model.entities.User;

public interface IUserModel {

	void registerUser(User newUser);

	void login(User newUser);

}
