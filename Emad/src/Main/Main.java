package Main;

import java.sql.SQLException;

import vista.MainView;


public class Main {
	public static void main(String[] args) throws SQLException {
		MainView menu = new MainView();
		menu.menuInicio();
	}
}
