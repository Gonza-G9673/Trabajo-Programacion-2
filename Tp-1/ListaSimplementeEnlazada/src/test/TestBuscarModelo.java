package test;
import modelo.Persona;
import modelo.Vehiculo;

public class TestBuscarModelo {
    public static void main(String[] args) {
        Persona p = new Persona(47426621, "Agostina");
        Vehiculo v1 = new Vehiculo("AA 123 CD", "Peugeot 208");
        Vehiculo v2 = new Vehiculo("AA 456 CD", "Ford a");
        Vehiculo v3 = new Vehiculo("AA 789 CD", "Honda civic");

        p.getListaVehiculos().insertarPrimero(v1);
        p.getListaVehiculos().insertarUltimo(v2);
        p.getListaVehiculos().insertarUltimo(v3);

        p.mostrarPersona();

        p.getListaVehiculos().buscarModelo("Peugeot 208");
        p.getListaVehiculos().buscarModelo("Ford a");
        p.getListaVehiculos().buscarModelo("Honda civic");



    }
}
