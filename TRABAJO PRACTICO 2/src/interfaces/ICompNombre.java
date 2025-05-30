package interfaces;

import modelo.Persona; // Importamos la clase Persona que contiene los datos de las personas
import java.util.Comparator; // Importamos Comparator para comparar los elementos del árbol

public class ICompNombre implements Comparator<Persona>{ // Definimos la clase ICompNombre que implementa Comparator para comparar objetos de tipo Persona por su nombre
	
	// Pre: Los objetos Persona p1 y p2 están inicializados y tienen un nombre válido.
	// Post: Devuelve un entero que indica la relación entre los nombres de p1 y p2.
	@Override
	public int compare(Persona p1, Persona p2) { // Método que compara dos objetos Persona por su nombre
		return p1.getNombre().compareTo(p2.getNombre()); // Comparamos los nombres de las dos personas y devolvemos el resultado
	}
}