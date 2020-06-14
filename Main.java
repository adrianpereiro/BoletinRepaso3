import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		int opcion = 0;
		Scanner sc = new Scanner(System.in);
		ArrayList<Cliente> adolescente = new ArrayList<>();
		ArrayList<Cliente> joven = new ArrayList<>();
		ArrayList<Cliente> adulto = new ArrayList<>();
		HashMap<String, Cliente> listaClientes = new HashMap<String, Cliente>();

		while (opcion != 4) {
			opcion = escogerOpcion();
			switch (opcion) {
			case 1:
				int dia = 0;
				do {
					System.out.println("Introduce la fecha de nacimiento\nDia:");
					try {
						dia = sc.nextInt();
					} catch (InputMismatchException ex) {
						System.out.println("Debe ser un numero entre 1 y 31\n");
						sc.nextLine();
					}
					if (dia == 0 || dia < 0 || dia > 31) {
						System.out.println("Debe ser entre 1 y 31\n");
					}
				} while (dia == 0 || dia < 0 || dia > 31);

				int mes = 0;
				do {
					System.out.println("\nMes:");
					try {
						mes = sc.nextInt();
					} catch (InputMismatchException ex) {
						System.out.println("Debe ser un numero entre 1 y 12\n");
						sc.nextLine();
					}
					if (mes == 0 || mes < 1 || mes > 12) {
						System.out.println("Debe ser entre 1 y 12\n");
					}
				} while (mes == 0 || mes < 1 || mes > 12);

				int año = 0;
				while (año == 0) {
					System.out.println("\nAño:");
					try {
						año = sc.nextInt();
					} catch (InputMismatchException ex) {
						System.out.println("Debe ser un numero entero\n");
						sc.nextLine();
					}
				}

				float edad = Cliente.devolverEdad(dia, mes, año);

				if (edad < 16) {
					System.out.println("No es posible la entrada, solo mayores de 16.\n");
					break;
				} else {
					System.out.println("Introduce los datos del cliente\nNombre: ");
					String nombre = sc.next();

					System.out.println("Apellidos: ");
					String apellidos = sc.next();

					String nombreCliente = nombre + " " + apellidos;

					System.out.println("DNI: ");
					String DNI = sc.next();

					LocalDate fechaNacimiento = LocalDate.of(año, mes, dia);

					Cliente nuevoCliente = new Cliente(nombreCliente, DNI, fechaNacimiento, edad);

					if (edad >= 16 && edad <= 18) {
						adolescente.add(nuevoCliente);
						listaClientes.put(DNI, nuevoCliente);
					}

					if (edad > 18 && edad < 30) {
						joven.add(nuevoCliente);
						listaClientes.put(DNI, nuevoCliente);
					}

					if (edad >= 30) {
						adulto.add(nuevoCliente);
						listaClientes.put(DNI, nuevoCliente);
					}
				}
				break;
			case 2:
				mostrarClienteDNI(listaClientes);
				break;

			case 3:

				System.out.println("Lista adolescentes ordenados por edad: ");
				mostrarArrayListOrdenado(adolescente);
				System.out.println("Lista jovenes ordenados por edad: ");
				mostrarArrayListOrdenado(joven);
				System.out.println("Lista adultos ordenados por edad: ");
				mostrarArrayListOrdenado(adulto);
				break;

			case 4:
				System.out.println("Hasta otra.");
				break;

			default:
				
				System.out.println("No existe esa opcion, debe ser un numero entre 1 y 4");
				break;
			}
		}
	}
	
	
	public static int escogerOpcion() {
		Scanner sc = new Scanner(System.in);
		int opcion = 0;
		while (opcion == 0) {
			System.out.println(
					"Que accion desea realizar:\n 1-Entrada\n 2-Ver datos de un cliente\n 3-Mostrar datos de todos los clientes\n 4-Salir");
			try {
				opcion = sc.nextInt();
			} catch (InputMismatchException ex) {
				System.out.println("No existe esa opcion, debe ser un numero entre 1 y 4\n");
				sc.nextLine();
			}
		}
		return opcion;
	}
	
	public static void mostrarClienteDNI(HashMap<String, Cliente> listaClientes) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Cual es el DNI del cliente? ");
		String dniCliente = sc.next();
		if (listaClientes.containsKey(dniCliente)) {
			System.out.println(listaClientes.get(dniCliente));
		} else {
			System.out.println("No existe un cliente con ese DNI\n");
		}
	}

	public static void mostrarArrayListOrdenado(ArrayList<Cliente> arrayCliente) {
		if (arrayCliente == null || arrayCliente.size() == 0) {
			System.out.println("No hay datos en esta lista");
		} else {
			Collections.sort(arrayCliente, (p1, p2) -> p1.getFechaNacimiento().compareTo(p2.getFechaNacimiento()));
			for (Cliente cli : arrayCliente) {
				cli.mostrarDatos();
			}
		}
	}
}
