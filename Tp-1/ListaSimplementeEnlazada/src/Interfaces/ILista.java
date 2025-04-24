package Interfaces;

import modelo.Vehiculo;

public interface ILista {
    //Se crean las primitivas
    public boolean esVacia();
    public void insertarPrimero(Vehiculo dato);
    public void insertarUltimo(Vehiculo dato);
    public Vehiculo obtenerPrimero();
    public int cantidadElementos();
    public void mostrarLista();
    ///public void insertarGenerico();
    ///public void eliminarGenerico();
    ///public void ordenar();
    /// public void buscar();

}

