package modelo;

import Interfaces.ILista;

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
    public void insertarGenerico(Vehiculo dato) {
        Nodo nuevo = new Nodo(dato);
        if(!esVacia()){
            nuevo.setSiguiente(primero);
            primero.setAnterior(nuevo);
            primero = nuevo;

        }
        else{

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
            primero = actual.getSiguiente();
            if (primero != null) {
                primero.setAnterior(null);

            System.out.println("Elemento eliminado en posición 0");
            }
            }
        while (actual != null && buscador < posicion) {
            actual = actual.getSiguiente();
            buscador++;
        }
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
        System.out.println("Elemento eliminado en posicion" + posicion + "." );
        }



    }

    


    ///  falta crear
    ///public void insertarGenerico();
    ///public void eliminarGenerico();
    ///public void ordenar();
