package Tarea_5;

import java.util.Scanner;

public class Principal {

	private static AlmacenDispositivos almacen = new AlmacenDispositivos();

	public static void main(String[] args) {
  
		Scanner sc = new Scanner(System.in);

		int opcion = 0;
		do {

			mostrarMenu();
			opcion = validarEntero(sc);

			try {

				switch (opcion) {
				case 1:
					añadirDispositivo(sc);
					break;
				case 2:
					RegistrarSesion(sc);
					break;
				case 3:
					InformacionDispositivo(sc);
					break;
				case 4:
					listaDeDispositivos(sc);
					break;
				case 5:
					estadisticasGobales(sc);
					break;
				}
			}

			catch (Exception e) {
				System.out.println("Entrada inválida.");
			}

		} while (opcion != 6);
		System.out.println("Adios");
		System.exit(0);
	}

	private static void estadisticasGobales(Scanner sc) {

		System.out.println();
		double media = almacen.mediaGlobalConsumo();
		System.out.println("Media global del consumo: " + media);

		Dispositivo masUsado = almacen.dispositivoMasUsado();
		System.out.println("Dispositivo mas usado: " + masUsado);
	}

	private static void InformacionDispositivo(Scanner sc) {

		System.out.print("Introduce el dispositivo a usar: ");
		String codigo = sc.nextLine();
		Dispositivo d = almacen.buscarPorCodigo(codigo);
		System.out.println();
		System.out.println("----------  Informacion de dispositivo ----------");
		System.out.println(d);
	}

	private static void listaDeDispositivos(Scanner sc) {
		System.out.println();
		System.out.println("----------  Lista de dispositivos ----------");
		almacen.listarDispositivos();

	}

	private static void RegistrarSesion(Scanner sc) {
		// public SesionUso(double horas, double consumo, double temperaturaMax)
		if (!almacen.hayDispositivos()) {
			System.out.println("No hay dispositivos registrados");
			System.out.println();
			return;
		} else {
			System.out.print("Introduce el dispositivo a usar: ");
			String codigo = sc.nextLine();

			Dispositivo d = almacen.buscarPorCodigo(codigo);

			if (d == null) {
				System.out.println("No existe un dispositivo con ese código.\n");
				return;
			}
			System.out.println();
			System.out.print("Horas de uso: ");
			double horas = sc.nextDouble();
			sc.nextLine();

			System.out.print("Consumo (%): ");
		
			double consumo = Math.min(100, sc.nextDouble());
			sc.nextLine();

			System.out.print("Temperatura maxima: ");
			double temperaturaMax = sc.nextDouble();
			sc.nextLine();

			SesionUso sesion = new SesionUso(horas, consumo, temperaturaMax);
			d.registrarSesion(sesion);
			System.out.println("Sesion registrada correctamente.");
			System.out.println();
		}
	}

	private static void mostrarMenu() {
		System.out.println("###################   menu   ######################\n");

		System.out.println("1- Añadir dispositivo");
		System.out.println("2- Registrar sesion dispositivo");
		System.out.println("3- Mostrar informacion de un dispositivo");
		System.out.println("4- Listar todos los dispositivos");
		System.out.println("5- Mostrar estadisticas globales");
		System.out.println("6- Salir\n");
		System.out.println("###################################################\n");
		System.out.print("Elije una opcion: ");
	}

	private static int validarEntero(Scanner sc) {
		while (true) {
			String entrada = sc.nextLine();
			try {
				return Integer.parseInt(entrada);
			} catch (NumberFormatException e) {
				System.out.println("Opcion no valida");
			}
		}
	}

	private static void añadirDispositivo(Scanner sc) {

		System.out.println();
		System.out.print("Introduce codigo: ");
		String codigo = sc.nextLine();

		if (codigo.isEmpty()) {
			System.out.println("no puede estar vacio.");
			return;
		}

		System.out.print("Introduce nombre: ");
		String nombre = sc.nextLine();

		System.out.print("Introduce tipo: ");
		String tipo = sc.nextLine();

		Dispositivo d = new Dispositivo(codigo, nombre, tipo);

		if (almacen.altaDispositivo(d)) { // llama a Dispositivo
			System.out.println();
			System.out.println("Dispositivo agregado al inventario \n");
		} else {
			System.out.println();
			System.out.println("codigo repetido o almacen lleno.");
		}
	}

}

