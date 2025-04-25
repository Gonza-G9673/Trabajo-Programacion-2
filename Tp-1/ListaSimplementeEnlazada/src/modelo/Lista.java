package modelo;

import Interfaces.ILista;

public class Lista implements ILista {

    private Nodo primero;


    public Lista() {
        this.primero = null;
    }

    
    public boolean esVacia() {
        return primero == null;
    }

    
    public void insertarPrimero(Vehiculo dato ) {
        Nodo nuevo = new Nodo(dato);
    	if(!esVacia()) {
        nuevo.setSiguiente(primero);
        primero.setAnterior(nuevo);
        primero = nuevo;
    	}else {
    		primero = nuevo;
    	}
    }

    
    public void insertarUltimo(Vehiculo dato) {
        Nodo nuevo = new Nodo(dato);
        if (esVacia()) {
            primero = nuevo;
        } else {
            Nodo actual = primero;
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nuevo);
            nuevo.setAnterior(actual);
        }
    }

  

   
    public Vehiculo obtenerPrimero() {
        if (esVacia()) {
            System.out.println("No se encontro el primero");
        }
        return primero.getDato();

    }


   
    public int cantidadElementos() {
        int contador = 0;
        Nodo actual = primero;

        while (actual != null) {
            contador++;
            actual = actual.getSiguiente();
        }

        return contador;
    }


    public void mostrarLista() {
        Nodo actual = primero;
        while (actual != null) {
            //getDato --- Del Nodo ---- Vehiculo!!
            System.out.print("Actual: " + actual.getDato() + "\n");
            actual = actual.getSiguiente();
        }  
}

    public void buscarPatente(String d) {
        if(!esVacia()){
            Nodo actual = primero;
            int contador = 0;
        while(d != String.valueOf(actual.getDato().getPatente()) & actual.getSiguiente() != null){
            actual = actual.getSiguiente();
            contador ++;
        } if(actual.getSiguiente() == null & String.valueOf(actual.getDato().getPatente()) != d){
            System.out.print("No podemos encontrar lo que buscas!" + "\n");
        } else{
            System.out.print("Lo que buscas esta en la posición " + contador + " !! \n");
        }
        } else{
            System.out.print("La lista está vacía!!! \n");
        }
    }
}


    ///  falta crear
    ///public void insertarGenerico();
    ///public void eliminarGenerico();
    ///public void ordenar();
    /// public void buscar();
