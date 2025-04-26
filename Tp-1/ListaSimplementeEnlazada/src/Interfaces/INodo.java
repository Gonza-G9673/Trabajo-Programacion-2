package Interfaces;

import modelo.Vehiculo;

public interface INodo  {

    public INodo getAnterior();
    public void setAnterior(INodo anterior);
    public Vehiculo getDato();
    public void setDato(Vehiculo dato);
    public INodo getSiguiente();
    public void setSiguiente(INodo nodo);

}
