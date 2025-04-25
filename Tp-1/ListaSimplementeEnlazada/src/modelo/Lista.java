package modelo;

import Interfaces.ILista;
import Interfaces.INodo;

public class Lista implements ILista {

    private INodo primero;


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
            INodo actual = primero;
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
        INodo actual = primero;

        while (actual != null) {
            contador++;
            actual = actual.getSiguiente();
        }

        return contador;
    }


    public void mostrarLista() {
        INodo actual = primero;
        while (actual != null) {
            System.out.print("Actual: " + actual.getDato() + "\n");
            actual = actual.getSiguiente();
        }  
}

    public void buscarPatente(String d) {
        if(!esVacia()){
            INodo actual = primero;
            int contador = 0;
        while(d != String.valueOf(actual.getDato().getPatente()) & actual.getSiguiente() != null){
            actual = actual.getSiguiente();
            contador ++;
        } if(actual.getSiguiente() == null & String.valueOf(actual.getDato().getPatente()) != d){
            System.out.print("No podemos encontrar lo que buscas!" + "\n");
        } else{
            System.out.print("La patente: " + d + " esta en la posición " + contador + " y pertenece al vehiculo " +  actual.getDato().getModelo() + " \n");
        }
        } else{
            System.out.print("La lista está vacía!!! \n");
        }
    }

    public void buscarModelo(String d) {
        if(!esVacia()){
            INodo actual = primero;
            int contador = 0;
        while(d != String.valueOf(actual.getDato().getModelo()) & actual.getSiguiente() != null){
            actual = actual.getSiguiente();
            contador ++;
        } if(actual.getSiguiente() == null & String.valueOf(actual.getDato().getModelo()) != d){
            System.out.print("No podemos encontrar el modelo que buscas! \n");
        } else{
            System.out.print("El modelo: " + d + " esta en la posición " + contador + " y su patente es " + actual.getDato().getPatente() + " \n");
        }
        } else{
            System.out.print("La lista está vacía!!! \n");
        }
    }
    public void insertarGenerico(Vehiculo dato, int posicion) {
        Nodo nuevo = new Nodo(dato);
        if(!esVacia()){
            if(posicion < 0 || posicion > cantidadElementos()){
                System.out.println("Posición inválida");
            } else {
                if(posicion == 0){
                    insertarPrimero(dato);
                }
                INodo actual = primero;
                int pos = 0;
                while(pos < posicion-1 && actual != null){
                    actual = actual.getSiguiente();
                    pos++;
                }
                if (actual == null){
                    System.out.println("Posicion invalida.");
                }
                INodo siguiente = actual.getSiguiente();
                nuevo.setSiguiente(siguiente);

                if (siguiente != null){
                    siguiente.setAnterior(nuevo);
                }
                System.out.println("Vehiculo insertado en la posicion " + posicion);
            }
        }else{
            System.out.println("No hay vehiculos en la lista!");
            primero = nuevo;
        }
    }

    public void eliminarGenerico(int posicion){
        if (esVacia()) {
            System.out.println("La lista esta vacia");
        }
        if (posicion < 0 ){
            System.out.println("Posición invalida");
        }
        INodo actual = primero;
        int buscador = 0;

        if (posicion == 0) {
            INodo datoEliminado = primero;
            primero = actual.getSiguiente();
            System.out.println("Se elimino el primer elemento: " + datoEliminado);
            if (primero != null) {
                primero.setAnterior(null);
            }
            }
        while (actual != null && buscador < posicion) {
            actual = actual.getSiguiente();
            buscador++;
        }
        INodo datoEliminado = actual;
        if (actual == null) {
            System.out.println("Posición fuera de rango");
        }
        INodo anterior = actual.getAnterior();
        INodo siguiente = actual.getSiguiente();

        if (anterior != null) {
            anterior.setSiguiente(siguiente);
        }
        if (siguiente != null) {
            siguiente.setAnterior(anterior);
        }
        System.out.println("Eliminaste " + datoEliminado.getDato().getModelo() + " patente: " + datoEliminado.getDato().getPatente() + " en la posicion " + posicion + "." );
        }

    }

