package Tarea_4;

import java.util.Scanner;

public class BicicletaElectrica {
	private static  int contador=0;
	private static int id;
	private String marca;
	private String modelo;
	private int autonomia;
	private int bateria;
	private double kmTotales;
	private String propietario;
	
	public  BicicletaElectrica () {
		contador++;
		this.id=contador;
		this.marca="desconocida";
		this.modelo="desconocido";
		this.autonomia=50;
		this.bateria=100;
		this.kmTotales=0;
		this.propietario=null;
	}
	public BicicletaElectrica (String marca, String modelo, int autonomia ) {
		contador++;
		this.id=contador;
		this.marca=marca;
		this.modelo=modelo;
		this.autonomia=autonomia;
		this.bateria=100;
		this.kmTotales=0;
		this.propietario=null;
}
	public void realizarRecorrido(double km) {
	
	kmTotales+=km;
	System.out.println("Recorrido confirmado.");
	}
	
	public void cargarBateria(int carga) {
	if  (bateria + carga > 100)
		bateria=100;
	else
		bateria+=carga;	
	}
	public void asignarPropietario(String p) {
	propietario=p;	
	}
	public void eliminarPropietario(String p) {
	propietario=null;	
	}
	public void comprobarBateria() {
		if (getBateria() <20)
			System.out.println("Bateria baja");
		else if(getBateria()>20 && getBateria()<50 )
			System.out.println("Bateria moderada");
		else 
			System.out.println("Bateria suficiente");
	}
	
	public static void totalBicicletas() {
		System.out.println("El numero total de bicicletas es: "+contador );
	}
	
	public static int getContador() {
		return contador;
	}
	public static void setContador(int contador) {
		BicicletaElectrica.contador = contador;
	}
	public static int getId() {
		return id;
	}
	public static void setId(int id) {
		BicicletaElectrica.id = id;
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
	public int getAutonomia() {
		return autonomia;
	}
	public void setAutonomia(int autonomia) {
		this.autonomia = autonomia;
	}
	public int getBateria() {
		return bateria;
	}
	public void setBateria(int bateria) {
		this.bateria = bateria;
	}
	public double getKmTotales() {
		return kmTotales;
	}
	public void setKmTotales(double kmTotales) {
		this.kmTotales = kmTotales;
	}
	public String getPropietario() {
		return propietario;
	}
	public void setPropietario(String propietario) {
		this.propietario = propietario;
	}
		
}




