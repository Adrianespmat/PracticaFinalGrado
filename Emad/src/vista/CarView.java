package vista;

import model.entities.Car;

public class CarView {
	public Car createCar() {

		System.out.println("Marca: ");
		String marca = EnterUser.leerTexto();

		System.out.println("Modelo: ");
		String modelo = EnterUser.leerTexto();

		System.out.println("Matricula: ");
		String matricula = EnterUser.leerTexto();

		System.out.println("Año: ");
		int año = EnterUser.leerEntero();

		Car newCar = new Car(marca, modelo, matricula, año);
		return newCar;
	}

	public Car addPropietary() {
		System.out.println("Intruce el ID: ");
		int carId = EnterUser.leerEntero();
		
		System.out.println("Introduce el Uuid: ");
		String newUuid = EnterUser.leerTexto();
		
		return; 
		
		
	}
}
