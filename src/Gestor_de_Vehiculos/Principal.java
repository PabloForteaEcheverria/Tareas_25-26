package Gestor_de_Vehiculos;

import java.util.ArrayList;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args){
	Scanner sc = new Scanner(System.in);
	ArrayList <Vehiculo> parqueMovil = new ArrayList<>();
	
	
	int opcion=0;
		do{
		
		mostrarMenu(sc);
		System.out.println("elije una opcion: ");
		opcion=sc.nextInt();sc.nextLine();
		
		switch (opcion) {
		
		case 1: añadirVehiculo(sc, parqueMovil);break;
		case 2: mostrarVehiculos(parqueMovil);break;
		case 3: buscarVehiculo(sc, parqueMovil);break;
		case 4: buscarVehiculoPorMarca(sc, parqueMovil);break;
		case 5: eliminarVehiculo(sc, parqueMovil);break;
		case 6: System.out.println("saliendo ... ");;System.exit(0);
		}
	
		}while(opcion!=6); 
	}

	
	private static void eliminarVehiculo(Scanner sc, ArrayList<Vehiculo> parqueMovil) {
		System.out.print("Que vehiculo quieres eliminar? (selecciona id):");
		mostrarVehiculos(parqueMovil);
		int opcion=sc.nextInt();sc.nextLine();
		for (Vehiculo vehiculo :parqueMovil) {
			if (vehiculo.getId()==opcion) {
				parqueMovil.remove(vehiculo);
			}
		}
		System.out.println("vehicula eliminado.");
		System.out.println("Listado actualizado");
		mostrarVehiculos(parqueMovil);
		
	}


	private static void buscarVehiculoPorMarca(Scanner sc, ArrayList<Vehiculo> parqueMovil) {
		System.out.println("marca: ");
		String marca = sc.nextLine();
		for (Vehiculo vehiculo: parqueMovil) {
			if(vehiculo.getMarca().contains(marca)) {
				System.out.println(vehiculo);
			}
		}
		
		
	}


	private static void buscarVehiculo(Scanner sc, ArrayList<Vehiculo> parqueMovil) {
		System.out.print("pais: ");
		String pais=sc.nextLine();
		for ( Vehiculo vehiculo: parqueMovil) {
			if (vehiculo.getPaisOrigen().contains(pais)) {
				System.out.println("Vehiculos procedentes de "+ pais+": "+ vehiculo);
			break;
			}else 
					System.out.println("No hay vehiculos de ese pais");
			}
		}
	
	private static void mostrarVehiculos(ArrayList<Vehiculo> parqueMovil) {
		
		System.out.println("Vehiculos registrados: ");
		for (int i=0; i<parqueMovil.size();i++) {
		System.out.println(parqueMovil.get(i));
			
		}
		
	}
	private static void añadirVehiculo(Scanner sc,ArrayList <Vehiculo> parqueMovil) {
		
		System.out.print("marca: ");
		String marca=sc.nextLine();
		System.out.print("modelo: ");
		String modelo=sc.nextLine();
		System.out.print("pais de origen:");
		String paisOrigen=sc.nextLine();
		
		Vehiculo vehiculo = new Vehiculo(marca, modelo, paisOrigen);
		parqueMovil.add( vehiculo);
		System.out.println("Vehiculo añadido.");
	}
	private static void mostrarMenu(Scanner sc) {
		System.out.println("--- menu ---");
		System.out.println("1- añadir vehiculo.");
		System.out.println("2- mostrar vehiculos.");
		System.out.println("3- buscar vehiculos por pais");
		System.out.println("4- buscar vehiculos por marca");
		System.out.println("5- eliminar vehiculo");
		System.out.println("6- salir");
		
	}
}
	


