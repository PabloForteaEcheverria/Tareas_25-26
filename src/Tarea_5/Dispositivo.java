package Tarea_5;

import java.util.ArrayList;

public class Dispositivo {

	private String codigo;
	private String nombre;
	private String tipo;
	private ArrayList<SesionUso> sesiones; // almaceno todas las sesiones del dispositivo

	public Dispositivo(String codigo, String nombre, String tipo) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.tipo = tipo;
		this.sesiones = new ArrayList<>(); // creo una lista vacia para guardar las sesiones de uso
	}

	@Override
	public String toString() {
		String resultado = "Codigo del dispositivo: " + codigo + "\n" + "Dispositivo [" + "nombre: " + nombre
				+ ", tipo: " + tipo + ", media consumo: " + mediaConsumo() + ", total horas de uso: " + totalHorasUso()
				+ ", temperatura media: " + mediaTemperatura() + " ]\n" + "Sesiones: \n";
		for (SesionUso sesion : sesiones) {
			resultado += "\t [" + sesion + " ]\n"; // concatena cada sesión
		}

		return resultado;
	}

	public void registrarSesion(SesionUso sesion) {// Añade la sesión al listado.
		sesiones.add(sesion);

	}

	public double mediaConsumo() {
		if (sesiones.size() == 0) {

			return 0;
		}

		double totalConsumos = 0;
		for (int i = 0; i < sesiones.size(); i++) {
			double consumo = Math.min(100, sesiones.get(i).getConsumo());
			totalConsumos += consumo;
		}
		double media = totalConsumos / sesiones.size();
		return media;

	}

	public double mediaTemperatura() {// Media de temperatura máxima de todas las sesiones (si no hay sesiones,
										// devuelve 0).
		if (sesiones.size() == 0) {
			return 0;
		}
		double sumaTemperaturas = 0;
		for (int i = 0; i < sesiones.size(); i++) {
			double temperaturaMax = sesiones.get(i).getTemperaturaMax();
			sumaTemperaturas += temperaturaMax;
		}
		double media = sumaTemperaturas / sesiones.size();
		return media;
	}

	public double totalHorasUso() {
		if (sesiones.size() == 0) {
			System.out.println("El dispositivo notiene sesiones.");
			return 0;
		}
		double totalHorasSesion = 0;
		for (int i = 0; i < sesiones.size(); i++) {
			double horasDeSesion = sesiones.get(i).getHoras();
			totalHorasSesion += horasDeSesion;
		}
		return totalHorasSesion;
	}

	public SesionUso sesionMayorConsumo() { // Devuelve la sesión con mayor consumo (si no hay, devuelve null).

		if (sesiones.size() == 0) {
			System.out.println("El dispositivo notiene sesiones.");
			return null;
		}

		SesionUso mayorConsumoSesion = sesiones.get(0);
		for (SesionUso sesion : sesiones) {
			if (sesion.getConsumo() > mayorConsumoSesion.getConsumo()) {
				mayorConsumoSesion = sesion;
			}
		}
		return mayorConsumoSesion;
	}

	public void mostrarSesiones() {// Muestra todas las sesiones registradas (una por línea).
		if (sesiones.size() == 0) {
			System.out.println("no tiene sesiones.");
		} else {
			for (int i = 0; i < sesiones.size(); i++) {
				System.out.println(sesiones.get(i));
			}
		}
	}

	public String getCodigo() {
		return codigo;
	}

}
