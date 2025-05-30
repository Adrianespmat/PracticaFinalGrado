package vista;

import java.util.Scanner;

public class EnterUser {
	private static final Scanner scanner = new Scanner(System.in);
	
	public static String leerTexto() {
		return scanner.nextLine();
	}
	
	public static int leerEntero() {
		return Integer.parseInt(scanner.nextLine());
	}
	
	public static double leerDouble() {
		return Double.parseDouble(scanner.nextLine());
	}
}
