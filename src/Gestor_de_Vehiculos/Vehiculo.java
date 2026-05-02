package Gestor_de_Vehiculos;

public class Vehiculo {
	
	static int contador=0;
	
	int id=0;
	String marca;
	String modelo;
	String paisOrigen;
	
public Vehiculo(String marca, String modelo, String paisOrigen) {
		super();
		this.contador++;
		this.id=id+=contador;
		this.marca = marca;
		this.modelo = modelo;
		this.paisOrigen = paisOrigen;
		
	}



@Override
public String toString() {
	return "Vehiculo [id=" + id + ", marca=" + marca + ", modelo=" + modelo + ", paisOrigen=" + paisOrigen + "]";
}



public String getMarca() {
	return marca;
}

public void setMarca(String marca) {
	this.marca = marca;
}

public String getModelo() {
	return modelo;
}

public void setModelo(String modelo) {
	this.modelo = modelo;
}

public String getPaisOrigen() {
	return paisOrigen;
}

public void setPaisOrigen(String paisOrigen) {
	this.paisOrigen = paisOrigen;
}



public int getId() {
	return id;
}



public void setId(int id) {
	this.id = id;
}





}
