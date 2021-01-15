package neo;

import java.util.Objects;
import java.util.Scanner;

public class Test_Neodatis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner reader = new Scanner(System.in);
		BBDD db = new BBDD();
		boolean fin=false;
		while (!fin) {
			System.out.println("1. Visualizar");
			System.out.println("2. Insertar");
			System.out.println("3. Borrar ");
			System.out.println("4. actualizar ");
			System.out.println("5. Salir"); 
			System.out.print("Introduce que opcion quieres?");
			int opcion = reader.nextInt();
			switch(opcion) {
				case 1:
					db.listar();
					break;
				case 2:
					System.out.print("Introduce nombre: ");
					String nombre_jugador=reader.next();
					System.out.print("Introduce deporte: ");
					String nom_deporte=reader.next();
					System.out.print("Introduce ciudad: ");
					String ciudad=reader.next();
					System.out.print("Introduce edad: ");
					int edad=reader.nextInt();
					db.insertar(new Jugador(nombre_jugador, nom_deporte,ciudad,edad));
					break;
				case 3:		
					System.out.println("Introduce el nombre");
					String n_jug=reader.next();
					db.borrar(n_jug);
					break;
				case 4:
					System.out.println("Dime que jugador");
					String nom=reader.next();
					db.actualizar(nom);
					break;	
				case 5:
					db.CerrarBBDD();
					fin=true;
					break;
			}
		}
		

	}

}
