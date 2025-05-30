package test;

import modelo.Persona;
import interfaces.ICompDNI;
import interfaces.ICompNombre;
import interfaces.IArbol;
import modelo.Arbol;

public class testArbol {

		//Este es el testeo general, en el cual se prueban todos los métodos del árbol binario de búsqueda.
	public static void main(String[] args) {
		// Se crean varias personas con DNI y nombre para probar el árbol binario de búsqueda.
		// Se insertan en el árbol y se realizan búsquedas, eliminaciones y recorridos para verificar su funcionamiento.
		Persona[] personas = {

				new Persona(47123321, "Pilar"),
				new Persona(20122234, "Agostina"),
				new Persona(46123456, "Gonzalo"),
				new Persona(47865123, "Juan"),
				new Persona(24123321, "Victoria"),
				new Persona(12345643, "Nicolás"),
				new Persona(54345322, "Carlos"),
				new Persona(23454326, "Joaquin"),
				new Persona(12334322, "Esteban"),
				new Persona(17345436, "Valentín"),
				new Persona(47345654, "Fernando"),
				new Persona(22345324, "Bautista"),
				new Persona(19346274, "Salvador"),
				new Persona(69482762, "Lola"),
				new Persona(23387533, "Ricardo"),

		};

		ICompDNI cmpDni = new ICompDNI(); // Comparador de DNI
		ICompNombre cmpNombre = new ICompNombre(); // Comparador de Nombre

		IArbol<Persona> ArbolDNI = new Arbol<>(); // Árbol ordenado por DNI
		IArbol<Persona> ArbolNombre = new Arbol<>(); // Árbol ordenado por Nombre

		for (Persona p : personas) { // Recorre el array de personas
			ArbolDNI.insertar(p, cmpDni); // Inserta en el árbol ordenado por DNI
			ArbolNombre.insertar(p, cmpNombre); // Inserta en el árbol ordenado por Nombre
		}

		System.out.println("\n========== ÁRBOL ORDENADO POR NOMBRE ==========");
		System.out.println("\n--- Recorrido PreOrder ---");
		ArbolNombre.recorridoPreOrder(); // Recorrido PreOrder del árbol ordenado por Nombre
		System.out.println("\n--- Recorrido InOrder ---");
		ArbolNombre.recorridoInOrder(); // Recorrido InOrder del árbol ordenado por Nombre
		System.out.println("\n--- Recorrido PostOrder ---");
		ArbolNombre.recorridoPostOrder(); // Recorrido PostOrder del árbol ordenado por Nombre

		System.out.println("\n========== ÁRBOL ORDENADO POR DNI ==========");
		System.out.println("\n--- Recorrido PreOrder ---");
		ArbolDNI.recorridoPreOrder(); // Recorrido PreOrder del árbol ordenado por DNI
		System.out.println("\n--- Recorrido InOrder ---");
		ArbolDNI.recorridoInOrder(); // Recorrido InOrder del árbol ordenado por DNI
		System.out.println("\n--- Recorrido PostOrder ---");
		ArbolDNI.recorridoPostOrder(); // Recorrido PostOrder del árbol ordenado por DNI

		Persona buscada = new Persona(22345324, "Bautista");
		System.out.println("\n========== BÚSQUEDA ==========");
		System.out.println("\nBuscando a: " + buscada); // Persona a buscar
		System.out.println("\n--- En Árbol DNI ---");
		System.out.println("Resultado: " + ArbolDNI.buscar(buscada, cmpDni)); // Resultado de la búsqueda en el árbol ordenado por DNI
		System.out.println("\n--- En Árbol Nombre ---");
		System.out.println("Resultado: " + ArbolNombre.buscar(buscada, cmpNombre)); // Resultado de la búsqueda en el árbol ordenado por Nombre

		Persona pEliminar = new Persona(46123456, "Gonzalo"); // Persona a eliminar
		System.out.println("\n========== ELIMINACIÓN ==========");
		System.out.println("\nEliminando a: " + pEliminar); // Persona a eliminar
		ArbolNombre.eliminar(pEliminar, cmpNombre); // Elimina en el árbol ordenado por Nombre
		ArbolDNI.eliminar(pEliminar, cmpDni); // Elimina en el árbol ordenado por DNI

		System.out.println("\n--- Árbol por Nombre después de eliminar ---");
		System.out.println("\nRecorrido PreOrder:");
		ArbolNombre.recorridoPreOrder(); // Recorrido PreOrder del árbol ordenado por Nombre
		System.out.println("\nRecorrido InOrder:");
		ArbolNombre.recorridoInOrder(); // Recorrido InOrder del árbol ordenado por Nombre
		System.out.println("\nRecorrido PostOrder:");
		ArbolNombre.recorridoPostOrder(); // Recorrido PostOrder del árbol ordenado por Nombre

		System.out.println("\n--- Árbol por DNI después de eliminar ---");
		System.out.println("\nRecorrido PreOrder:");
		ArbolDNI.recorridoPreOrder(); // Recorrido PreOrder del árbol ordenado por DNI
		System.out.println("\nRecorrido InOrder:");
		ArbolDNI.recorridoInOrder(); // Recorrido InOrder del árbol ordenado por DNI
		System.out.println("\nRecorrido PostOrder:");
		ArbolDNI.recorridoPostOrder(); // Recorrido PostOrder del árbol ordenado por DNI
	}

}
