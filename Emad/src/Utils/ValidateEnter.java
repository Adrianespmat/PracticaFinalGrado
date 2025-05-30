package Utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ValidateEnter {
	public static boolean validatefecha(String fecha) {
		try {
			new SimpleDateFormat("dd/MM/yyyy").parse(fecha);
			return true;
		}catch (ParseException e) {
			return false;
		}
	}
}
