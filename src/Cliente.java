import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class Cliente {

	private static final String IP = "127.0.0.1"; // Puedes cambiar a localhost
	private static final int PUERTO = 1100; // Si cambias aquí el puerto, recuerda cambiarlo en el servidor

	public static void main(String[] args) throws RemoteException, NotBoundException {

		Registry registry = LocateRegistry.getRegistry(IP, PUERTO);
		Interfaz interfaz = (Interfaz) registry.lookup("Calculadora"); // Buscar en el registro...
		Scanner sc = new Scanner(System.in);

		int eleccion;
		float numero1 = 0;
		float numero2 = 0;
		float resultado = 0;

		List<Float> numeros = new ArrayList<>();

		List<String> opciones = new ArrayList<String>(List.of("Salir", "Sumar", "Restar", "Multiplicar", "Dividir",
				"Potencia", "Raiz Cuadrada", "Factorial", "Media", "Maximo", "Minimo"));

		String menu = "\n\n------------------\n\n";

		for (int i = 0; i < opciones.size(); i++) {
			String entry = "[" + (i - 1) + "] => " + opciones.get(i) + "\n";
			menu += entry;
		}

		do {
			System.out.println(menu);

			try {

				eleccion = Integer.parseInt(sc.nextLine());

			} catch (NumberFormatException e) {

				eleccion = -1;

			}

			if (eleccion != -1) {

				if (5 <= eleccion && eleccion < 7) {
					numeros = pedirNumeros(sc, 1);
					numero1 = numeros.get(0);
				} else if (eleccion < 5) {
					numeros = pedirNumeros(sc, 2);
					numero1 = numeros.get(0);
					numero2 = numeros.get(1);
				} else {

					System.out.println("Cuantos numeros quieres introducir: ");
					int n = Integer.parseInt(sc.nextLine());
					numeros = pedirNumeros(sc, n);
				}

				switch (eleccion) {
					case 0:
						resultado = interfaz.sumar(numero1, numero2);
						break;
					case 1:
						resultado = interfaz.restar(numero1, numero2);
						break;
					case 2:
						resultado = interfaz.multiplicar(numero1, numero2);
						break;
					case 3:
						resultado = interfaz.dividir(numero1, numero2);
						break;
					case 4:
						resultado = interfaz.pow(numero1, (int) numero2);
						break;
					case 5:
						resultado = (float) interfaz.sqrt(numero1);
						break;
					case 6:
						resultado = interfaz.factorial(numero1);
						break;
					case 7:
						resultado = interfaz.media(numeros);
						break;
					case 8:
						resultado = interfaz.maximo(numeros);
						break;
					case 9:
						resultado = interfaz.minimo(numeros);
						break;
				}

				System.out.println("Resultado => " + String.valueOf(resultado));
				System.out.println("Presiona ENTER para continuar");

				sc.nextLine();
			}
		} while (eleccion != -1);

		sc.close();
	}

	private static List<Float> pedirNumeros(Scanner sc, int n) {

		float numero;
		List<Float> numerosRecibidos = new ArrayList<>();

		for (int i = 1; i <= n; i++) {

			System.out.println("Ingresa el número " + i + " :");
			try {
				numero = Float.parseFloat(sc.nextLine());
			} catch (NumberFormatException e) {
				numero = 0;
			}

			numerosRecibidos.add(numero);
		}

		return numerosRecibidos;
	}

}
