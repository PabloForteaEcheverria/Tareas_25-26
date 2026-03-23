package Tarea_5;

import java.util.HashMap;

public class AlmacenDispositivos {

	private HashMap<String, Dispositivo> indicePorCodigo; /// busqueda por codigo
	private Dispositivo[] inventario; /// inventario
	private int contador;

	// constructor:

	public AlmacenDispositivos() {
		this.inventario = new Dispositivo[30];
		this.indicePorCodigo = new HashMap<>();
		this.contador = 0;
	}

	public boolean hayDispositivos() {
		return !indicePorCodigo.isEmpty();// false vacio / true al menos uno
	}

	public boolean altaDispositivo(Dispositivo d) {
		if (contador >= 30) {
			System.out.println("El almacen esta lleno.");
			return false;
		}
		if (indicePorCodigo.containsKey(d.getCodigo())) {
			return false;
		}
		inventario[contador] = d; // al Array
		indicePorCodigo.put(d.getCodigo(), d); // al HashMap
		contador++;

		return true;
	}

	public Dispositivo buscarPorCodigo(String codigo) {
		Dispositivo dispositivoEncontrado = indicePorCodigo.get(codigo);

		if (dispositivoEncontrado != null) {
			return dispositivoEncontrado;
		} else {
			System.out.println("No hay dispositivo con ese codigo");
			return null;
		}
	}

	public void listarDispositivos() {
		if (!hayDispositivos()) {
			System.out.println("No hay dispositivos registrados");
			System.out.println();
		}
		for (int i = 0; i < contador; i++) {

			System.out.println(inventario[i]);
		}
	}

	public double mediaGlobalConsumo() {

		double totalConsumo = 0;
		if (contador <= 0) {
			System.out.println("Almacen vacio");
			return 0;
		}

		for (int i = 0; i < contador; i++) {
			Dispositivo disp = inventario[i];
			totalConsumo += disp.mediaConsumo();
		}
		double mediaGlobal = totalConsumo / contador;
		return Math.round(mediaGlobal * 100) / 100;
	}

	public boolean dispositivoExiste(String codigo) {
		return indicePorCodigo.containsKey(codigo);
		// return true si existe
	}

	public Dispositivo dispositivoMasUsado() {
		if (contador == 0)
			return null;

		Dispositivo mayorConsumo = inventario[0];

		for (int i = 1; i < contador; i++) {
			if (inventario[i].totalHorasUso() > mayorConsumo.totalHorasUso()) {
				mayorConsumo = inventario[i];
			}
		}

		return mayorConsumo;
	}
}
