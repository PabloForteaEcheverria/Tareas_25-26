package Tarea_6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Biblioteca {
	private List<Libro> libros;
	private Map<String, Libro> isbnListado; 

	public Biblioteca() {
		libros = new ArrayList<>();
		isbnListado = new HashMap<>();
	}

	public Libro buscarConIsbn(String isbn) {
		return isbnListado.get(isbn);
		
	}

	public void añadirLibro(Libro libro) {
		if (isbnListado.containsKey(libro.getIsbn())) {
			System.out.println("El libro esta duplicado");
			return;
		} 
			libros.add(libro);
			isbnListado.put(libro.getIsbn(), libro);
		System.out.println("El libro añadido");

	}

	public void prestar(String isbn) {
		Libro libro = buscarConIsbn(isbn);
		if (libro == null) {
			System.out.println("El Libro no existe. ");
			return;
		}
		if (libro.prestar()) {
			System.out.println("Libro prestado.");
		} else {
			System.out.println("Libro no disponible");
		}

	}

	public void devolver(String isbn) {
		Libro libro = buscarConIsbn(isbn);
		if (libro == null) {
			System.out.println("El Libro no existe. ");
			return;
		}
		if (libro.devolver()) {
			System.out.println("Libro devuelto.");
		} else {
			System.out.println("Libro ya estaba disponible");
		}
	}
	public void mostrarListadoLibros() {
		if (libros.isEmpty()) {
			System.out.println("No hay libros en la bibliioteca.");
		}
		for (Libro libro : libros ) {
			System.out.println(libro);
		}
	}

	public List<Libro> getLibros() {
		return libros;
	}

	public void setLibros(List<Libro> libros) {
		this.libros = libros;
	}

	public Map<String, Libro> getIsbnListado() {
		return isbnListado;
	}

	public void setIsbnListado(Map<String, Libro> isbnListado) {
		this.isbnListado = isbnListado;
	}


	
	
}
