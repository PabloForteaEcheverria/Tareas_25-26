package Ejercicios_HashMap;

import java.util.HashMap;


public class HashMap_BASICO {

	public static void main(String[] args) {
		
		HashMap<String, Integer> personas= new HashMap<>();

		 personas.put("Pablo",56);
		 personas.put("Saida",38 );
		 personas.put("Ana",20);
		 personas.put("Marta",30);
		 personas.put("Luis",25);
		 
		 System.out.println("La nota de Luis es: "+personas.get("Luis"));
	
		  for (String nombre:personas.keySet()) {
			 
			
			  System.out.println(nombre + ", edad: "+ personas.get(nombre));
			  
		  }	 
	}
}
