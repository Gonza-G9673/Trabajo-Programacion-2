package modelo;

import interfaces.IArbol; // Importamos la interfaz IArbol que define las operaciones del árbol

import java.util.Comparator; // Importamos Comparator para comparar los elementos del árbol
// Comparator es una interfaz de Java que permite definir un orden personalizado para los objetos
// En este caso, se usa para comparar los datos que se insertan en el árbol, ya sea por nombre o por DNI

public class Arbol <T> implements IArbol <T>{ // Definimos la clase Arbol que implementa la interfaz IArbol con un tipo genérico T
	
	private Nodo<T> raiz; // Nodo que representa la raíz del árbol
	
	@Override

	public void insertar (T dato, Comparator<T> cmp) { // Método para insertar un dato en el árbol, recibiendo un dato de tipo T y un comparador para determinar su posición en el árbol
		if (dato == null) { // Verificamos si el dato es nulo
			throw new IllegalArgumentException("El dato no puede ser nulo"); // Si es nulo, lanzamos una excepción
		}
		raiz = insertarRec(raiz, dato, cmp); // Llamamos al método recursivo para insertar el dato en el árbol, comenzando desde la raíz
	}
	
	private Nodo<T> insertarRec(Nodo<T> nodo, T dato, Comparator<T> cmp){ // Método recursivo para insertar un dato en el árbol
		if (nodo == null) { // Si el nodo es nulo, significa que hemos encontrado la posición correcta para insertar el dato
			return new Nodo<>(dato); // Creamos un nuevo nodo con el dato
		}
		if (cmp.compare(dato, nodo.dato) < 0) { // Comparamos el dato con el dato del nodo actual
			nodo.izquierda = insertarRec(nodo.izquierda,dato,cmp); // Si el dato es menor, lo insertamos en la subárbol izquierdo
		} else {
			nodo.derecha = insertarRec(nodo.derecha,dato,cmp);  // Si el dato es mayor o igual, lo insertamos en la subárbol derecho
		}
		return nodo;
	}

	@Override
	public boolean buscar(T dato, Comparator<T> cmp) { // Método para buscar un dato en el árbol, recibiendo un dato de tipo T y un comparador
		return buscarRec (raiz, dato, cmp); // Llamamos al método recursivo para buscar el dato, comenzando desde la raíz
	}
	
	private boolean buscarRec(Nodo<T> nodo, T dato, Comparator<T> cmp) { // Método recursivo para buscar un dato en el árbol
		if (nodo == null) { // Si el nodo es nulo, significa que hemos llegado a una hoja sin encontrar el dato
			return false;
		}
		int comp = cmp.compare(dato, nodo.dato); // Comparamos el dato con el dato del nodo actual
		if (comp == 0){ // Si el dato es igual al dato del nodo actual, significa que hemos encontrado el dato
			return true;
		}else if (comp < 0) { // Si el dato es menor, buscamos en la subárbol izquierdo
			return buscarRec(nodo.izquierda, dato, cmp); // Llamamos recursivamente al método para buscar en la subárbol izquierdo
		}else {
			return buscarRec (nodo.derecha, dato, cmp); // Llamamos recursivamente al método para buscar en la subárbol derecho
		}
	}
	
	@Override 
	public boolean eliminar(T dato, Comparator<T> cmp) { // Método para eliminar un dato del árbol, recibiendo un dato de tipo T y un comparador
		if (!buscar(dato,cmp)) { // Primero verificamos si el dato existe en el árbol
			return false; // Si el dato no existe, no se puede eliminar, por lo que devolvemos false
		}
		raiz = eliminarRec(raiz,dato,cmp); // Llamamos al método recursivo para eliminar el dato, comenzando desde la raíz
		return true; // Si el dato existía y se eliminó correctamente, devolvemos true
	}
	
	private Nodo<T> eliminarRec(Nodo<T> nodo, T dato, Comparator<T> cmp){ // Método recursivo para eliminar un dato del árbol
		if (nodo == null) {
			return null;
		}
		int comp = cmp.compare(dato, nodo.dato); // Comparamos el dato con el dato del nodo actual
		if (comp < 0) {
			nodo.izquierda = eliminarRec(nodo.izquierda,dato,cmp); // Si el dato es menor, buscamos en la subárbol izquierdo
		}else if (comp > 0) {
			nodo.derecha = eliminarRec(nodo.derecha, dato, cmp); // Si el dato es mayor, buscamos en la subárbol derecho
		}else {
			if (nodo.izquierda == null) { // Si el nodo a eliminar no tiene subárbol izquierdo, devolvemos su subárbol derecho
				return nodo.derecha;
			}else if (nodo.derecha == null) { // Si el nodo a eliminar no tiene subárbol derecho, devolvemos su subárbol izquierdo
				return nodo.izquierda;
			}else { // Si el nodo a eliminar tiene ambos subárboles, encontramos el mínimo en el subárbol derecho
				Nodo<T> min = encontrarMin(nodo.derecha);
				nodo.dato = min.dato;
				nodo.derecha = eliminarRec(nodo.derecha, min.dato, cmp);
			}
		}
		return nodo;
	}
	
	private Nodo<T> encontrarMin(Nodo<T> nodo){ // Método para encontrar el nodo con el valor mínimo en un subárbol
		while (nodo.izquierda != null) { // Mientras haya un nodo a la izquierda, seguimos buscando
			nodo = nodo.izquierda;
		}
		return nodo;
	}
	
	
	public void recorridoPreOrder() { // Método para recorrer el árbol en preorden (raíz, izquierda, derecha)
			System.out.print("Pre-order: ");
			preOrderRec(raiz);
			System.out.println();
	}
	
	private void preOrderRec (Nodo<T> nodo) { // Método recursivo para recorrer el árbol en preorden
		if (nodo != null) { // Si el nodo no es nulo, imprimimos su dato
			System.out.print(nodo.dato + " ");
			preOrderRec(nodo.izquierda);
			preOrderRec(nodo.derecha);
		}
	}
	
	
	@Override
	public void recorridoInOrder() { // Método para recorrer el árbol en inorden (izquierda, raíz, derecha)
		System.out.print("InOrder: ");
		inOrderRec(raiz);
		System.out.println();
	}
		
	private void inOrderRec (Nodo<T> nodo) { // Método recursivo para recorrer el árbol en inorden
		if (nodo != null) { // Si el nodo no es nulo, recorremos su subárbol izquierdo, imprimimos su dato y luego recorremos su subárbol derecho
			inOrderRec(nodo.izquierda);
			System.out.print(nodo.dato + " ");
			inOrderRec(nodo.derecha);
		}
	}
	
	@Override
    public void recorridoPostOrder() { // Método para recorrer el árbol en postorden (izquierda, derecha, raíz)
        System.out.print("PostOrder: ");
        postOrderRec(raiz);
        System.out.println();
    }

    private void postOrderRec(Nodo<T> nodo) { // Método recursivo para recorrer el árbol en postorden
        if (nodo != null) { // Si el nodo no es nulo, recorremos su subárbol izquierdo, luego su subárbol derecho y finalmente imprimimos su dato
            postOrderRec(nodo.izquierda);
            postOrderRec(nodo.derecha);
            System.out.print(nodo.dato + " ");
        }
    }
}
