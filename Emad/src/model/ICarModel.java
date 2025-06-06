package model;

import model.entities.Car;
import model.entities.User;

public interface ICarModel {
	
	void createCar(Car newCar, User currentUser);
}
