package Tarea_3;
import java.util.Scanner;


public class JuegoRuleta {
		
		private double saldo=0; 
		private Scanner sc;
	
	public JuegoRuleta (double saldo, Scanner sc) {
	
		this.saldo = saldo;
		this.sc = sc;
	}	
		@Override	
	public String toString() {
		return "Tu saldo actual es: " +  saldo;
	}
	
	//__________________________  GET & SET _________________________________//
	
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	public Scanner getSc() {
		return sc;
	}
	public void setSc(Scanner sc) {
		this.sc = sc;
	}
	//_____________________________________________________________________________________	
	
	public static void main(String[] args) {	
		
		iniciarJuego();
	}
	//_____________________________________________________________________________________		
	
	private static void iniciarJuego() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Bienvenido al juego de LA RULETA ");
		System.out.print("Dame el saldo inicial: ");
		
		double saldo = validarNumeroDouble(sc);
		
		JuegoRuleta juego = new JuegoRuleta(saldo, sc);
		System.out.println("Inicias juego con un saldo de: "+saldo+ " euros");
	
		juego.menuApuesta();
	}	
	//_____________________________________________________________________________________	
	
		
	private   void menuApuesta() {
		
		int opcion;
		
		System.out.print("Cuanto dinero quieres apostar? ");
		double apuesta = validarNumeroDouble(sc);
		
		if (saldo <= 0 || apuesta > saldo ) 
			recargarSaldo();
	
		do {
				System.out.println("------ Tipo de apuesta ------");
				System.out.println("0- Salir.");
				System.out.println("1- Al numero.");
				System.out.println("2- A Par/Impar.");
				opcion = validarNumeroEntero(sc);
				
				switch (opcion) {
				case 0:	despedida();break;			
				case 1: apuestaNumero(apuesta);break;
				case 2: apuestaParImpar(apuesta);break;
				default: System.out.println("Opcion no valida.");
				}
				otraPartida();
				}
		while (opcion!=0);
	}
	//_____________________________________________________________________________________	
		
		
	private void recargarSaldo() {
		System.out.println("No tienes saldo, ¿Necesitas saldo? ¿Cuanto quieres ingresar?");
		double ingreso=validarNumeroDouble(sc);
		saldo += ingreso;
	//_____________________________________________________________________________________			
	}
	private void despedida() {
		System.out.println("Gracias por jugar, hasta la proxima, tu saldo final es: "+ saldo );
		sc.close();
		System.exit(0);
	}
	//_____________________________________________________________________________________	
	private  void apuestaNumero(double apuesta) {
			
		int numero;
		int jugada =(int)(Math.random()*37);
		
		System.out.print("A que numero quieres apostar (1-36)?\n");
		numero = validarNumeroEntero(sc);
		
		if (jugada == numero) {
			System.out.println("¡ Has ganado !"+"\n");
			saldo += apuesta*36;
		}
		else 
			System.out.printf("¡ Has perdido ! ha salido el numero: %d \n", jugada);
		saldo -= apuesta;
		System.out.println("Tu nuevo saldo es : "+ saldo+"\n");	
		otraPartida();
	}
	//_____________________________________________________________________________________	
	private  void apuestaParImpar(double apuesta) {
			
		int jugada =(int)(Math.random()*37);
		int opcion;
		
		System.out.println("¿A que apuestas: ?");
		System.out.println("1- A Impar");
		System.out.println("2- A Par");
		opcion = validarNumeroEntero(sc);
		
		if (opcion == 1 && jugada %2 != 0) {
			System.out.println("¡ Has ganado !"+"\n");
			saldo +=apuesta*2;
		}
		else 
			System.out.printf("¡ Has perdido ! ha salido el numero: %d \n", jugada);
			saldo -= apuesta;
			System.out.println("Tu nuevo saldo es : "+ saldo +"\n");	
			otraPartida();		
	}
	//_____________________________________________________________________________________	
	private  void otraPartida() {
		String jugadaNueva;
		System.out.println("Quieres seguir apostando (s/n)?");
		jugadaNueva = sc.nextLine();
				
		if (jugadaNueva.equals("s")) {
			menuApuesta();
		}
		else if (jugadaNueva.contains("n")) {
			despedida();
		}
		else
			System.out.println("Opcion no valida, indica (s/n)");
			otraPartida();		
	}	
	
	//_____________________________________________________________________________________	
	
	private static double validarNumeroDouble(Scanner sc) {
		while (true) {
			try {
				return Double.parseDouble(sc.nextLine());
			}
			catch(NumberFormatException e){
				System.out.println("no valido, debe ser numero.");
			}
		}
	}
	private static int validarNumeroEntero(Scanner sc) {
		while (true) {
			try {
				return Integer.parseInt(sc.nextLine());
			}
			catch(NumberFormatException e){
				System.out.println("no valido, debe ser numero.");
			}
		}
	}
}



