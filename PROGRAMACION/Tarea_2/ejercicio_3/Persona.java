 package Tarea_2.ejercicio_3;

public class Persona {

	private String nombre;
	private String email;
	private String numContacto;
	
public 	Persona (String nombre, String email, String numContacto) {
	this.nombre=nombre;
	this.email=email;
	this.numContacto=numContacto;
	}
	
@Override
	public String toString() {
		
	return "----- Titular -----"+"\n"+
		   "nombre: "+nombre+ "\n" +
		   "Correo electronico: "+email+"\n" +
		   "Telefono de contacto: "+ numContacto;
	
	}
}
