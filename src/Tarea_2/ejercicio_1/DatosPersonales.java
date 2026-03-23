package Tarea_2.ejercicio_1;

public class DatosPersonales {
	
	public static void main(String[] args) {
	
	String nombre = "Saida Esteve";
	int edad = 38;
	double altura = 1.72;
	boolean carnetConducir = true;
	double saldoBancario = 42.788;
	String numSerie = "eH76G4738";
	
	/* edad: elegido int porque es un numero entero.
	 * nombre: elegido String porque  se usa para almacenar texto.
	 * altura: elegido double porque admite decimales para mayor precision.
	 * carnetDeConducir: elegido booleano porque devuelve verdadero o falso.
	 * saldoBancario: elegido también double para ser mas preciso si hubiera decimales.
	 * numSerie: elegido String porque admite caracteres alfanumericos.
	 * mensajeCarnet: elegido  String  porque devuelve  textos en funcion del boolean.
	 */
		

	System.out.printf("Nombre: %s\n", nombre);
    System.out.printf("Edad: %d\n", edad);
    System.out.printf("Altura: %.2f\n", altura);
    
    String mensajeCarnet = carnetConducir ? "tiene carnet" : "no tiene carnet";
    System.out.println("Carnet de conducir: "+ mensajeCarnet);
   
    System.out.println("Saldo en cuenta: "+ saldoBancario + " euros");
    System.out.println("Numero de seerie del dispositivo: "+ numSerie);
	}

}
