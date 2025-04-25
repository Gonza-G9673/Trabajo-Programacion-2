package test;

import modelo.Persona;
import modelo.Vehiculo;

///Listas simplemente enlazadas N - > sig,  ant
///Listas doblemete enlazadas (int)
///Persona que tiene una lista de Vehiculos!!!!

public class TestPersonaVehiculos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Persona p = new Persona(20456786, "Gonza");//Se crea la lista nula!!
		Vehiculo v = new Vehiculo("AC 317 NA", "Eco sport");
		Vehiculo v2 = new Vehiculo("AD 510 IR", "Fiat toro");
		Vehiculo v3 = new Vehiculo("EL 949 PA", "Limusina alto nivel");


		//La primera por parametos, la segunda por referencia
		p.getListaVehiculos().insertarPrimero(v);
		p.getListaVehiculos().insertarPrimero(v2);
		p.getListaVehiculos().insertarUltimo(v3);
		//Muestro la persona, y sus vehiculos concatenados
		//Atentos a cómo manejo el toString de ambos y los
		//procedimientos de mostrar. 
		p.mostrarPersona();

		p.getListaVehiculos().buscar("AD 510 IR");
		p.getListaVehiculos().buscar("CD 454 AG");
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
