package Ejercicios_ArrayList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Agenda {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		ArrayList<Familia> familiares = new ArrayList<>();
		HashMap<String,Integer> agenda = new HashMap<>();
		
		int opcion=0;
		
		do {
			mostrarMenu();
			System.out.print("elije una opcion:");
			opcion = sc.nextInt();sc.nextLine();
			
			switch (opcion) {
			case 1: añadirNombre(sc,agenda,familiares);break;
			case 2: System.out.println("Nombres de la lista: ");
			mostrarNombres(agenda,familiares);break;
			case 3:buscarNombre(sc, agenda, familiares);break;
			case 4:despedida();
			}
			
		}while (opcion != 4);
		sc.close();
	}

	private static void despedida() {
		System.out.println("saliendo del programa, hasta la proxina, adios ! ...");
		System.exit(0);
		
	}

	private static void buscarNombre(Scanner sc, HashMap<String,Integer> agenda,ArrayList <Familia> familiares) {
		System.out.println("Nombre a buscar?: ");
		String resultado=sc.nextLine();
		boolean encontrado=false;
		for (String nombre: agenda.keySet()) {
			if (nombre.contains(resultado)) {
				encontrado=true;
				int edad=agenda.get(nombre);
				
			Familia familiar = new Familia(resultado,edad);
			familiares.add(familiar);
				System.out.println(nombre+ ", edad: "+ agenda.get(nombre));
			}	
		}
		if (encontrado) {
			System.out.println("¡¡ encontrado !!");
			
		}else
			System.out.println("Nombre no encontrado");
		
		
	}

	private static void mostrarNombres(HashMap<String,Integer> agenda, ArrayList<Familia> familiares) {
		
		for (String nombre : agenda.keySet()) {
			
			System.out.println(nombre+ agenda.get(nombre));//get(nombre) muestra la edad
		}
		System.out.println("Listado de familiares: ");
		for (Familia familiar: familiares) {
				
			System.out.println(familiar);
		
		
		}
		
	}

	private static void añadirNombre(Scanner sc,HashMap<String,Integer> agenda, ArrayList<Familia>familiar  ) {
		System.out.print("Dame el nombre a añadir: ");
		String nombre = sc.nextLine();
		System.out.print("edad: ");
		int edad =sc.nextInt(); sc.nextLine();
		agenda.put(nombre, edad);
		System.out.println(nombre+": con  "+edad+"años," + " ha sido añadido.");
		Familia nuevoFamiliar=new Familia(nombre,edad);
		familiar.add(nuevoFamiliar);
	}

	private static void mostrarMenu() {

		System.out.println("----- menu -----");
		System.out.println("1- añadir nombre");
		System.out.println("2- mostrar nombres");
		System.out.println("3- buscar nombre");
		System.out.println("4- salir");
		
		
	}

}
