package Tarea_2.ejercicio_3;

import java.util.Scanner;

public class Principal {
public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		// introducimos datos 1er titular
		
		// ayuda constructor ------> (String nombre, String email, String numContacto)
		Persona titular1 = new Persona("Saida ESteve Puch", "saida1988@miempresa.es", "666888777");
		// ayuda Constructor----> (String modelo, String tipo, int bateria, int consumoHora, int horasUso ,Persona titular)
		Dispositivo dispositivo1 = new Dispositivo("Galaxy A22","movil",50,5,8,titular1);
		
		
		// pedimos datos segundo titular
		
		System.out.println("Dame los datos del segundo titular: ");
		System.out.print("introduce nombre: ");
		String nombre = sc.nextLine();
		System.out.print("introduce email: ");
		String email=sc.nextLine();
		System.out.print("introduce telefono de contacto: ");
		String telefono = sc.nextLine();
		
		Persona titular2 = new Persona (nombre, email, telefono);
		
		
		System.out.println("Introduce los datos del dispositivo: ");
		System.out.print("Modelo: ");
		String modelo = sc.nextLine();
		System.out.print("Tipo (Portatil, Tablet, movil, etc...): ");
		String tipo = sc.nextLine();
		System.out.print("Nivel de bateria (%): ");
		int bateria = sc.nextInt();sc.nextLine();
		System.out.print("Consumo por hora (%):");
		int consumoHora = sc.nextInt();sc.nextLine();
		
	// ayuda Constructor----> (String modelo, String tipo, int bateria, int consumoHora, int horasUso ,Persona titular)
		Dispositivo dispositivo2 = new Dispositivo (modelo,tipo,bateria,consumoHora,0,titular2);
		
		System.out.println();System.out.println();
		
		System.out.print("Horas de uso por cada dispositivo: ");
		int horas=sc.nextInt();sc.nextLine();
		System.out.print("Porcentaje de carga de bateria para cada dispositivo: ");
		int carga=sc.nextInt();
		
	// simulamos carga y uso	
		
		dispositivo1.usarDispositivo(horas);
		dispositivo2.usarDispositivo(horas);
		
		dispositivo1.cargarDispositivo(carga);
		dispositivo2.cargarDispositivo(carga);
		
		
	//actualizamos datos de los titulares 
		
		System.out.println();		
		System.out.println("Informacion actualizada de los dispositivos: ");
		System.out.println();
		
		
		System.out.println(dispositivo1);
		System.out.println(titular1);
		
		System.out.println();System.out.println();

		System.out.println(dispositivo2);
		System.out.println(titular2);
		

		sc.close();
	}

}
