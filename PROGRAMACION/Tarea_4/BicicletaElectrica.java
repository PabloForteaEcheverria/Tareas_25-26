package Tarea_4;

public class BicicletaElectrica {
	
	
	private static int contador=0;
	
	private int id;
	private String marca;
	private String modelo;
	private int autonomia;
	private double bateria;
	private double kmTotales;
	private Propietario propietario;

	
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
	
	@Override	
	public String toString() {
		return "Bicicleta: " + id +"\n"+
				"Propietario: "+ propietario+"\n"+
				"Marca: "+marca+"\n"+
				"Modelo: "+ modelo+"\n"+
				"Autonomia: "+autonomia+"\n"+
				"Km totales: "+kmTotales;
				
	}
	
	
	public void realizarRecorrido(double km) {
	
		double consumo=(km/(double)autonomia)*100;
		if (consumo > bateria) {
			System.out.printf("No hay bateria sufuciente para %.1f km.\n\n",km);
			
		}
		else {
			bateria -=consumo;
			kmTotales+=km;
			System.out.printf("Recorrido de %.1f km, confirmado.\n\n",km);
			
		}
	
	}

	
	public void cargarBateria(int carga){
	if  (bateria == 100) {
		 System.out.println("La bateria ya se encuentra al 100% de carga\n");
		 return; 
	 }	
	 if(carga > (100-bateria)){		
		 System.out.println("Solo puedes cargar un max de: "+ (100-(int)bateria));
		 return;
	 }
	 else
		bateria+=carga;	
		System.out.println("Batería cargada correctamente. Nivel actual: " + (int)bateria + "%\n\n");
	}
	public void asignarPropietario(Propietario p) {
	this.propietario=p;	
	System.out.println("Propietario asignado correctamente. \n");
	}
	public void eliminarPropietario() {
	propietario=null;	
	}
	public String comprobarBateria() {
		double bateria = getBateria();
		if (bateria <20)
			return"Bateria baja";
		else if(bateria < 50 )
			return"Bateria moderada";
		else
			return "Bateria suficiente";
	}
	
	public static void totalBicicletas() {
		System.out.println("El numero total de bicicletas es: "+contador );
	}
	public int getId() {
		return id;
	}
	public double getBateria() {
		return bateria;
	}
	public double getKmTotales() {
		return kmTotales;
	}
	public Propietario getPropietario() {
		return propietario;
	}
	public static int getContador() {
		return contador;
	}
	public void setPropietario(Propietario propietario) {
		this.propietario = propietario;
	}
			
}




