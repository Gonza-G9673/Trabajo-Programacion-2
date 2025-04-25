package test;

import modelo.Persona;
import modelo.Vehiculo;


public class TestGeneral {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Persona p = new Persona(20456786, "Gonza");//Se crea la lista nula!!
		Vehiculo v = new Vehiculo("AC 317 NA", "Eco sport");
		Vehiculo v2 = new Vehiculo("AD 510 IR", "Fiat toro");
		Vehiculo v3 = new Vehiculo("EL 949 PA", "Limusina alto nivel");
		Vehiculo v4 = new Vehiculo("EJ 989 AA", "Toyota Corolla");


		p.getListaVehiculos().insertarPrimero(v);
		p.getListaVehiculos().insertarPrimero(v2);
		p.getListaVehiculos().insertarUltimo(v3);

		p.mostrarPersona();

		p.getListaVehiculos().buscarPatente("AD 510 IR");
		p.getListaVehiculos().buscarPatente("CD 454 AG");
		p.getListaVehiculos().buscarModelo("Fiat Toro");
		p.getListaVehiculos().buscarModelo("Limusina alto nivel");


		p.getListaVehiculos().insertarGenerico(v4, 0);
		p.getListaVehiculos().eliminarGenerico(3);
		p.mostrarPersona();

		///Notar que toda la información quedó guardada en la persona
		///
		///NOTAS: 
		///esto es una ayuda para el tp1, pero tienen muchas cosas que mejorar
		///1 - Hacer y usar una lista doblemente enlazada
		///2 - Testear más metodos, incluso algunos sofisticados como 
		///ordenar y buscar vehiculos
		///3 - El nodo tiene que tener el anterior, ojo que eso modifica los métodos
		///4 - Yo omiti las interfaces para hacer más rapido el ejemplo
		///Ustedes tienen que poner las interfaces y usarlas bien
		///Ningún items es obligatorio, pero cuanto más completo más nota. 
		

	}

}
