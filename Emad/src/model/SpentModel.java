package model;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class SpentModel implements ISpentModel {
	
	private Connection connection;
	
	
public SpentModel() throws ClassNotFoundException, SQLException, IOException {
		
		this.connection = DatabaseConexion.getConnection();
	}
}
