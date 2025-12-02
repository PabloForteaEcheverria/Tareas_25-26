package Tarea_2.ejercico_2;

import java.util.Scanner;

public class ConversorTiempo {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Introduce una cantidad de segundos: ");
				convertirSegundos(sc);
				sc.nextLine();
				
		System.out.print("Introduce tu edad: ");
				esMayorDeEdad(sc);
				
		sc.close();

	}

	private static void esMayorDeEdad(Scanner sc) {
		int edad = sc.nextInt();
		String resultado = (edad >=18) ? "Es mayor de edad " : "Es menor de edad";
		System.out.println("Resultado de edad: "+ resultado);
	}

	private static void convertirSegundos(Scanner sc) {
		int numero= sc.nextInt();
		int horas = numero/3600;
		int minutos = (numero % 3600)/60;
		int segundos = numero % 60;
	
		System.out.printf("%s segundos son: %d horas, %d minutos y %d segundos\n", numero, horas, minutos, segundos);
	}
	
}
