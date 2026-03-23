package Tarea_6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FicheroLibros {

	private static final String nombreFichero = "libros.txt";

	public static void leerFichero(String f, Biblioteca b) {

		try {
	//1. Abrir el fichero con:
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
		
			String linea;
	//2. Leer líneas mientras exista una nueva línea:
				while ( (linea = br.readLine()) !=null ) {
	//3. Limpiar la línea:
				linea = linea.trim();  // para quitar espacios al principio y final	
			
				if (linea.isEmpty())
					continue;
	//4. Separar los campos:
				String[] partes = linea.split(";");
				if (partes.length != 4)  // ojo, sin () //
					continue; // no cumple con formato de 4 partes, ignora linea
	//5. Extraer y limpiar cada dato
			    String isbn = partes[0].trim();
	            String titulo = partes[1].trim();
	            String autor = partes[2].trim();
	            String dispStr = partes[3].trim();

	     
	            if (isbn.isEmpty() || titulo.isEmpty() || autor.isEmpty())
	                continue;

	            if (!dispStr.equalsIgnoreCase("true") &&
	                !dispStr.equalsIgnoreCase("false"))
	                continue;
    // 6. Convertir el boolean:
		        boolean disponible = Boolean.parseBoolean(dispStr);

			    Libro libro = new Libro(isbn, titulo, autor, disponible);
	            b.añadirLibro(libro);
		        }
		} catch (IOException e) {
			System.out.println("formato incorrecto");
		}
	}//leerFichero	
	
	//	8. Crear el libro y añadirlo a la biblioteca:	
	public static  void guardarFichero(String f, Biblioteca b) {
		
			try {
				FileWriter fw = new FileWriter(f);
				BufferedWriter bw = new BufferedWriter(fw);
				
				for (int i = 0; i < b.getLibros().size(); i++) {
				    Libro libro = b.getLibros().get(i);
				
				String linea = libro.getIsbn()+";"+libro.getTitulo()+";"+libro.getAutor()+";"+libro.isDisponible();

				bw.write(linea);
				bw.newLine();
				
				}
				bw.close();
				System.out.println("Datos guardados correctamente en " + f);
				
			} catch (IOException e) {
				System.out.println("Error al escribir el fichero: …");
			}
	}//guardarFichero
}//Class