package Tarea_6;


import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		
	Scanner sc = new Scanner(System.in);
	
		Biblioteca b = new Biblioteca();
		FicheroLibros.leerFichero("PROGRAMACION/Tarea_6/libros.txt", b);
		
	int opcion=0;
		
		do{
			mostrarMenu();
			opcion = validarEntero(sc);
			
			switch(opcion) {
			case 1:añadirLibro(sc, b);break;
			case 2:mostrarLibros(sc, b);break;
			case 3:prestarLibro(sc, b);break;
			case 4:devolverLibro(sc, b);break;
			case 5:buscarLibro(sc, b);break;
			case 6:guardar(sc, b);break;
			}
			
		}while (opcion != 7); 
		System.out.println("adios...");
		
	}//main
	
	private static void guardar(Scanner sc, Biblioteca b) {
		FicheroLibros.guardarFichero("Libros.txt", b);
		
	}

	private static void buscarLibro(Scanner sc, Biblioteca b) {
		System.out.println("Codigo del libro?: ");
		String isbn = sc.nextLine().trim();
		Libro libro = b.buscarConIsbn(isbn);
		 if (libro != null) {
		        System.out.println("Libro encontrado: " + libro); // usa toString()
		    } else {
		        System.out.println("No se encontró el libro.");
		    }
	}

	private static void devolverLibro(Scanner sc, Biblioteca b) {
		System.out.println("Codigo del libro?: ");
		String isbn = sc.nextLine();
		b.devolver(isbn);
		
	}

	private static void prestarLibro(Scanner sc, Biblioteca b) {
		System.out.println("Codigo del libro?: ");
		String isbn = sc.nextLine();
		b.prestar(isbn);
	}

	private static void mostrarLibros(Scanner sc,Biblioteca b) {
		b.mostrarListadoLibros();
		
	}

	private static void añadirLibro(Scanner sc,Biblioteca b) {
		System.out.print("Codigo libro?: ");
		String isbn=sc.nextLine();
			if (b.buscarConIsbn(isbn) != null) {
				System.out.println("Este libro ya existe.");
				return;
			}
		
		System.out.print("titulo?: ");
		String titulo=sc.nextLine();
		
		System.out.print("Autor?: ");
		String autor=sc.nextLine();
		
		
		Libro libro = new Libro(isbn,titulo,autor,true );
		b.añadirLibro(libro);
	}

	private static int validarEntero(Scanner sc) {
		while (true) {
			String entrada=sc.nextLine();
			try {
			return Integer.parseInt(entrada);
			} catch (NumberFormatException e) {
				System.out.println("Entrada no valida");
			}
		}
	}

	private static void mostrarMenu() {
		System.out.println("###################   menu   ######################\n");

		System.out.println("1- Añadir libro");
		System.out.println("2- mostrar libros");
		System.out.println("3- prestar libros");
		System.out.println("4- devolver libros");
		System.out.println("5- buscar por 'isbn'");
		System.out.println("6- guardar datos en fichero");
		System.out.println("7- salir");
		System.out.println("###################################################\n");
		System.out.print("Elije una opcion: ");
	}
}
