package Ejercicios_Arrays;



public class Array_BASICO {

	public static void main(String[] args) {
		
		String [] personas= new String[4];
		
		personas[0]="Ana";
		personas[1]="Pablo";
		personas[2]="Luis";
		personas[3]="Saida";
		//personas[4]="Pepe";
		
		for (int i=0; i<personas.length;i++) {
			System.out.println("Posicion "+ i +": "+ personas[i]);
		}
		
		// con bucle for-each
		
		for (String nombre: personas ) {
			System.out.println(nombre);
		}

	}

}
