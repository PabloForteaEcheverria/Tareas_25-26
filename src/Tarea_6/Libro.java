package Tarea_6;

public class Libro {
	private String isbn;
	private String titulo;
	private String autor;
	private boolean disponible;
	

	public Libro(String isbn, String titulo, String autor, boolean disponible) {
		this.isbn = isbn;
		this.titulo = titulo;
		this.autor = autor;
		this.disponible = disponible; // al crearlo siempre esta disponible
	}

	public boolean prestar() {
		 if (disponible) {  
		        disponible = false; 
		        return true;
		    }
		 return false;
	}
	public boolean devolver() {
		 if (!disponible) {  
		        disponible = true; 
		        return true;
		    }
		 return false;
	}

	@Override
	public String toString() {
		return "Codigo: " + isbn + 
				", Titulo: " + titulo +
				"; Autor: " + autor + 
				"; Disponible: " + disponible;
	}

	public String getIsbn() {
		return isbn;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getAutor() {
		return autor;
	}

	public boolean isDisponible() {
		return disponible;
	}



	
	
}
