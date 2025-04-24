package modelo;

import Interfaces.INodo;

public class Nodo implements INodo {

	private Vehiculo dato;
    private Nodo siguiente; //INodo
    private Nodo anterior;

    public Nodo(Vehiculo dato) {
        this.dato = dato;
        this.siguiente = null;
        this.anterior = null;
    }

    public Nodo(Vehiculo dato, Nodo anterior) {
        this.dato = dato;
        this.siguiente = null;
        this.anterior = anterior;
    }


    public Nodo getAnterior() {
        return anterior;
    }

    public void setAnterior(Nodo anterior) {
        this.anterior = anterior;
    }

    public Vehiculo getDato() {
        return dato;
    }

  
    public void setDato(Vehiculo dato) {
        this.dato = dato;
    }

    
    public Nodo getSiguiente() {
        return siguiente;
    }

   
    public void setSiguiente(Nodo nodo) {
        this.siguiente = nodo;
    }
}
