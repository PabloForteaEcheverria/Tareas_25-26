package Tarea_5;

public class SesionUso {
	private double horas;
	private double consumo;
	private double temperaturaMax;

	public SesionUso(double horas, double consumo, double temperaturaMax) {
		this.horas = horas;
		this.consumo = consumo;
		this.temperaturaMax = temperaturaMax;
	}

	@Override
	public String toString() {
		return "Horas de uso: " + horas + ", " + "consumo: " + consumo + ", " + "temperatura maxima:" + temperaturaMax;

	}

	public double getHoras() {
		return horas;
	}

	public void setHoras(double horas) {
		this.horas = horas;
	}

	public double getConsumo() {
		return consumo;
	}

	public void setConsumo(double consumo) {
		this.consumo = consumo;
	}

	public double getTemperaturaMax() {

		return Math.min(100, temperaturaMax);
	}

	public void setTemperaturaMax(double temperaturaMax) {
		this.temperaturaMax = Math.min(100, temperaturaMax);
	}

}
