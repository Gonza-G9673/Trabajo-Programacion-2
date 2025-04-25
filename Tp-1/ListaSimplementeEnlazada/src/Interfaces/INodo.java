package Interfaces;

import modelo.Nodo;
import modelo.Vehiculo;

public interface INodo  {

    public Nodo getAnterior();
    public void setAnterior(Nodo anterior);
    public Vehiculo getDato();
    public void setDato(Vehiculo dato);
    public Nodo getSiguiente();
    public void setSiguiente(Nodo nodo);

}
