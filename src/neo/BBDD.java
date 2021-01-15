package neo;


import java.util.Scanner;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

public class BBDD {

	public ODB odb;
	
	public void insertar(Jugador e) {
		odb.store(e);
	}
	
	public void listar() {
		Objects <Jugador> objetos=odb.getObjects(Jugador.class);
		System.out.println(objetos.size());
		int i=1;
		while(objetos.hasNext()) {
			Jugador jug=objetos.next();
			System.out.println((i++)+"--"+jug.getNombre()+"--"+jug.getCiudad()+"--"+jug.getDeporte()+"--"+jug.getEdad());
		}
	}
	
	public void borrar(String jugador) {
		IQuery query=new CriteriaQuery(Jugador.class,
				Where.equal("nombre", jugador));
		Objects <Jugador> objetos=odb.getObjects(query);
		Jugador jug=(Jugador)odb.getObjects(query).getFirst();
		odb.delete(jug);
	}
	
	public void actualizar(String s) {
		Scanner e=new Scanner(System.in);
		IQuery query=new CriteriaQuery(Jugador.class,
				Where.equal("nombre", s));
		Objects <Jugador> objetos=odb.getObjects(query);
		Jugador jug=(Jugador)odb.getObjects(query).getFirst();
		System.out.println("Ingresa la ciudad");
		String ciudad=e.next();
		jug.setCiudad(ciudad);
		
		System.out.println("Ingresa el deporte");
		String deporte=e.next();
		jug.setDeporte(deporte);
		
		System.out.println("Ingresa la edad");
		int edad=e.nextInt();
		jug.setEdad(edad);
		
		odb.store(jug);
	}
	
	
	public BBDD() {
		odb=ODBFactory.open("neodatis2.test");
	}

	public void CerrarBBDD(){
		odb.close();
	}
}
