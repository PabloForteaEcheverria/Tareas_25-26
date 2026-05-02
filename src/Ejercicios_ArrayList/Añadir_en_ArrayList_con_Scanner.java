package Ejercicios_ArrayList;

import java.util.ArrayList;
import java.util.Scanner;

public class Añadir_en_ArrayList_con_Scanner {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		ArrayList<String> nombres = new ArrayList<>();
		
		for (int i=0; i <3; i++){
			System.out.print("Dame un nombre: ");
			String nombre=sc.nextLine();
			
			nombres.add(nombre);
		}
		
		
		for (String nombre: nombres) {
			System.out.println(nombre);
		}
	}
	

}
