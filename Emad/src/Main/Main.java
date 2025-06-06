package Main;

import java.io.IOException;
import java.sql.SQLException;

import vista.MainView;


public class Main {
	public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {
		MainView menu = new MainView();
		menu.menuInicio();
	}
}



         