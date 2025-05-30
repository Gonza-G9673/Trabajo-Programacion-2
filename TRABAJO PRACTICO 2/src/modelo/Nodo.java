package modelo; 

public class Nodo <T>  { // Clase Nodo que representa un nodo en un árbol binario genérico, se utiliza un tipo genérico T para que pueda trabajar con cualquier tipo de dato
	
	T dato; // Dato que almacena el valor del nodo, puede ser de cualquier tipo gracias al uso de generics
	
	Nodo<T> derecha; // Nodo que representa el hijo derecho del nodo actual, también es de tipo genérico T para que pueda trabajar con cualquier tipo de dato
	
	Nodo<T> izquierda; // Nodo que representa el hijo izquierdo del nodo actual, también es de tipo genérico T para que pueda trabajar con cualquier tipo de dato
	
	public Nodo (T dato) { // Constructor de la clase Nodo que recibe un dato de tipo T y lo asigna al atributo dato del nodo
		
		this.dato = dato; // Asignamos el dato recibido al atributo dato del nodo
		
		this.derecha = null; // Como es un nuevo nodo, inicialmente no tiene hijos, por lo que los nodos hijo derecho e izquierdo se inicializan como null
		
		this.izquierda = null; // Inicialmente el nodo izquierdo también se inicializa como null
	}

	
}
