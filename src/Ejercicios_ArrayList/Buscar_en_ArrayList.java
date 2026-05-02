package Ejercicios_ArrayList;

import java.util.ArrayList;
import java.util.Scanner;



public class Buscar_en_ArrayList {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<String> personas = new ArrayList<>();
		
		personas.add("Ana");
		personas.add("Luis");
		personas.add("Marta");
		personas.add("Saida");

		System.out.print("Nombre a buscar: ");
		String nombreBuscado= sc.nextLine();
		
		boolean encontrado=false;
		
		for (String nombre: personas) {
			if (nombre.equals(nombreBuscado)) {
				
				encontrado= true;
				break;
			
			}
			
		}if (encontrado)
			System.out.println("Encontrado !!");
		else {
			System.out.println("No encontrado");
		}
		
		sc.close();
		
	}

}
