package interfaces; 

import modelo.Persona; // Importamos la clase Persona que contiene los datos de las personas
import java.util.Comparator; // Importamos Comparator para comparar los elementos del árbol

public class ICompDNI implements Comparator<Persona>{ // Definimos la clase ICompDNI que implementa Comparator para comparar objetos de tipo Persona por su DNI
	
	@Override

	//Pre: Los objetos Persona p1 y p2 están inicializados y tienen un DNI válido.
	//Post: Devuelve un entero que indica la relación entre los DNIs de p1 y p2.
	public int compare(Persona p1, Persona p2) { // Método que compara dos objetos Persona por su DNI
		// compare es un método de la interfaz Comparator que recibe dos objetos y devuelve un entero
	    return Integer.compare(p1.getDni(), p2.getDni()); // Comparamos los DNIs de las dos personas y devolvemos el resultado
	}
}
