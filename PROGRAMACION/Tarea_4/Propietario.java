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
	@Override	
	public String toString() {
	
		return "Nombre: "+ nombre+"\n"+
			   "DNI: "+ dni+"\n"+
		       "Telefono: "+ telefono+"\n";
	}
}
