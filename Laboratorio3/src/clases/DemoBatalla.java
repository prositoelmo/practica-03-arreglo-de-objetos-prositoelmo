package clases;

import java.util.*;

public class DemoBatalla {

	public static void main(String [] args) {
		
		Nave[] misNaves= new Nave[10];
		Scanner sc= new Scanner(System.in);
		String nombre;
		int columna, fila, puntos;
		boolean estado;
		
		for(int i=0;i<misNaves.length;i++) {
			
				System.out.println("Nave "+ (i+1));
				System.out.print("Nombre: ");
				nombre=sc.next();
				System.out.print("Fila: ");
				fila=sc.nextInt();
				System.out.print("Columna: ");
				columna=sc.nextInt();
				System.out.print("Estado: ");
				estado=sc.nextBoolean();
				System.out.print("Puntos: ");
				puntos=sc.nextInt();
				
				misNaves[i]= new Nave();
				misNaves[i].setNombre(nombre);
				misNaves[i].setFila(fila);
				misNaves[i].setColumna(columna);
				misNaves[i].setEstado(estado);
				misNaves[i].setPuntos(puntos);
		}
		mostrarNaves(misNaves);
		
		for (int i=0;i<3;i++) {
			System.out.println("\n Naves Creadas:");
			System.out.println("\t MENU");
			System.out.println("Ingrese el número con la opción que desee");
			System.out.println("1. Buscar nave por nombre");
			System.out.println("2. Buscar nave por puntos");
			System.out.println("3. mostrar Matriz de Naves");
			
			int opcion= sc.nextInt();
			switch(opcion) {
				case 1: mostrarPorNombre(misNaves);
					break;
				case 2: mostrarPorPuntos(misNaves);
				break;
				case 3: mostrarMatrizDeNaves(misNaves);
				break;
			}
		}
		
		
		
		
		
		
	}

	public static void mostrarPorPuntos(Nave[] flota) {
		Scanner sc=new Scanner(System.in);
		System.out.println("INGRESE PUNTAJE, SE MOSTRARÁN LOS IGUALES E INFERIORES A ESTE");
		int puntaje=sc.nextInt();
		for(int i=0;i<flota.length;i++) {
			if(puntaje>=flota[i].getPuntos()) {
				imprimirDatos(flota[i]);
			}
		}
		
	}

	public static void mostrarPorNombre(Nave[] flota) {
		Scanner sc=new Scanner(System.in);
		System.out.println("INGRESE NOMBRE DE LA NAVE A BUSCAR");
		String nombre= sc.next();
		for(int i=0;i<flota.length;i++) {
			if(nombre.equalsIgnoreCase(flota[i].getNombre())) {
				imprimirDatos(flota[i]);
			}
		}
	}

	public static void mostrarNaves(Nave[] flota) {
		for(int i=0;i<flota.length;i++) {
				imprimirDatos(flota[i]);
		}
	}
	public static void mostrarMatrizDeNaves(Nave[] flota) {
		boolean igualdad=false;
		for(int i=0; i<10;i++) {
			for(int j=0;j<10;j++) {
				for(int nave=0;nave<flota.length;nave++) {
					if(flota[nave].getFila()==i&&flota[nave].getColumna()==j) {//inicio de filas y columnas son cero
						System.out.print(regularTamaño(flota[nave].getNombre()));
						igualdad=true;
						break;
					}
					
				}
				if(!igualdad) {
					System.out.print("      o      ");
				}
				igualdad=false;
			}
			System.out.println("");
		}
	}
	public static void imprimirDatos(Nave nave) {

		System.out.println("Nombre: "+nave.getNombre());
		System.out.println("Columna: "+nave.getColumna());
		System.out.println("Fila: "+nave.getFila());
		System.out.println("Estado: "+nave.isEstado());
		System.out.println("Puntos: "+nave.getPuntos() +"\n");
		
	}
	public static String regularTamaño(String palabra) {
		
			for(int i=0; i<((13-palabra.length())/2)+1;i++) {
				palabra=" "+palabra+" ";
			}
			if(palabra.length()%2==0) {
				palabra=palabra+" ";
			}
			return palabra;
	}
}
