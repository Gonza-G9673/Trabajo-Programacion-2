package test;

import modelo.Persona;
import modelo.Vehiculo;

public class TestInsertar {

    public static void main(String[] args) {
    Persona p = new Persona(20456786, "Victoria");//Se crea la lista nula!!
	Vehiculo v = new Vehiculo("AK 377 RA", "Ferrari");
	Vehiculo v2 = new Vehiculo("KD 590 IH", "Ford Maverick");
	Vehiculo v3 = new Vehiculo("EJ 989 PA", "Limusina alto nivel");
    Vehiculo v4 = new Vehiculo("EJ 989 AA", "Toyota Corolla");

    p.getListaVehiculos().insertarPrimero(v);
	p.getListaVehiculos().insertarPrimero(v2);
	p.getListaVehiculos().insertarUltimo(v3);
	p.mostrarPersona();


    p.getListaVehiculos().insertarGenerico(v4, 2);
    p.getListaVehiculos().insertarGenerico(v4, -3);
    p.getListaVehiculos().insertarGenerico(v, 10);
	p.mostrarPersona();

}

}
