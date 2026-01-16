package Tarea_4;

import java.util.Scanner;

public class Principal {
		
	
		
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Propietario propietario1 = new Propietario("Pablo","20178178G","666777888");
		BicicletaElectrica bicicleta1 = new BicicletaElectrica("BH","TTBX1",60);
		bicicleta1.setPropietario(propietario1);
		System.out.println("Propietario asignado correctamente");
		
		
		BicicletaElectrica bicicleta2 = new BicicletaElectrica("Orbea","S3",50);
		System.out.println("Bicicletas creadas: "+ BicicletaElectrica.getContador()+"\n");
		

		inicio(sc, bicicleta1, bicicleta2);
	}

	
	private static void inicio(Scanner sc, BicicletaElectrica bicicleta1, BicicletaElectrica bicicleta2) {
		int opcion=0;
		do {
			System.out.println("************** MENU GESTION BICICLETAS ELECTRICAS **************");
			System.out.println("1- Asignar propietario");
			System.out.println("2- Retirar propietario");
			System.out.println("3- Realizar recorrido");
			System.out.println("4- Cargar bateria");
			System.out.println("5- Mostrar informacion");
			System.out.println("6- Salir");
			
			
			System.out.println();
			opcion=validarNumero(sc);
		
			
			switch(opcion) {
			case 1: asignarPropietario(sc,bicicleta1, bicicleta2);break;
			case 2: retirarPropietario(sc,bicicleta1, bicicleta2);break;
			case 3: realizarRecorrido(sc,bicicleta1, bicicleta2);break;
			case 4: cargarBateria(sc,bicicleta1, bicicleta2);break;
			case 5: mostrarInformacion(bicicleta1, bicicleta2);break;
			case 6: despedida();break;
			default: System.out.println("opcion no valida");break;
			
			}
		}
		while((opcion != 6));
	}
	

	private static void cargarBateria(Scanner sc, BicicletaElectrica bicicleta1, BicicletaElectrica bicicleta2) {
		System.out.println("¿Que bicicleta quieres usar? (1 o 2)");
		int carga;
		int opcion=0;;
		while (opcion != 1 && opcion != 2) {
			opcion=validarNumero(sc);
			if  (opcion != 1 && opcion != 2)
				System.out.println("No existe la bicicleta seleccionada.");
		}
		if(opcion == 1) {
			if (bicicleta1.getPropietario() == null) {
				System.out.println("La bicicleta no tiene propietario.");
				System.out.println("------------------------------------------------");	
			}
			else {
				System.out.print("Cuanto quieres cargar (%)? ");
				carga=validarNumero(sc);
				bicicleta1.cargarBateria(carga);
				
			}
		}
	}


	private static void realizarRecorrido(Scanner sc, BicicletaElectrica bicicleta1, BicicletaElectrica bicicleta2) {
		System.out.println("¿Que bicicleta quieres usar? (1 o 2)");
				
				int opcion=0;;
				while (opcion != 1 && opcion != 2) {
					opcion=validarNumero(sc);
					if  (opcion != 1 && opcion != 2)
						System.out.println("No existe la bicicleta seleccionada.");
				}
				System.out.println("¿Cuantos km vas ha recorrer");	
				double kmRecorridos = validarNumero(sc);

				
				if(opcion ==1) {
					if (bicicleta1.getPropietario() == null) {
							System.out.println("La bicicleta no tiene propietario.");
							System.out.println("------------------------------------------------");	
					}
					else {
						bicicleta1.realizarRecorrido(kmRecorridos);
					
					}
				}
				else if (opcion== 2) {
					if (bicicleta2.getPropietario() == null) {
						System.out.println("La bicicleta no tiene propietario.");
						System.out.println("------------------------------------------------");	
					}
					else {
						bicicleta2.realizarRecorrido(kmRecorridos);
					
					}
				}
				
	}





	private static void  mostrarInformacion(BicicletaElectrica bicicleta1, BicicletaElectrica bicicleta2) {
		
		System.out.println("------------------------------------------------");
		System.out.println("Número total de bicicletas: " + BicicletaElectrica.getContador()+"\n");
		System.out.println(bicicleta1);	
		System.out.print("Estado batería: " + bicicleta1.comprobarBateria());
		System.out.printf(", %.0f%% \n\n", bicicleta1.getBateria());
		System.out.println(bicicleta2);
		System.out.print("Estado batería: " + bicicleta2.comprobarBateria());
		System.out.printf(", %.0f%% \n\n", bicicleta2.getBateria());
		System.out.println("------------------------------------------------");
		}
	
	private static void asignarPropietario(Scanner sc, BicicletaElectrica bicicleta1, BicicletaElectrica bicicleta2) {
		System.out.println("¿Que bicicleta quieres usar? (1 o 2)");
		
		int opcion=0;;
		while (opcion != 1 && opcion != 2) {
			opcion=validarNumero(sc);
			if  (opcion != 1 && opcion != 2)
				System.out.println("No existe la bicicleta seleccionada.");
			}
		System.out.print("Nombre: ");
		String nombre=sc.nextLine();
		System.out.print("DNI: ");
		String dni=sc.nextLine();
		System.out.print("Telefono: ");
		String telefono=sc.nextLine();
		
		Propietario p = new Propietario(nombre,dni,telefono);
		
		if (opcion == 1) {
			if (bicicleta1.getPropietario() != null) {
				System.out.println("La bicicleta ya tiene propietario, elige otra o retiralo");	
			}
			else
			bicicleta1.asignarPropietario(p);
			
		}
		else if (opcion ==2) {
			if (bicicleta2.getPropietario() != null) {
				System.out.println("La bicicleta ya tiene propietario, elige otra o retiralo");	
			}
			else
			bicicleta2.asignarPropietario(p);
		}
		
		}

	private static void retirarPropietario(Scanner sc, BicicletaElectrica bicicleta1, BicicletaElectrica bicicleta2) {
System.out.println("¿Que bicicleta quieres modificar? (1 o 2)");
		
		int opcion=0;;
		while (opcion != 1 && opcion != 2) {
			opcion=validarNumero(sc);
			if  (opcion != 1 && opcion != 2)
				System.out.println("No existe la bicicleta seleccionada.");
			}

		if (opcion == 1) {
			if (bicicleta1.getPropietario() == null) {
				System.out.println("La bicicleta no tiene propietario, esta disponible.");	
			}
			else
			bicicleta1.eliminarPropietario();
			System.out.println("Propietario borrado correctamente");
		}
		else if (opcion ==2) {
			if (bicicleta2.getPropietario() == null) {
				System.out.println("La bicicleta no tiene propietario, esta disponible.");	
			}
			else
			bicicleta2.eliminarPropietario();
			System.out.println("Propietario borrado correctamente");
		}
		
	}
		
	
	
	private static int validarNumero(Scanner sc) {
			int numero=-1;
			boolean valido = false;
			while(!valido) {
				System.out.print("Opcion? ");
				try {
					numero=Integer.parseInt(sc.nextLine());
					if (numero >0)
						valido=true;
					else
						System.out.print("Entrada no valida, debe ser numero. ")	;
				}
				catch(NumberFormatException e) {
					System.out.println("Debe ser numero. ");
				}
			}
		return numero;
		}
		private static void despedida() {
			System.out.println("Hasta pronto.");
			System.exit(0);
		}
	}




















