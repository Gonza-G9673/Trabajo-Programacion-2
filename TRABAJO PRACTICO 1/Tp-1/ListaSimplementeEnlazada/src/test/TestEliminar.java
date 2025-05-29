package test;

import modelo.Persona;
import modelo.Vehiculo;

public class TestEliminar {
    public static void main(String[] args) {
        Persona p = new Persona(47426621, "Agostina");
        Vehiculo v1 = new Vehiculo("AA 127 CD", "Peugeot 206");
        Vehiculo v2 = new Vehiculo("AA 456 CD", "Ford a");
        Vehiculo v3 = new Vehiculo("AA 789 CD", "Honda civic");

        p.getListaVehiculos().insertarPrimero(v1);
        p.getListaVehiculos().insertarUltimo(v2);
        p.getListaVehiculos().insertarUltimo(v3);
        p.mostrarPersona();

        p.getListaVehiculos().eliminarGenerico(1);
        p.mostrarPersona();


}
}
