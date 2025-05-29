create database Emad;
use Emad;

CREATE TABLE User (
    uuid CHAR(36) PRIMARY KEY,
    nombre VARCHAR(50) UNIQUE NOT NULL,
    contrasena VARCHAR(255) NOT NULL
);

CREATE TABLE Car (
    id INT AUTO_INCREMENT PRIMARY KEY,
    marca VARCHAR(50),
    modelo VARCHAR(50),
    matricula VARCHAR(20),
    año INT
);

CREATE TABLE User_Car (
    uuid_user CHAR(36),
    id_car INT,
    PRIMARY KEY (uuid_user, id_car),
    FOREIGN KEY (uuid_user) REFERENCES User(uuid),
    FOREIGN KEY (id_car) REFERENCES Car(id)
);

CREATE TABLE Spent (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_car INT,
    tipo ENUM('gasolina', 'revisión', 'ITV', 'aceite', 'otros') NOT NULL,
    kilometraje INT NOT NULL,
    fecha DATE NOT NULL,
    importe DECIMAL(10, 2) NOT NULL,
    descripcion TEXT,
    FOREIGN KEY (id_car) REFERENCES Car(id)
);