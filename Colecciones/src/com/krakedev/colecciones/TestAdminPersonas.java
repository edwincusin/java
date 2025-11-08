package com.krakedev.colecciones;
import java.util.ArrayList;

public class TestAdminPersonas {

	public static void main(String[] args) {
		AdminPersonas admin=new AdminPersonas();
		
		admin.agregar(new Persona("Mario","Ben",18));
		admin.agregar(new Persona("Delia","Kerl",15));
		admin.agregar(new Persona("Jose","Jen",30));
		admin.agregar(new Persona("Nelly","Ant",50));
		admin.imprimir();
		
		Persona p1=admin.buscarPorNombre("Delia");
		if(p1!=null) {
			System.out.println("Encontrado: "+p1.getNombre()+" "+p1.getEdad());
		}else {
			System.out.println("persona no existe la persona Ely");
		}
		
		ArrayList<Persona> personasMayores=admin.buscarMayores(40);
		System.out.println("Personas encontradas mayores a 25 son: "+personasMayores.size());
	}

}
