package Interfaces;

import modelo.Vehiculo;

public interface ILista {
    //Se crean las primitivas
    public boolean esVacia();
    public void insertarPrimero(Vehiculo dato);
    public void insertarUltimo(Vehiculo dato);
    public int cantidadElementos();
    public void mostrarLista();
    public void buscarPatente(String d);
    public void buscarModelo(String d);
    public Vehiculo obtenerPrimero();
    public void insertarGenerico(Vehiculo dato, int posicion);
    public void eliminarGenerico(int posicion);
    ///public void ordenar();


}

