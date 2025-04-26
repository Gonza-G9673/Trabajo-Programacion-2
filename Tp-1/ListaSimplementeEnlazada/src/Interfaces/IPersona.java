package Interfaces;

import modelo.Lista;

public interface IPersona {
    
    public int getDni();
    public void setDni(int dni);
    public String getNombre();
    public void setNombre(String nombre);
    public String toString();
    public Lista getListaVehiculos();
    public void setListaVehiculos(Lista listaVehiculos);
    public void mostrarPersona();
}
