package Tarea_4;

public class Propietario {
	
	private String nombre;
	private String dni;
	private String telefono;
	
	
	public Propietario () {
		this.nombre=null;
		this.dni=null;
		this.telefono=null;
	}
	public Propietario (String nombre, String dni, String telefono) {
		this.nombre=nombre;
		this.dni=dni;
		this.telefono=telefono;
	}
	public static boolean validarDni(String dni) {
		 return dni.matches("\\d{8}[A-Za-z]");
	}
	
	@Override	
	public String toString() {
	
		return "Nombre: "+ nombre+" | "+
			   "DNI: "+ dni+" | "+
		       "Telefono: "+ telefono;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
}
