package interfaces; 

import java.util.Comparator; // Importamos Comparator para comparar los elementos del árbol
	//comparator es una librería de Java que permite definir un orden personalizado para los objetos

public interface IArbol<T> { // Definimos la interfaz IArbol con un tipo genérico T
	// Se le pone <T> para que pueda trabajar con cualquier tipo de dato
	

	//Pre: El árbol está inicializado y el comparador es válido.
	//Post: El dato se ha insertado en el árbol en la posición correcta según el comparador.
	void insertar(T dato, Comparator<T> cmp); // Método para insertar un dato en el árbol, usando la librería Comparator para definir el orden
	// El método recibe un dato de tipo T y un comparador para determinar su posición en el árbol, lo mismo para los demás métodos




	// Pre: El árbol está inicializado y el comparador es válido.
	// Post: Devuelve true si el dato se encuentra en el árbol, false en caso contrario.
	boolean buscar(T dato, Comparator<T> cmp); // Método para buscar un dato en el árbol


	// Pre: El árbol está inicializado, el comparador es válido y el dato existe en el árbol.
	// Post: El dato se ha eliminado del árbol si existía, y devuelve true. Si no existía, devuelve false.
	boolean eliminar(T dato, Comparator<T> cmp); // Método para eliminar un dato del árbol


	// Pre: El árbol está inicializado.
	// Post: Se recorre el árbol en preorden, aplicando una acción a cada nodo visitado.
	void recorridoPreOrder(); // Método para recorrer el árbol en preorden (raíz, izquierda, derecha)


	// Pre: El árbol está inicializado.
	// Post: Se recorre el árbol en inorden, aplicando una acción a cada nodo visitado.
	void recorridoInOrder(); // Método para recorrer el árbol en inorden (izquierda, raíz, derecha)

	// Pre: El árbol está inicializado.
	// Post: Se recorre el árbol en postorden, aplicando una acción a cada nodo visitado.
	void recorridoPostOrder(); // Método para recorrer el árbol en postorden (izquierda, derecha, raíz)

}
