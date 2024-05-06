package Floristeria.cliente;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Input {
	
	// Instancia de Scanner para leer la entrada del usuario
	private static final Scanner input = new Scanner(System.in);
	
	// Mensajes de error constantes para cada tipo de entrada esperada
	private static final String INT_FORMAT_ERR_MSG = "Hay un error de formato en tu respuesta. Ingresa un entero.";
	private static final String DOUBLE_FORMAT_ERR_MSG = "Hay un error de formato en tu respuesta. Ingresa un double.";
	private static final String FLOAT_FORMAT_ERR_MSG = "Hay un error de formato en tu respuesta. Ingresa un float.";
	private static final String EMPTY_STRING_ERR_MSG = "Tu respuesta no debe estar vacía.";
	private static final String YES_NO_ERR_MSG = "Hay un error en tu respuesta. Ingresa S o N para sí o no.";
	private static final String BYTE_FORMAT_ERR_MSG = "Hay un error de formato en tu respuesta. Ingresa un byte.";
	//private static final String ENUM_FORMAT_ERR_MSG = "Hay un error de formato en tu respuesta. Ingresa 'madera' o 'plastico'.";
	
	// Método para solicitar al usuario un byte, repite la solicitud hasta recibir una entrada válida
	public static byte inputByte(String pregunta) {
		byte response = 0;
		boolean okey = false;
		do {
			System.out.println(pregunta);
			try {
				response = input.nextByte();
				okey = true;
			} catch (InputMismatchException ex) {
				System.err.println(BYTE_FORMAT_ERR_MSG);
			}
			input.nextLine(); // Limpia el buffer de entrada
		} while (!okey);
		return response;
	}
	
	// Método para solicitar al usuario un entero, repite la solicitud hasta recibir una entrada válida
	public static int inputInt(String pregunta) {
		int response = 0;
		boolean okey = false;
		do {
			System.out.println(pregunta);
			try {
				response = input.nextInt();
				okey = true;
			} catch (InputMismatchException ex) {
				System.err.println(INT_FORMAT_ERR_MSG);
			}
			input.nextLine();
		} while (!okey);
		return response;
	}
	
	// Método para solicitar al usuario una cadena de texto, repite la solicitud hasta recibir una entrada no vacía
	public static String inputString(String pregunta) {
		String response = "";
		boolean okey = false;
		do {
			System.out.println(pregunta);
			try {
				response = input.nextLine();
				if (response.isEmpty()) {
					throw new Exception(EMPTY_STRING_ERR_MSG);
				} else {
					okey = true;
				}
			} catch (Exception ex) {
				System.err.println(ex.getMessage());
			}
		} while (!okey);
		return response;
	}
	
	// Método para solicitar al usuario un double, repite la solicitud hasta recibir una entrada válida
	public static double inputDouble(String pregunta) {
		double response = 0.0;
		boolean okey = false;
		do {
			System.out.println(pregunta);
			try {
				response = input.nextDouble();
				okey = true;
			} catch (InputMismatchException ex) {
				System.err.println(DOUBLE_FORMAT_ERR_MSG);
			}
			input.nextLine();
		} while (!okey);
		return response;
	}
	
	// Método para solicitar al usuario un float, repite la solicitud hasta recibir una entrada válida
	public static float inputFloat(String pregunta) {
		float response = 0.0F;
		boolean okey = false;
		do {
			System.out.println(pregunta);
			try {
				response = input.nextFloat();
				okey = true;
			} catch (InputMismatchException ex) {
				System.err.println(FLOAT_FORMAT_ERR_MSG);
			}
			input.nextLine();
		} while (!okey);
		return response;
	}
	
	// Método para solicitar al usuario una respuesta de sí o no, interpretando 'S' como true y 'N' como false
	public static boolean inputSiNo(String pregunta) {
		boolean booleanResponse = false;
		boolean okey = false;
		String userResponse = "";

		do {
			System.out.println(pregunta);
			try {
				userResponse = input.nextLine().toUpperCase();
				if (userResponse.charAt(0) == 'S') {
					booleanResponse = true;
					okey = true;
				} else if (userResponse.charAt(0) == 'N') {
					booleanResponse = false;
					okey = true;
				} else {
					throw new Exception(YES_NO_ERR_MSG);
				}
			} catch (Exception ex) {
				System.err.println(ex.getMessage());
			}
		} while (!okey);
		return booleanResponse;
	}
/* 
	// Método para solicitar al usuario una entrada que debe corresponder a un valor de un Enum específico
	public static Material inputEnum(String pregunta) {
		Material response = null;
		boolean okey = false;
		String userResponse = "";

		do {
			System.out.println(pregunta);
			try {
				userResponse = input.nextLine();
				if (userResponse.isEmpty()) {
					throw new IllegalArgumentException(ENUM_FORMAT_ERR_MSG);
				} else {
					response = Material.valueOf(userResponse.toUpperCase());
					okey = true;
				}
			} catch (IllegalArgumentException ex) {
				System.err.println(ENUM_FORMAT_ERR_MSG);
			} catch (Exception ex) {
				System.err.println(ENUM_FORMAT_ERR_MSG);
			}
		} while (!okey);

		return response;
	}
    */
}

