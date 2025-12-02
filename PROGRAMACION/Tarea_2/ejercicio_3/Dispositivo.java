package Tarea_2.ejercicio_3;



public class Dispositivo {

		private Persona titular;	
		private String modelo;
		private String tipo;
		private int bateria;
		private int consumoHora;
		private int horasUso;
		
public Dispositivo (String modelo, String tipo, int bateria, int consumoHora, int horasUso ,Persona titular) {
	this.modelo=modelo;
	this.tipo=tipo;
	this.bateria=Math.max(0,Math.min(bateria, 100));
	this.consumoHora=Math.max(0, consumoHora);
	this.horasUso=horasUso;
	this.titular=titular;
}

public void usarDispositivo(int horas) {
	bateria=Math.max(bateria - horas * consumoHora, 0);
	horasUso += horas;
}

public void cargarDispositivo(int porcentaje) {
	bateria= Math.min(bateria+porcentaje, 100);
}

@Override
	public String toString() {
	return "----- Dispositivo -----"+"\n"+
		   "Modelo: "+modelo+ "\n" +
		   "Tipo: "+tipo+"\n" +
		   "Nivel de bateria: "+ bateria+"\n" +
		   "Consumo por hora: " +consumoHora+"\n"+
		   "Horas de usoTotal: "+ horasUso;
	}

}
