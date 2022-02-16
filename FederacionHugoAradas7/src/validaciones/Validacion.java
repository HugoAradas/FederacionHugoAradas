package validaciones;

import com.aeat.valida.Validador;

import entidades.NIF;

public class Validacion {
	
	public static boolean validarNombre(String nombre) {
		int tamanonombre = nombre.length();
		if (tamanonombre >= 2 & tamanonombre <= 20) {
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean validarTelefono(String telefono) {
		int tamanotelefono = telefono.length();
		if (tamanotelefono == 9) {
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean validarNIF(String nif) {
		boolean ret = false;
		if (nif.length() != 9)
			ret = false;
		if (!Character.isLetter(nif.charAt(nif.length() - 1)))
			ret = false;
		// Usamos validador de AEAT --> valnif.jar
		Validador val = new Validador();
		ret = (val.checkNif(nif) > 0 ? true : false);
		return ret;
	}
	
	public static boolean validarNIE(String nie) {
		boolean esValido = false;
		int i = 1;
		int caracterASCII = 0;
		char letra = ' ';
		int miNIE = 0;
		int resto = 0;
		char[] asignacionLetra = { 'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q',
				'V', 'H', 'L', 'C', 'K', 'E' };

		if (nie.length() == 9 && Character.isLetter(nie.charAt(8)) && nie.substring(0, 1).toUpperCase().equals("X")
				|| nie.substring(0, 1).toUpperCase().equals("Y") || nie.substring(0, 1).toUpperCase().equals("Z")) {

			do {
				caracterASCII = nie.codePointAt(i);
				esValido = (caracterASCII > 47 && caracterASCII < 58);
				i++;
			} while (i < nie.length() - 1 && esValido);
		}

		if (esValido && nie.substring(0, 1).toUpperCase().equals("X")) {
			nie = "0" + nie.substring(1, 9);
		} else if (esValido && nie.substring(0, 1).toUpperCase().equals("Y")) {
			nie = "1" + nie.substring(1, 9);
		} else if (esValido && nie.substring(0, 1).toUpperCase().equals("Z")) {
			nie = "2" + nie.substring(1, 9);
		}

		if (esValido) {
			letra = Character.toUpperCase(nie.charAt(8));
			miNIE = Integer.parseInt(nie.substring(0, 8));
			resto = miNIE % 23;
			esValido = (letra == asignacionLetra[resto]);
		}

		return esValido;
	}
}
