package Ejercicios_ArrayList;

import java.util.ArrayList;

public class ArrayList_BASICO {

	public static void main(String[] args) {
	
		ArrayList<String> personas = new ArrayList<>();
		
		personas.add("Ana");
		personas.add("Luis");
		personas.add("Marta");
		personas.add("Saida");
		
		for (String nombre: personas) {
			System.out.println(nombre);
		}
		
		System.out.println("borrando a :"+personas.get(1));
		personas.remove(1);System.out.println("borrado.");
		
		for (String nombre: personas) {
			System.out.println(nombre);
		}
		
	}
}
// get()   coger elemento
// remove()   borrar elemento
// size()   Mostrar tamaño